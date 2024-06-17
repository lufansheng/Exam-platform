package com.java.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.Mapping.MsClassMapping;
import com.java.entity.MsClass;
import com.java.entity.params.clazz.MsClassCreate;
import com.java.entity.params.clazz.MsClassUpdate;
import com.java.entity.vo.user.MsClassStudentPageVo;
import com.java.service.IClassService;

import com.java.utils.Pager;
import com.java.utils.Result;
import com.java.utils.TableData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "班级管理")
@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private IClassService classService;

//    @ApiOperation("查详情")
//    @GetMapping
//    public Result query(){
//        return Result.success(classService.list());
//    }


    //查询所有班级下面的学生信息
    @ApiOperation("查班级学生详情")
    @GetMapping("/list")
    public TableData<MsClassStudentPageVo> querylist(@Validated Pager pager, String className){
        Page<MsClassStudentPageVo> page = classService.queryList(pager, className);
        List<MsClassStudentPageVo> records = page.getRecords();
        long total = page.getTotal();
        return TableData.success(records,total);
    }

    @ApiOperation("添加")
    @PostMapping
    public Result create(@RequestBody MsClassCreate create){
        MsClass msClass = MsClassMapping.INSTANCE.to(create);
        return Result.to(classService.save(msClass));
    }

    @ApiOperation("修改")
    @PutMapping
    public Result update(@RequestBody MsClassUpdate update){
        MsClass msClass = MsClassMapping.INSTANCE.to(update);
        return Result.to(classService.updateById(msClass));
    }

    @ApiOperation("删除")
    @DeleteMapping("/{classId}")
    public Result delete(@PathVariable Integer classId){
        MsClass msClass = new MsClass();
        msClass.setDelFlag(2);
        msClass.setClassId(classId);
        return Result.to(classService.updateById(msClass));
    }


}
