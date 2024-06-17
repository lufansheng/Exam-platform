package com.java.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsClass;
import com.java.entity.vo.user.MsClassStudentPageVo;
import com.java.utils.Pager;

public interface IClassService extends IService<MsClass> {

    Page<MsClassStudentPageVo> queryList(Pager pager, String className);

}
