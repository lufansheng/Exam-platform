package com.java.Mapping;
import com.java.entity.MsKnowledge;
import com.java.entity.params.knowledge.MsKnowledgeCreate;
import com.java.entity.params.knowledge.MsRootKnowledgeCreate;
import com.java.entity.vo.knowledge.MsKnowledgeVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MsKnowledgeMapping {
    MsKnowledgeMapping INSTANCE = Mappers.getMapper(MsKnowledgeMapping.class);
    MsKnowledge to(MsRootKnowledgeCreate rootCreate);
    MsKnowledge to(MsKnowledgeCreate rootCreate);

    List<MsKnowledgeVo> toList(List<MsKnowledge> list);
}
