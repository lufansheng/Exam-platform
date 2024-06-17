package com.java.entity.vo.title;

import com.java.entity.vo.topic.MsTopicDtl;
import lombok.Data;

import java.util.List;

@Data
public class MsTitleDtlVo {
    private Integer titleId;
    private String titleName;
    private List<MsTopicDtl> msTopicDtl;
}
