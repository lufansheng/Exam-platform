package com.java.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsAnswerTestpaper;
import com.java.entity.MsAnswerTopic;
import com.java.entity.params.answertestpaper.AnswerTestpaperCreate;
import com.java.entity.params.answertestpaper.MsAnswerTestpaperCorretUpdate;

import com.java.entity.vo.answerTestPaperCorret.MsAnswerTestpaperVo;
import com.java.utils.Pager;

import java.util.List;

public interface IAnswerTestpaperService extends IService<MsAnswerTestpaper> {
    int createTestpaper(AnswerTestpaperCreate create);

    Page<MsAnswerTestpaperVo> selectTestpaperByStatus(Pager pager,
                                                      Integer subjectId,
                                                      Integer state);

    int corretScore(MsAnswerTestpaperCorretUpdate update);
}
