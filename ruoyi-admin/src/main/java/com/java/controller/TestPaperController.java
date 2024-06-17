package com.java.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.Mapping.MsTestpaperMapping;
import com.java.Mapping.MsTitleMapping;
import com.java.entity.MsTitle;
import com.java.entity.params.testpaper.MsCreateTestpaper;
import com.java.entity.params.testpaper.MsTestpaperPage;
import com.java.entity.params.title.MsTitleCreate;
import com.java.entity.params.title.MsTitleUpdate;
import com.java.entity.params.topic.MsTitleTopicCreate;
import com.java.entity.vo.testpaper.MsTestpaperDtlVo;
import com.java.entity.vo.testpaper.MsTestpaperListVo;
import com.java.service.ITestpaperService;
import com.java.service.ITitleService;
import com.java.utils.Pager;
import com.java.utils.Result;
import com.java.utils.TableData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "卷库管理")
@RestController
@RequestMapping("/testpaper")
public class TestPaperController {

    @Autowired
    private ITestpaperService testpaperService;

    @Autowired
    private ITitleService titleService;

    @ApiOperation("创建标题")
    @PostMapping("/title")
    public Result createTitle(@RequestBody MsTitleCreate create){
        return Result.success(testpaperService.createTitle(create.getTestPaperId(),create.getTitleName()));
    }

    @ApiOperation("添加题目")
    @PostMapping("/topic")
    public Result createTitleTopic(@RequestBody MsTitleTopicCreate create){

        return Result.success(testpaperService.createTitleTopic(create.getTitleId(),create.getTopicId()));
    }

    @ApiOperation("创建试卷")
    @PostMapping("/testPaper")
    public Result createTestpaper(@RequestBody MsCreateTestpaper createTestpaper){
       return Result.to(testpaperService.updateById(MsTestpaperMapping.INSTANCE.to(createTestpaper)));
    }

    @ApiOperation("删除标题")
    @DeleteMapping("/title/{titleId}")
    public Result deleteTitleTopics(@PathVariable Integer titleId){
        //对应的关系也要全部删掉
        return Result.to(titleService.deleteTitleTopicsById(titleId));
    }

    @ApiOperation("删除标题题目")
    @DeleteMapping("/title")
    public Result deleteTitleTopic(Integer titleId,Integer topicId){
        //对应的关系也要全部删掉
        return Result.to(titleService.deleteTitleTopicById(titleId,topicId));
    }

    @ApiOperation("修改标题名字")
    @PutMapping("/title")
    public Result deleteTitleTopic(@RequestBody MsTitleUpdate update){
        //对应的关系也要全部删掉
        MsTitle ms = MsTitleMapping.INSTANCE.to(update);
        return Result.to(titleService.updateById(ms));
    }

    @ApiOperation("获取试卷详情")
    @GetMapping("/{testpaperId}")
    public Result<List<MsTestpaperDtlVo>> getTestpaperDetail(@PathVariable Integer testpaperId){
        return Result.success(testpaperService.selectList(testpaperId));
    }

    @ApiOperation("获取试卷列表")
    @GetMapping("/list")
    public TableData<MsTestpaperListVo> getTestpaperList(@Validated Pager pager, MsTestpaperPage select){
        Page<MsTestpaperListVo> msTestpaperListVoPage = testpaperService.selectTestpaperVo(pager, select.getTestpaperName(), select.getGrade(), select.getSubjectId());
        List<MsTestpaperListVo> records = msTestpaperListVoPage.getRecords();
        long total = msTestpaperListVoPage.getTotal();
        return TableData.success(records,total);
    }

    @ApiOperation("试卷删除")
    @DeleteMapping("/{testpaperId}")
    public Result deleteTestpaperById(@PathVariable Integer testpaperId){
        return Result.to(testpaperService.deleteTestpaperById(testpaperId));
    }


}
