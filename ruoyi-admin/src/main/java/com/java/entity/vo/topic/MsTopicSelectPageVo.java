package com.java.entity.vo.topic;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.util.Date;

@Data
public class MsTopicSelectPageVo {
    private Long topicId;
    private Long subjectId;
    private String subjectName;
    private Long types;
    private String stem;
    private String optionss;
    private Integer score;
    private Integer difficulty;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;





}
