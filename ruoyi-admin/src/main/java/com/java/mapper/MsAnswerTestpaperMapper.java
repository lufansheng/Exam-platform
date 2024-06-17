package com.java.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.MsAnswerTestpaper;
import com.java.entity.vo.answerTestPaperCorret.MsAnswerTestpaperVo;
import org.apache.ibatis.annotations.Param;

public interface MsAnswerTestpaperMapper extends BaseMapper<MsAnswerTestpaper> {

    Page<MsAnswerTestpaperVo> selectTestpaperByStatus(@Param("page") Page<MsAnswerTestpaperVo> page,
                                   @Param(Constants.WRAPPER) Wrapper wrapper);

//    int updateAnswerTestpaper()
}
