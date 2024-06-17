package com.java.Mapping;
import com.java.entity.MsTopic;
import com.java.entity.params.topic.MsTopicCreate;

import com.java.entity.params.topic.MsTopicUpdate;
import com.java.entity.vo.topic.MsTopicDtlVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MsTopicMapping {
    MsTopicMapping INSTANCE = Mappers.getMapper(MsTopicMapping.class);
    MsTopic to(MsTopicCreate create);
    MsTopic to(MsTopicUpdate update);
    MsTopicDtlVo to(MsTopic msTopic);
}
