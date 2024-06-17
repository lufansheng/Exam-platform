package com.java.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsTask;
import com.java.entity.params.task.MsTaskCreate;
import com.java.entity.params.task.MsTaskUpdate;
import com.java.entity.vo.task.MsTaskDtlVo;
import com.java.entity.vo.task.MsTaskListVo;
import com.java.utils.Pager;

public interface ITaskService extends IService<MsTask> {

    Page<MsTask> getTaskList(Pager pager,Integer grade);

    MsTaskDtlVo getTaskDtlById(Integer taskId);

    int createTask(MsTaskCreate create);

    int deleteById(Integer taskId);

    int updateTask(MsTaskUpdate update);
}
