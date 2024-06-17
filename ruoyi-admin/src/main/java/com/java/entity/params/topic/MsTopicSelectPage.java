package com.java.entity.params.topic;

import com.java.utils.Pager;
import lombok.Data;

@Data
public class MsTopicSelectPage {

    private Integer grade;
    private Integer subjectId;
    private Integer types;
    private String stem;
    private Pager pager;




}
