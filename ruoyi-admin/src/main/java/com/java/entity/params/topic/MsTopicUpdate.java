package com.java.entity.params.topic;

import lombok.Data;

@Data
public class MsTopicUpdate {

    private Integer topicId;
    private Integer subjectId;

    private String stem;
    private String optionss;
    private String answer;
    private String analysis;
    private Integer score;
    private Integer difficulty;
    private Integer knowledgeId;




}
