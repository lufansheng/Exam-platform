package com.java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.MsVideo;
import com.java.entity.vo.video.MsVideoPageVo;
import com.java.mapper.MsVideoMapper;
import com.java.service.IVideoService;
import com.java.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl extends ServiceImpl<MsVideoMapper, MsVideo> implements
        IVideoService {

    @Autowired
    MsVideoMapper msVideoMapper;


    @Override
    public Page<MsVideoPageVo> selectPageByGrade(Pager pager, Integer grade) {
        Page<MsVideoPageVo> pageVoPage = new Page<>(pager.getPageNum(),pager.getPageSize());
        QueryWrapper<MsVideoPageVo> qw = new QueryWrapper<>();
        qw.ne("t1.del_flag",2);
        qw.eq(grade != null,"t2.grade",grade);
        return msVideoMapper.selectPageByGrade(pageVoPage,qw);
    }
}
