package com.java.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java.Mapping.MsSubjectMapping;
import com.java.entity.MsSubject;
import com.java.entity.params.subject.MsSubjectCreate;
import com.java.entity.params.subject.MsSubjectPageVo;
import com.java.entity.params.subject.MsSubjectUpdate;
import com.java.entity.params.subject.MsSubjectVo;
import com.java.service.ISubjectService;
import com.java.utils.Pager;
import com.java.utils.Result;
import com.java.utils.TableData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "学科管理")
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;



//    @ApiOperation("查详情")
//    @GetMapping
//    public Result query(){
//        return Result.success(subjectService.list());
//    }

    @ApiOperation("根据年级查询学科")
    @GetMapping("/{grade}")
    public Result queryByGrade(@PathVariable Integer grade){
        LambdaQueryWrapper<MsSubject> qw = new LambdaQueryWrapper<>();
        qw.eq(MsSubject::getGrade,grade);
        qw.ne(MsSubject::getDelFlag,2);
        List<MsSubjectVo> subjectList =
        MsSubjectMapping.INSTANCE.toList(subjectService.list(qw));
        return Result.success(subjectList);
    }

    //todo:假删
    //查询所有学科下面的学生信息
    @ApiOperation("查学科学生详情")
    @GetMapping("/list")
    public TableData<MsSubjectPageVo> querylist(@Validated Pager pager, Integer grade){
        Page<MsSubjectPageVo> page = subjectService.queryList(pager, grade);
        List<MsSubjectPageVo> records = page.getRecords();
        long total = page.getTotal();
        return TableData.success(records,total);
    }

    @ApiOperation("添加学科")
    @PostMapping
    public Result create(@RequestBody MsSubjectCreate create){
        LambdaQueryWrapper<MsSubject> qw = new LambdaQueryWrapper<>();
        qw.eq(MsSubject::getGrade,create.getGrade());
        qw.eq(MsSubject::getSubjectName,create.getSubjectName());
        List<MsSubject> list = subjectService.list(qw);
        if (list.isEmpty()){
            MsSubject msSubject = MsSubjectMapping.INSTANCE.to(create);
            return Result.to(subjectService.save(msSubject));
        }
        return Result.error("该学科已经存在");
    }

    @ApiOperation("修改")
    @PutMapping
    public Result update(@RequestBody MsSubjectUpdate update){
        LambdaQueryWrapper<MsSubject> qw = new LambdaQueryWrapper<>();
        qw.eq(MsSubject::getGrade,update.getGrade());
        qw.eq(MsSubject::getSubjectName,update.getSubjectName());
        List<MsSubject> list = subjectService.list(qw);
        if (list.isEmpty()){
            MsSubject msSubject = MsSubjectMapping.INSTANCE.to(update);
            return Result.to(subjectService.updateById(msSubject));
        }
        return Result.error("该学科已经存在");
    }

    //todo:假删
    @ApiOperation("删除")
    @DeleteMapping("/{subjectId}")
    public Result delete(@PathVariable Long subjectId){
        MsSubject msSubject = new MsSubject();
        msSubject.setDelFlag(2);
        msSubject.setSubjectId(subjectId);
        return Result.to(subjectService.updateById(msSubject));
    }


}
