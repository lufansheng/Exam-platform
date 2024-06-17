package com.java.Mapping;

import com.java.entity.MsAnswerTestpaper;
import com.java.entity.MsClass;
import com.java.entity.params.answertestpaper.AnswerTestpaperCreate;
import com.java.entity.params.answertestpaper.AnswerTestpaperUpdate;
import com.java.entity.params.clazz.MsClassCreate;
import com.java.entity.params.clazz.MsClassUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MsAnswerTestpaperMapping {
    MsAnswerTestpaperMapping INSTANCE = Mappers.getMapper(MsAnswerTestpaperMapping.class);
    MsAnswerTestpaper to(AnswerTestpaperCreate create);
    MsAnswerTestpaper toUpdate(AnswerTestpaperUpdate update);
}
