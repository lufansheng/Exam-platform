package com.java.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.MsSubject;
import com.java.entity.params.subject.MsSubjectPageVo;
import org.apache.ibatis.annotations.Param;

public interface MsSubjectMapper extends BaseMapper<MsSubject> {
    Page<MsSubjectPageVo> queryList(@Param("page") Page<MsSubjectPageVo> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
