package com.java.entity.params.answertestpaper;

import com.java.entity.params.answertopic.AnswerTopicCreate;
import lombok.Data;

import java.util.List;

@Data
public class AnswerTestpaperUpdate {

   private Integer answerTestpaperId;
   private Integer scoreTotal; //所有答卷满分
   private Integer score;  //该同学拿的分
   private Integer topicRight; //该同学答对几题
   private Integer topicTotal;   //题目数量
   private Integer state;  //是否已经批改

   public AnswerTestpaperUpdate(Integer answerTestpaperId, Integer scoreTotal, Integer score, Integer topicRight, Integer topicTotal, Integer state) {
      this.answerTestpaperId = answerTestpaperId;
      this.scoreTotal = scoreTotal;
      this.score = score;
      this.topicRight = topicRight;
      this.topicTotal = topicTotal;
      this.state = state;
   }
}
