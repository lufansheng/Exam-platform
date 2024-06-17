package com.java.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.Mapping.MsAnswerTestpaperMapping;
import com.java.Mapping.MsAnswerTopicMapping;
import com.java.entity.MsAnswerTestpaper;
import com.java.entity.MsAnswerTopic;
import com.java.entity.params.answertestpaper.AnswerTestpaperCreate;

import com.java.entity.params.answertestpaper.AnswerTestpaperUpdate;
import com.java.entity.params.answertestpaper.MsAnswerTestpaperCorretUpdate;
import com.java.entity.params.answertopic.AnswerTopicUpdate;

import com.java.entity.params.answertopic.MsAnswerTopicUpdate;
import com.java.entity.vo.answerTestPaperCorret.MsAnswerTestpaperVo;
import com.java.entity.vo.answertopic.MsAnswertopicVo;
import com.java.mapper.MsAnswerTestpaperMapper;
import com.java.mapper.MsAnswerTopicMapper;
import com.java.service.IAnswerTestpaperService;
import com.java.service.IAnswerTestpaperTopicService;
import com.java.utils.Pager;
import com.java.utils.equal;
import com.ruoyi.common.core.domain.R;
import lombok.Data;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnswerTestpaperImpl extends ServiceImpl<MsAnswerTestpaperMapper, MsAnswerTestpaper> implements
        IAnswerTestpaperService {


    @Autowired
    private MsAnswerTestpaperMapper msAnswerTestpaperMapper;

    @Autowired
    private MsAnswerTopicMapper msAnswerTopicMapper;

    @Transactional
    @Override
    public int createTestpaper(AnswerTestpaperCreate create) {
        MsAnswerTestpaper msAnswerTestpaper = MsAnswerTestpaperMapping.INSTANCE.to(create);
        //先创建试卷
        msAnswerTestpaperMapper.insert(msAnswerTestpaper);

        //获取试卷Id
        Integer answerTestpaperId = msAnswerTestpaper.getAnswerTestpaperId();


        //根据答卷id,去生成做题的记录
        msAnswerTopicMapper.insertTopic(answerTestpaperId,create.getAnswerTopicCreates());

        //获取刚刚插入的答题记录
        List<MsAnswertopicVo> msAnswertopicVo = msAnswerTopicMapper.selectTopicList(answerTestpaperId);

        //只自动批改客观题
        //todo:从数据库中查询
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (MsAnswertopicVo answertopicVo : msAnswertopicVo) {

            if (list.contains(answertopicVo.getTypes())){
                //数据库里的json对象
                String answer = answertopicVo.getAnswer();
                String standarAnswer = answertopicVo.getStandarAnswer();

                String[] answers = JSONObject.parseObject(answer,String[].class);
                String[] standarAnswers = JSONObject.parseObject(standarAnswer,String[].class);

                //判断客观题答案是否正确
                int res = equal.equalityOfArrays(answers, standarAnswers);
                AnswerTopicUpdate update = new AnswerTopicUpdate();
                update.setAnswerTopicId(answertopicVo.getAnswerTopicId());
                if (res == 0) {
                    update.setIsRight(0);
                    update.setScore(0);
                }
                if (res == 1) {
                    update.setScore(answertopicVo.getScoreTotal() / 2);
                    update.setIsRight(0);
                }
                if (res == 2) {
                    update.setScore(answertopicVo.getScoreTotal());
                    update.setIsRight(1);
                }

                msAnswerTopicMapper.updateById(MsAnswerTopicMapping.INSTANCE.to(update));
            }

        }
        updateAnswerTestpaper(answerTestpaperId);
        return 1;
    }

    @Override
    public Page<MsAnswerTestpaperVo> selectTestpaperByStatus(Pager pager, Integer subjectId, Integer state) {
        QueryWrapper<MsAnswerTestpaperVo> qw = new QueryWrapper<>();
        Page<MsAnswerTestpaperVo> page = new Page<>(pager.getPageNum(),pager.getPageSize());
        qw.eq(state != null,"t1.state",state);
        qw.eq(subjectId != null,"t3.subject_id",subjectId);
        return msAnswerTestpaperMapper.selectTestpaperByStatus(page,qw);
    }

    @Transactional
    @Override
    public int corretScore(MsAnswerTestpaperCorretUpdate update) {

        //这里只传入主观题的id和分数,如果拿了满分,就更新
        for (MsAnswerTopicUpdate msAnswerTestpaperUpdateVo : update.getUpdates()) {
            int scoreTotal = msAnswerTopicMapper.getIsEqual(msAnswerTestpaperUpdateVo.getAnswerTopicId());
            int isRight = 0;
            if (scoreTotal == msAnswerTestpaperUpdateVo.getScore()) isRight = 1;
            AnswerTopicUpdate update1 = new AnswerTopicUpdate(msAnswerTestpaperUpdateVo.getAnswerTopicId(),
                    isRight,msAnswerTestpaperUpdateVo.getScore());
            msAnswerTopicMapper.updateById(MsAnswerTopicMapping.INSTANCE.to(update1));
        }

        updateAnswerTestpaper(update.getAnswerTestpaperId());
        return 1;
    }

    /*
    执行这一步前，要先把答题记录先批改好
     */
    public void updateAnswerTestpaper(Integer answerTestpaperId){
        List<MsAnswertopicVo> msAnswertopicVos = msAnswerTopicMapper.selectTopicList(answerTestpaperId);

        //更新答卷记录缺失的部分
        Integer scoreTotal = 0; //所有答卷满分
        Integer score = 0;  //该同学拿的分
        Integer topicRight = 0; //该同学答对几题
        Integer topicTotal = msAnswertopicVos.size();   //题目数量
        Integer state = 1;  //是否已经批改
        for (MsAnswertopicVo msAnswertopicVo : msAnswertopicVos) {
            scoreTotal += msAnswertopicVo.getScoreTotal();

            score += msAnswertopicVo.getScore() == null ? 0: msAnswertopicVo.getScore();
            topicRight += msAnswertopicVo.getIsRight() == null ? 0 : msAnswertopicVo.getIsRight();
            if (msAnswertopicVo.getScore() == null) state = 0;
        }

        //更新答卷记录
        AnswerTestpaperUpdate update = new AnswerTestpaperUpdate(answerTestpaperId,scoreTotal,score,topicRight,topicTotal,state);

        msAnswerTestpaperMapper.updateById(MsAnswerTestpaperMapping.INSTANCE.toUpdate(update));
    }
}
