package com.java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MsKnowledge {

  @TableId(type = IdType.AUTO)

  private Long knowledgeId;

  private Long parentId;

  private String knowledgeName;

  private Long subjectId;




}
