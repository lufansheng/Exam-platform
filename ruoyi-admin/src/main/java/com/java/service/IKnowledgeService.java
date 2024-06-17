package com.java.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsKnowledge;
import com.java.entity.vo.knowledge.MsKnowledgeTreeVo;

import java.util.List;

public interface IKnowledgeService extends IService<MsKnowledge> {

    List<MsKnowledgeTreeVo> list(Integer subjectId);


}
