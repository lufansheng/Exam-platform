package com.java.entity.vo.knowledge;

import lombok.Data;

import java.util.List;

@Data
public class MsKnowledgeTreeVo {

  private Integer knowledgeId;

  private String knowledgeName;

  private List<MsKnowledgeTreeVo> child;


}
