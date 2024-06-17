package com.java.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.MsVideo;
import com.java.entity.vo.video.MsVideoPageVo;
import org.apache.ibatis.annotations.Param;

public interface MsVideoMapper extends BaseMapper<MsVideo> {

    Page<MsVideoPageVo> selectPageByGrade(@Param("pageVoPage") Page<MsVideoPageVo> pageVoPage
            ,@Param(Constants.WRAPPER) Wrapper wrapper);
}
