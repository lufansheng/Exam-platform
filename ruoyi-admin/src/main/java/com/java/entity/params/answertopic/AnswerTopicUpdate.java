package com.java.entity.params.answertopic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerTopicUpdate {

    private Integer answerTopicId;

    private Integer isRight;

    private Integer score;

}
