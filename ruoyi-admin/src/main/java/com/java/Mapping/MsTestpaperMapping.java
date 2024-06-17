package com.java.Mapping;
import com.java.entity.MsTestpaper;

import com.java.entity.params.testpaper.MsCreateTestpaper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MsTestpaperMapping {
    MsTestpaperMapping INSTANCE = Mappers.getMapper(MsTestpaperMapping.class);
    MsTestpaper to(MsCreateTestpaper createTestpaper);
}
