package com.java.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.MsTitle;
import com.java.entity.vo.testpaper.MsTestpaperDtlVo;
import com.java.mapper.MsTitleMapper;
import com.java.service.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TitleServiceImpl extends ServiceImpl<MsTitleMapper, MsTitle> implements
        ITitleService {

    @Autowired
    private MsTitleMapper msTitleMapper;

    @Transactional
    @Override
    public int deleteTitleTopicsById(Integer titleId) {
        MsTitle msTitle = new MsTitle();
        msTitle.setTitleId(titleId);
        msTitle.setDelFlag("2");
        msTitleMapper.deleteTitleTopics(titleId);
        return msTitleMapper.updateById(msTitle);
    }

    @Override
    public int deleteTitleTopicById(Integer titleId, Integer topiId) {
        return msTitleMapper.deleteTitleTopic(titleId,topiId);
    }

    @Override
    public MsTestpaperDtlVo selectList(Integer testpaperId) {
        return null;
    }


}
