package com.java.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsTitle;
import com.java.entity.vo.testpaper.MsTestpaperDtlVo;

public interface ITitleService extends IService<MsTitle> {

    int deleteTitleTopicsById(Integer titleId);

    int deleteTitleTopicById(Integer titleId,Integer topicId);

    MsTestpaperDtlVo selectList(Integer testpaperId);
}
