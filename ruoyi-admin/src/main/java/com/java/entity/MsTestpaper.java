package com.java.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsTestpaper {

  @TableId(type = IdType.AUTO)
  private Integer testpaperId;
  private Long types;
  private Long subjectId;
  private Long duration;
  private String testpaperName;
  private String delFlag;
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



}
