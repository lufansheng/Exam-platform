package com.java.entity.vo.video;

import lombok.Data;

@Data
public class MsVideoVo {
    private Integer videoId;
    private Integer subjectId;
    private String videoName;
    private String posterUrl;
    private String videoUrl;
    private Integer testpaperId;
}
