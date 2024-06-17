package com.java.Mapping;

import com.java.entity.MsTask;
import com.java.entity.MsTestpaper;
import com.java.entity.params.task.MsTaskCreate;
import com.java.entity.params.task.MsTaskUpdate;
import com.java.entity.params.testpaper.MsCreateTestpaper;
import com.java.entity.vo.task.MsTaskListVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MsTaskMapping {
    MsTaskMapping INSTANCE = Mappers.getMapper(MsTaskMapping.class);
    List<MsTaskListVo> to(List<MsTask> msTask);
    MsTask to(MsTaskCreate create);
    MsTask to(MsTaskUpdate update);
}
