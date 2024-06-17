package com.java.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.MsTopic;
import com.java.entity.vo.topic.MsTopicSelectPageVo;
import org.apache.ibatis.annotations.Param;

public interface MsTopicMapper extends BaseMapper<MsTopic> {
    Page<MsTopicSelectPageVo> queryList(@Param("page") Page<MsTopicSelectPageVo> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
