package com.java.entity.vo.video;

import lombok.Data;

import java.util.Date;

@Data
public class MsVideoPageVo {
    private Integer videoId;
    private Integer grade;
    private String subjectName;
    private String videoName;
    private String testpaperName;
    private Date createTime;
}
