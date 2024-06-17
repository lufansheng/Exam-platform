package com.java.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsVideo;
import com.java.entity.vo.video.MsVideoPageVo;
import com.java.utils.Pager;

public interface IVideoService extends IService<MsVideo> {


    Page<MsVideoPageVo> selectPageByGrade(Pager pager, Integer grade);
}
