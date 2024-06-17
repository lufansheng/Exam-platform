package com.java.entity.params.topic;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsTopicCreate {

    private Long subjectId;
    private String stem;
    private Integer types;
    private String optionss;
    private String answer;
    private String analysis;
    private Integer score;
    private Integer difficulty;
    private Long knowledgeId;




}
