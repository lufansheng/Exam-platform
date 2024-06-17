package com.java.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsTopic {

  @TableId(type = IdType.AUTO)
  private Long topicId;
  private Long subjectId;
  private Long types;
  private String stem;
  private String optionss;
  private String answer;
  private String analysis;
  private Integer score;
  private Integer difficulty;
  private Long knowledgeId;
  @TableField(fill = FieldFill.INSERT)
  private String createBy;

  @TableField(fill = FieldFill.INSERT)
  private Date createTime;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private String updateBy;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  //设置返回格式
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;

  private Integer delFlag;


}
