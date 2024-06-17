package com.java.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.entity.MsKnowledge;
import com.java.entity.vo.knowledge.MsKnowledgeTreeVo;

import java.util.List;

public interface MsKnowledgeMapper extends BaseMapper<MsKnowledge> {
    List<MsKnowledgeTreeVo> getRoot(Integer subjectId);
    List<MsKnowledgeTreeVo> getChild(Integer parentId);
}
