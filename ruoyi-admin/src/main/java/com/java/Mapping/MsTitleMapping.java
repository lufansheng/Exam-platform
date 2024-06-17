package com.java.Mapping;

import com.java.entity.MsTitle;
import com.java.entity.params.title.MsTitleUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MsTitleMapping {
    MsTitleMapping INSTANCE = Mappers.getMapper(MsTitleMapping.class);

    MsTitle to(MsTitleUpdate msTitleUpdate);
}
