package com.java.entity.vo.answerTestPaperCorret;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsAnswerTestpaperVo {

    private Integer answerTestpaperId;

    private String testpaperName;

    private String nickName;

    private Integer scoreTotal;

    private Integer score;

    private Integer userId;

    private Integer topicToal;

    private Integer topicRight;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
