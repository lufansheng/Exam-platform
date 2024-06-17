package com.java.entity.vo.answertopic;

import lombok.Data;

@Data
public class MsAnswertopicVo {
    private Integer score;

    private Integer isRight;

    private Integer scoreTotal;

    private Integer types;

    private Integer answerTopicId;

    private String answer;

    private String standarAnswer;
}
