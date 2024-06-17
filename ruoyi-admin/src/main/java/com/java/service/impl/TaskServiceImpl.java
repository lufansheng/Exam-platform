package com.java.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.Mapping.MsTaskMapping;
import com.java.entity.MsTask;
import com.java.entity.params.task.MsTaskCreate;
import com.java.entity.params.task.MsTaskUpdate;
import com.java.entity.vo.task.MsTaskDtlVo;
import com.java.entity.vo.task.MsTaskListVo;
import com.java.mapper.MsTaskMapper;
import com.java.service.ITaskService;
import com.java.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl extends ServiceImpl<MsTaskMapper, MsTask> implements
        ITaskService {

    @Autowired
    MsTaskMapper msTaskMapper;


    @Override
    public Page<MsTask> getTaskList(Pager pager,Integer grade) {
        Page<MsTask> p = new Page<>(pager.getPageNum(),pager.getPageSize());
        LambdaUpdateWrapper<MsTask> qw = new LambdaUpdateWrapper<>();
        qw.eq(grade != null, MsTask::getGrade,grade);
        qw.ne(MsTask::getDelFlag,"2");

        return msTaskMapper.selectPage(p,qw);
    }

    @Override
    public MsTaskDtlVo getTaskDtlById(Integer taskId) {
        return msTaskMapper.getTaskDtlById(taskId);
    }

    @Transactional
    @Override
    public int createTask(MsTaskCreate create) {
        MsTask msTask = MsTaskMapping.INSTANCE.to(create);
        msTaskMapper.insert(msTask);
        Integer taskId = msTask.getTaskId();
        Integer[] testpaperIds = create.getTestpaperIds();
        return msTaskMapper.insertTaskTestpaper(taskId,testpaperIds);
    }

    @Transactional
    @Override
    public int deleteById(Integer taskId) {
        MsTask msTask = new MsTask();
        msTask.setTaskId(taskId);
        msTask.setDelFlag("2");

        //删除主表
        msTaskMapper.updateById(msTask);

        //删除关联表
        return msTaskMapper.deleteRelated(taskId);
    }

    @Transactional
    @Override
    public int updateTask(MsTaskUpdate update) {
        Integer taskId = update.getTaskId();

        //修改主表信息
        MsTask msTask = MsTaskMapping.INSTANCE.to(update);
        msTaskMapper.updateById(msTask);

        //删除从表信息
        msTaskMapper.deleteRelated(taskId);

        //更新从表信息
        return msTaskMapper.insertTaskTestpaper(taskId,update.getTestpaperIds());
    }
}
