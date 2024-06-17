package com.java.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.Mapping.MsSubjectMapping;
import com.java.Mapping.MsTaskMapping;
import com.java.entity.MsSubject;
import com.java.entity.MsTask;
import com.java.entity.params.subject.MsSubjectCreate;
import com.java.entity.params.subject.MsSubjectPageVo;
import com.java.entity.params.subject.MsSubjectUpdate;
import com.java.entity.params.subject.MsSubjectVo;
import com.java.entity.params.task.MsTaskCreate;
import com.java.entity.params.task.MsTaskUpdate;
import com.java.entity.vo.task.MsTaskDtlVo;
import com.java.entity.vo.task.MsTaskListVo;
import com.java.service.ISubjectService;
import com.java.service.ITaskService;
import com.java.utils.Pager;
import com.java.utils.Result;
import com.java.utils.TableData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "任务管理")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping
    @ApiOperation("获取任务列表")
    public TableData<MsTaskListVo> getTaskList(@Validated Pager p, Integer grade){
        Page<MsTask> taskList = taskService.getTaskList(p, grade);
        List<MsTaskListVo> to = MsTaskMapping.INSTANCE.to(taskList.getRecords());
        long total = taskList.getTotal();
        return TableData.success(to,total);
    }

    @DeleteMapping("/{taskId}")
    @ApiOperation("删除任务")
    public Result getTaskList(@PathVariable Integer taskId){
        return Result.to(taskService.deleteById(taskId));
    }

    @GetMapping("/{taskId}")
    @ApiOperation("查询任务详情")
    public Result<MsTaskDtlVo> getTaskDtlVo(@PathVariable Integer taskId){

        return Result.success(taskService.getTaskDtlById(taskId));
    }

    @PostMapping
    @ApiOperation("添加任务")
    public Result createTask(@RequestBody MsTaskCreate create){

        return Result.to(taskService.createTask(create));
    }

    @PutMapping
    @ApiOperation("修改任务")
    public Result createTask(@RequestBody MsTaskUpdate update){

        return Result.to(taskService.updateTask(update));
    }

}
