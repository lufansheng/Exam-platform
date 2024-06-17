package com.java.Mapping;

import com.java.entity.MsAnswerTopic;
import com.java.entity.params.answertopic.AnswerTopicCreate;

import com.java.entity.params.answertopic.AnswerTopicUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MsAnswerTopicMapping {
    MsAnswerTopicMapping INSTANCE = Mappers.getMapper(MsAnswerTopicMapping.class);
    MsAnswerTopic to(AnswerTopicUpdate update);
}
