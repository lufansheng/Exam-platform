package com.java.Mapping;

import com.java.entity.MsClass;
import com.java.entity.params.clazz.MsClassCreate;
import com.java.entity.params.clazz.MsClassUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MsClassMapping {
    MsClassMapping INSTANCE = Mappers.getMapper(MsClassMapping.class);
    MsClass to(MsClassCreate create);
    MsClass to(MsClassUpdate create);
}
