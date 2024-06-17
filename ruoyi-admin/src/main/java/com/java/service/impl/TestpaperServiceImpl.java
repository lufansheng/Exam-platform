package com.java.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.MsTestpaper;
import com.java.entity.MsTitle;
import com.java.entity.vo.testpaper.MsTestpaperDtlVo;
import com.java.entity.vo.testpaper.MsTestpaperListVo;
import com.java.entity.vo.title.MsTitleVo;
import com.java.mapper.MsTestpaperMapper;
import com.java.mapper.MsTitleMapper;
import com.java.service.ITestpaperService;
import com.java.utils.Pager;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestpaperServiceImpl extends ServiceImpl<MsTestpaperMapper, MsTestpaper> implements
        ITestpaperService {

    @Autowired
    MsTestpaperMapper msTestpaperMapper;

    @Autowired
    MsTitleMapper msTitleMapper;


    /*
        需求:
            可以传入一些值，然后选择添加标题,往这些标题里传入题目
            添加标题和提交两个接口
            要先添加标题再提交
            第一次添加的时候还没有试卷，此时应该先创建试卷，再添加标题和题目
            以后秩序与往第一次创建试卷返回的试卷id里面添加标题和题目即可

            添加标题和提交要一起生效才行,需要事务
     */
    @Override
    public MsTitleVo createTitle(Integer testPaperId, String titleName) {

        //如果此时还没有这个试卷,就先创建一张空试卷
        if (testPaperId == null){
            MsTestpaper msTestpaper = new MsTestpaper();
            msTestpaperMapper.insert(msTestpaper);
            testPaperId = msTestpaper.getTestpaperId();
        }

        //再去添加标题
        MsTitle msTitle = new MsTitle(null,testPaperId,titleName);
        //使用主键自增的方法,必须要传入一个实体类，实体类里要有主键ID
        msTestpaperMapper.createTitle(msTitle);

        return new MsTitleVo(msTitle.getTitleId(),testPaperId);
    }

    @Override
    public int createTitleTopic(Integer titleId, Integer topicId) {
        //其实就是在表里将标题和题目进行关联

        return msTestpaperMapper.createTitleTopic(titleId,topicId);
    }

    @Override
    public List<MsTestpaperDtlVo> selectList(Integer testpaperId) {
        return msTestpaperMapper.selectTestpaperById(testpaperId);
    }

    @Override
    public Page<MsTestpaperListVo> selectTestpaperVo(Pager pager, String testpaperName, Integer grade, Integer subjectId) {
        System.out.println(testpaperName + " " + grade + " " + subjectId);
        Page<MsTestpaperListVo> page = new Page<>(pager.getPageNum(),pager.getPageSize());
        QueryWrapper<MsTestpaper> qw = new QueryWrapper<>();
        //(两个复选框都选了)
        if (subjectId != null && grade != null){
            //直接按学科Id查
            System.out.println("学科");
            qw.eq("t1.subject_id",subjectId);
        }
        //只传了年级Id(只选了第一个复选框)
        if (subjectId == null && grade != null){
            //根据年级查询所有学科Id
            qw.eq("t2.grade",grade);
            System.out.println("年级");
        }
            qw.ne("t1.del_flag","2");
            qw.like(StringUtils.isNotEmpty(testpaperName),"t1.testpaper_name",testpaperName);
        return msTestpaperMapper.selectTestpaperList(page,qw);
    }

    @Transactional
    @Override
    public int deleteTestpaperById(Integer testpaperId) {
        msTitleMapper.deleteTitle(testpaperId);
        MsTestpaper msTestpaper = new MsTestpaper();
        msTestpaper.setDelFlag("2");
        msTestpaper.setTestpaperId(testpaperId);
        return msTestpaperMapper.updateById(msTestpaper);
    }


}
