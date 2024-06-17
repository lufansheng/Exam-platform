package com.java.service;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.java.entity.MsTestpaper;
import com.java.entity.vo.testpaper.MsTestpaperDtlVo;
import com.java.entity.vo.testpaper.MsTestpaperListVo;
import com.java.entity.vo.title.MsTitleVo;
import com.java.utils.Pager;

import java.util.List;

public interface ITestpaperService extends IService<MsTestpaper> {


   MsTitleVo createTitle(Integer testPaperId, String titleName);

   int createTitleTopic(Integer titleId, Integer topicId);

   List<MsTestpaperDtlVo> selectList(Integer testpaperId);

   Page<MsTestpaperListVo> selectTestpaperVo(Pager pager,String testpaperName,Integer grade,Integer subjectId);

   int deleteTestpaperById(Integer testpaperId);
}
