package com.java.service;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsTopic;
import com.java.entity.vo.topic.MsTopicSelectPageVo;
import com.java.utils.Pager;

public interface ITopicService extends IService<MsTopic> {

    Page<MsTopicSelectPageVo> queryList(Pager pager,String stem, Integer grade, Integer subjectId, Integer type);


}
