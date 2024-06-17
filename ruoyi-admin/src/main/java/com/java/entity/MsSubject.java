package com.java.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class MsSubject {
  @TableId(type = IdType.AUTO)
  private Long subjectId;
  private String subjectName;
  private String grade;
  private Integer delFlag;


}
