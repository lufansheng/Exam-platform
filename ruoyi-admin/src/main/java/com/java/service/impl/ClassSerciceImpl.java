package com.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.MsClass;
import com.java.entity.vo.user.MsClassStudentPageVo;
import com.java.mapper.MsClassMapper;
import com.java.service.IClassService;
import com.java.utils.Pager;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassSerciceImpl extends ServiceImpl<MsClassMapper, MsClass> implements
        IClassService {

    @Autowired
    MsClassMapper msClassMapper;

    @Override
    public Page<MsClassStudentPageVo> queryList(Pager pager, String className) {
        Page<MsClassStudentPageVo> page = new Page<>(pager.getPageNum(),pager.getPageSize());
        QueryWrapper<MsClassStudentPageVo> qw = new QueryWrapper<>();
        qw.like(StringUtils.isNotEmpty(className),"t1.class_name",className);
        qw.ne("t1.del_flag",2);
        Page<MsClassStudentPageVo> studentList = msClassMapper.queryList(page,qw);
        return studentList;
    }
}
