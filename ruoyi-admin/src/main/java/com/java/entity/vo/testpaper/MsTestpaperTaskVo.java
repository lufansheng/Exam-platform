package com.java.entity.vo.testpaper;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsTestpaperTaskVo {
    private Integer testpaperId;

    private String testpaperName;

    private String subjectName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
