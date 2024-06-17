package com.java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MsAnswerTopic {

  @TableId(type = IdType.AUTO)
  private Integer answerTopicId;
  private Integer answerTestpaperId;
  private Integer topicId;
  private Integer score;
  private Integer isRight;
  private String answer;




}
