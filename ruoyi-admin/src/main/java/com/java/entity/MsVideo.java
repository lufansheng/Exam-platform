package com.java.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsVideo {

  @TableId(type = IdType.AUTO)
  private Integer videoId;
  private Integer subjectId;
  private String videoName;
  private String posterUrl;
  private String videoUrl;
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
  private Integer testpaperId;
  private Integer delFlag;


}
