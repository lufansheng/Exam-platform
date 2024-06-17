package com.java.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsSubject;
import com.java.entity.params.subject.MsSubjectPageVo;
import com.java.utils.Pager;

public interface ISubjectService extends IService<MsSubject> {

    Page<MsSubjectPageVo> queryList(Pager pager, Integer grade);

}
