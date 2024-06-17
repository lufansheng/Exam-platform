package com.java.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.MsTestpaper;
import com.java.entity.MsTitle;
import com.java.entity.vo.testpaper.MsTestpaperDtlVo;
import com.java.entity.vo.testpaper.MsTestpaperListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsTestpaperMapper extends BaseMapper<MsTestpaper> {
    int createTitle(MsTitle msTitle);

    int createTitleTopic(@Param("titleId") Integer titleId,@Param("topicId") Integer topicId);

    List<MsTestpaperDtlVo> selectTestpaperById(Integer testpaperId);

    Page<MsTestpaperListVo> selectTestpaperList(@Param("page") Page<MsTestpaperListVo> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
