package com.java.entity.vo.testpaper;

import com.java.entity.vo.title.MsTitleDtlVo;
import lombok.Data;

import java.util.List;

@Data
public class MsTestpaperDtlVo {
    private Integer testpaperId;
    private Integer grade;
    private String subjectName;
    private Integer types;
    private String testpaperName;
    private List<MsTitleDtlVo> msTitleDtlVos;
    private Integer duration;
}
