package com.java.entity.params.answertopic;

import lombok.Data;

@Data
public class AnswerTopicCreate {

    private Integer topicId;

    private String[] answer;
}
