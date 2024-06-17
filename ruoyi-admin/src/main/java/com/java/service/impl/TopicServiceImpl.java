package com.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.MsSubject;
import com.java.entity.MsTopic;
import com.java.entity.vo.topic.MsTopicSelectPageVo;
import com.java.mapper.MsSubjectMapper;
import com.java.mapper.MsTopicMapper;
import com.java.service.ITopicService;
import com.java.utils.Pager;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl extends ServiceImpl<MsTopicMapper, MsTopic> implements
        ITopicService {

    @Autowired
    MsTopicMapper msTopicMapper;

    @Autowired
    MsSubjectMapper msSubjectMapper;


    @Override
    public Page<MsTopicSelectPageVo> queryList(Pager pager, String stem,Integer grade, Integer subjectId, Integer type) {

        Page<MsTopicSelectPageVo> page = new Page<>(pager.getPageNum(),pager.getPageSize());
        QueryWrapper<MsTopic> qwTopic = new QueryWrapper<>();
        LambdaQueryWrapper<MsSubject> qwSubject = new LambdaQueryWrapper<>();

        //(两个复选框都选了)
        if (subjectId != null && grade != null){
            //直接按学科Id查
            qwTopic.eq("t1.subject_id",subjectId);
        }

        //只传了年级Id(只选了第一个复选框)
        if (subjectId == null && grade != null){
            //根据年级查询所有学科Id
            qwSubject.eq(MsSubject::getGrade,grade);
            List<MsSubject> msSubjects = msSubjectMapper.selectList(qwSubject);
            List<Long> list = new ArrayList<>();
            for (MsSubject msSubject : msSubjects) {
                list.add(msSubject.getSubjectId());
            }

            //该年级必须要有学科才能去筛选
            if (!list.isEmpty()){
                qwTopic.in("t1.subject_id",list);
            } else {
                return new Page<>();
            }

        }

        //剩下的情况直接放入qwToic就行
        qwTopic.like(StringUtils.isNotEmpty(stem),"t1.stem",stem);
        qwTopic.eq(type != null,"t1.types",type);
        qwTopic.ne("t1.del_flag",2);
        return msTopicMapper.queryList(page, qwTopic);
    }
}
