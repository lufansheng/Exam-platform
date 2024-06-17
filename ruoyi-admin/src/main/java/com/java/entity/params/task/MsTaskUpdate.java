package com.java.entity.params.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MsTaskUpdate {
    private Integer taskId;
    private Integer grade;
    private String taskName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private Integer[] testpaperIds;
}
