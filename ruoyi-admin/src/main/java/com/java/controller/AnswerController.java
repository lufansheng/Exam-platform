package com.java.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.entity.params.answertestpaper.AnswerTestpaperCreate;

import com.java.entity.params.answertestpaper.MsAnswerTestpaperCorretUpdate;
import com.java.entity.vo.answerTestPaperCorret.MsAnswerTestpaperVo;
import com.java.service.IAnswerTestpaperService;
import com.java.service.IAnswerTestpaperTopicService;
import com.java.utils.Pager;
import com.java.utils.Result;
import com.java.utils.TableData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "答卷管理")
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private IAnswerTestpaperService answerTestpaperService;

    @Autowired
    private IAnswerTestpaperTopicService answerTestpaperTopicService;

    /*
    先提交试卷,得到答题id,给下面批改试卷用
     */
    @PostMapping
    @ApiOperation("试卷提交")
    public Result TestpaperCreate(@RequestBody AnswerTestpaperCreate create){


        return Result.success(answerTestpaperService.createTestpaper(create));
    }

    @ApiOperation("查询批改列表")
    @GetMapping("/list")
    public TableData selectByState(Integer subjectId, Integer state, @Validated Pager pager){
        Page<MsAnswerTestpaperVo> msAnswerTestpaperVoPage = answerTestpaperService.selectTestpaperByStatus(pager, subjectId, state);
        List<MsAnswerTestpaperVo> records = msAnswerTestpaperVoPage.getRecords();
        long total = msAnswerTestpaperVoPage.getTotal();
        return TableData.success(records,total);
    }

    @ApiOperation("批改试卷")
    @PostMapping("/corret")
    public Result corret(@RequestBody MsAnswerTestpaperCorretUpdate update){
        return Result.to(answerTestpaperService.corretScore(update));
    }



}
