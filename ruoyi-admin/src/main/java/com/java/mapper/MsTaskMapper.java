package com.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.entity.MsTask;
import com.java.entity.vo.task.MsTaskDtlVo;
import org.apache.ibatis.annotations.Param;

public interface MsTaskMapper extends BaseMapper<MsTask> {

    MsTaskDtlVo getTaskDtlById(Integer taskId);

    int insertTaskTestpaper(@Param("taskId") Integer taskId,@Param("testpaperIds") Integer[] testpaperIds);

    int deleteRelated(Integer taskId);
}

