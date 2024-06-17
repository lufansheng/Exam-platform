package com.java.Mapping;
import com.java.entity.MsSubject;
import com.java.entity.MsVideo;
import com.java.entity.params.subject.MsSubjectCreate;
import com.java.entity.params.subject.MsSubjectUpdate;
import com.java.entity.params.subject.MsSubjectVo;
import com.java.entity.params.video.MsVideoCreate;
import com.java.entity.params.video.MsVideoUpdate;
import com.java.entity.vo.video.MsVideoVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MsVideoMapping {
    MsVideoMapping INSTANCE = Mappers.getMapper(MsVideoMapping.class);
    MsVideo to(MsVideoCreate create);
    MsVideo toUpdate(MsVideoUpdate update);
    MsVideoVo dtl(MsVideo msVideo);
}
