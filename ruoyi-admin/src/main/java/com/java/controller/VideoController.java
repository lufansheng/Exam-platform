package com.java.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.Mapping.MsVideoMapping;
import com.java.entity.MsVideo;
import com.java.entity.params.video.MsVideoCreate;

import com.java.entity.params.video.MsVideoUpdate;
import com.java.entity.vo.video.MsVideoPageVo;
import com.java.service.IVideoService;
import com.java.utils.Pager;
import com.java.utils.Result;
import com.java.utils.TableData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "视频管理")
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private IVideoService videoService;

//
    @ApiOperation("查详情")
    @GetMapping("/{videoId}")
    public Result<MsVideo> queryByGrade(@PathVariable Integer videoId){
        MsVideo msVideo = videoService.getById(videoId);

        return Result.success(MsVideoMapping.INSTANCE.dtl(msVideo));
    }

    //todo:假删
    //查询所有视频下面的学生信息
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public TableData<MsVideoPageVo> querylist(@Validated Pager pager, Integer grade){
        Page<MsVideoPageVo> page = videoService.selectPageByGrade(pager, grade);
        List<MsVideoPageVo> records = page.getRecords();
        long total = page.getTotal();
        return TableData.success(records,total);
    }

    @ApiOperation("添加视频")
    @PostMapping
    public Result create(@RequestBody MsVideoCreate create){
        MsVideo msVideo = MsVideoMapping.INSTANCE.to(create);
        return Result.to(videoService.save(msVideo));
    }
    @ApiOperation("修改")
    @PutMapping
    public Result update(@RequestBody MsVideoUpdate update){
        MsVideo msVideo = MsVideoMapping.INSTANCE.toUpdate(update);
        return Result.to(videoService.updateById(msVideo));
    }
//
//    //todo:假删
    @ApiOperation("删除")
    @DeleteMapping("/{videoId}")
    public Result delete(@PathVariable Integer videoId){
        MsVideo msVideo = new MsVideo();
        msVideo.setDelFlag(2);
        msVideo.setVideoId(videoId);
        return Result.to(videoService.updateById(msVideo));
    }


}
