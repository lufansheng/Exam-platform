package com.java.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.entity.MsAnswerTopic;
import com.java.entity.params.answertopic.AnswerTopicCreate;

import com.java.entity.vo.answertopic.MsAnswertopicVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsAnswerTopicMapper extends BaseMapper<MsAnswerTopic> {
    int insertTopic(@Param("answerTestpaperId") Integer testpaperId,@Param("answerTopicCreates") List<AnswerTopicCreate> answerTopicCreates);

    List<MsAnswertopicVo> selectTopicList(Integer answerTestpaperId);

    int getIsEqual(Integer answerTopicId);
}
