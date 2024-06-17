package com.java.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.Mapping.MsTopicMapping;
import com.java.entity.MsTopic;
import com.java.entity.params.topic.MsTopicCreate;
import com.java.entity.params.topic.MsTopicUpdate;
import com.java.entity.vo.topic.MsTopicDtlVo;
import com.java.entity.vo.topic.MsTopicSelectPageVo;
import com.java.service.ITopicService;
import com.java.utils.Pager;
import com.java.utils.Result;
import com.java.utils.TableData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo:添加分成不同题型
@Api(tags = "题目管理")
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private ITopicService topicService;

    //todo:添加题目分开写
    @ApiOperation("添加")
    @PostMapping
    public Result create(@RequestBody MsTopicCreate create){
        MsTopic msTopic = MsTopicMapping.INSTANCE.to(create);

        return Result.to(topicService.save(msTopic));
    }

    @ApiOperation("修改")
    @PutMapping
    public Result update(@RequestBody MsTopicUpdate update){
        MsTopic msTopic = MsTopicMapping.INSTANCE.to(update);
        return Result.to(topicService.updateById(msTopic));
    }

    @ApiOperation("查详情")
    @GetMapping("/selectById/topicId")
    public Result<MsTopicDtlVo> query(Integer topictId){

        LambdaQueryWrapper<MsTopic> qw = new LambdaQueryWrapper<>();
        qw.eq(MsTopic::getTopicId,topictId);
        qw.ne(MsTopic::getDelFlag,2);
        MsTopicDtlVo to = MsTopicMapping.INSTANCE.to(topicService.getOne(qw));
        return Result.success(to);
    }


    //todo:根据创建时间排序，假删
    //查询所有题目下面的学生信息
    @ApiOperation("查题目详情(分页)")
    @GetMapping("/list")
    public TableData<MsTopicSelectPageVo> querylist(Pager pager,String stem, Integer grade, Integer subjectId, Integer type){
        Page<MsTopicSelectPageVo> page = topicService.queryList(pager,stem, grade, subjectId, type);
        List<MsTopicSelectPageVo> records = page.getRecords();
        long total = page.getTotal();
        return TableData.success(records,total);
    }






    @ApiOperation("删除")
    @DeleteMapping("/{topicId}")
    public Result delete(@PathVariable Long topicId){
        MsTopic msTopic = new MsTopic();
        msTopic.setDelFlag(2);
        msTopic.setTopicId(topicId);
        return Result.to(topicService.updateById(msTopic));
    }


}
