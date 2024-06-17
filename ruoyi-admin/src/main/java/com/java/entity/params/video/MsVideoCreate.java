package com.java.entity.params.video;

import lombok.Data;

@Data
public class MsVideoCreate {
    private Integer subjectId;
    private String videoName;
    private String posterUrl;
    private String videoUrl;
    private Integer testpaperId;
}
