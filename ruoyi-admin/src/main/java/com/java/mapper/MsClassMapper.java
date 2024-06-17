package com.java.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.MsClass;
import com.java.entity.vo.user.MsClassStudentPageVo;
import org.apache.ibatis.annotations.Param;

public interface MsClassMapper extends BaseMapper<MsClass> {
    Page<MsClassStudentPageVo> queryList(@Param("page") Page<MsClassStudentPageVo> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
