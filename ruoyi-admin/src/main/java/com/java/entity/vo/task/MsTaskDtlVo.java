package com.java.entity.vo.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java.entity.vo.testpaper.MsTestpaperTaskVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MsTaskDtlVo {
    private Integer grade;
    private String taskName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private List<MsTestpaperTaskVo> testpaperVoList;
}
