package com.java.entity.vo.testpaper;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsTestpaperListVo {
    private Integer testpaperId;
    private String subjectName;
    private String testpaperName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
