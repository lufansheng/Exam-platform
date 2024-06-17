package com.java.entity.params.testpaper;

import lombok.Data;

@Data
public class MsCreateTestpaper {
    private Integer testpaperId;
    private Integer subjectId;
    private Integer duration;
    private Integer types;
    private String testpaperName;
}
