package com.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.MsSubject;
import com.java.entity.params.subject.MsSubjectPageVo;
import com.java.mapper.MsSubjectMapper;
import com.java.service.ISubjectService;
import com.java.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends ServiceImpl<MsSubjectMapper, MsSubject> implements
        ISubjectService {

    @Autowired
    MsSubjectMapper msSubjectMapper;

    @Override
    public Page<MsSubjectPageVo> queryList(Pager pager, Integer grade) {
        Page<MsSubjectPageVo> page = new Page<>(pager.getPageNum(),pager.getPageSize());
        QueryWrapper<MsSubjectPageVo> qw = new QueryWrapper<>();
        qw.eq(grade != null,"t1.grade",grade);
        qw.ne("t1.del_flag",2);
        Page<MsSubjectPageVo> msSubjectPageVoPage = msSubjectMapper.queryList(page,qw);
        return msSubjectPageVoPage;
    }

}
