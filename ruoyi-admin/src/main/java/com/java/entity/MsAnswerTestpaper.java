package com.java.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsAnswerTestpaper {

  @TableId(type = IdType.AUTO)
  private Integer answerTestpaperId;
  private Integer testpaperId;
  private Integer userId;
  private Integer time;
  private Integer score;
  private Integer topicRight;
  private Integer topicTotal;
  @TableField(fill = FieldFill.INSERT)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;
  private Integer scoreTotal;
  private Integer state;

}
