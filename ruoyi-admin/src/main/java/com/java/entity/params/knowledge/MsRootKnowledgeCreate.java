package com.java.entity.params.knowledge;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MsRootKnowledgeCreate {

  private String knowledgeName;

  private Long subjectId;




}
