package com.java.controller;



import com.java.Mapping.MsKnowledgeMapping;
import com.java.entity.MsKnowledge;
import com.java.entity.params.knowledge.MsKnowledgeCreate;
import com.java.entity.params.knowledge.MsRootKnowledgeCreate;
import com.java.entity.vo.knowledge.MsKnowledgeTreeVo;
import com.java.service.IKnowledgeService;
import com.java.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "知识点管理")
@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Autowired
    private IKnowledgeService knowledgeService;


    //todo:查列表(一级知识点树)

    @ApiOperation("添加节点")
    @PostMapping("/create")
    public Result create(@RequestBody MsKnowledgeCreate create){
        MsKnowledge msKnowledge = MsKnowledgeMapping.INSTANCE.to(create);
        return Result.to(knowledgeService.save(msKnowledge));
    }

    @ApiOperation("添加根节点")
    @PostMapping
    public Result createRoot(@RequestBody MsRootKnowledgeCreate create){
        MsKnowledge msKnowledge = MsKnowledgeMapping.INSTANCE.to(create);
        return Result.to(knowledgeService.save(msKnowledge));
    }


    @ApiOperation("删除知识点")
    @DeleteMapping("/{knowledgeId}")
    // TODO: 2024/6/5 删除要注意子节点,假删
    public Result delete(@PathVariable Integer knowledgeId){
        return Result.to(knowledgeService.removeById(knowledgeId));
    }

    @ApiOperation("查询知识点树")
    @GetMapping("/{subjectId}")
    public Result<List<MsKnowledgeTreeVo>> list(@PathVariable Integer subjectId){
        List<MsKnowledgeTreeVo> root = knowledgeService.list(subjectId);
        return Result.success(root);
    }

}
