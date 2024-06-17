package com.java.entity.params.answertestpaper;

import com.java.entity.params.answertopic.AnswerTopicCreate;
import lombok.Data;

import java.util.List;

@Data
public class AnswerTestpaperCreate {
    private Integer userId;

    private Integer time;

    private Integer testpaperId;

    private List<AnswerTopicCreate> answerTopicCreates;
}
