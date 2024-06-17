package com.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.entity.MsTitle;
import org.apache.ibatis.annotations.Param;

public interface MsTitleMapper extends BaseMapper<MsTitle> {

    int deleteTitleTopic(@Param("titleId") Integer titleId,@Param("topicId") Integer topicId);

    int deleteTitleTopics(Integer titleId);

    int deleteTitle(Integer testpaperId);
}
