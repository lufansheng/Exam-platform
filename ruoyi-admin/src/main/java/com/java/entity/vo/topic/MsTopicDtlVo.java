package com.java.entity.vo.topic;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsTopicDtlVo {
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
