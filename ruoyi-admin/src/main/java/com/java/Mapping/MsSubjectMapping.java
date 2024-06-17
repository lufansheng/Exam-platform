package com.java.Mapping;
import com.java.entity.MsSubject;
import com.java.entity.params.subject.MsSubjectCreate;
import com.java.entity.params.subject.MsSubjectUpdate;
import com.java.entity.params.subject.MsSubjectVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MsSubjectMapping {
    MsSubjectMapping INSTANCE = Mappers.getMapper(MsSubjectMapping.class);
    MsSubject to(MsSubjectCreate create);
    MsSubject to(MsSubjectUpdate update);
    List<MsSubjectVo> toList(List<MsSubject> list);
}
