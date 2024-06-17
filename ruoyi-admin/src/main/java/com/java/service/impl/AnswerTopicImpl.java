package com.java.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.entity.MsAnswerTopic;
import com.java.mapper.MsAnswerTopicMapper;
import com.java.service.IAnswerTestpaperTopicService;
import org.springframework.stereotype.Service;

@Service
public class AnswerTopicImpl extends ServiceImpl<MsAnswerTopicMapper, MsAnswerTopic> implements
        IAnswerTestpaperTopicService {
}
