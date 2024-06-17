package com.java.entity.params.answertestpaper;

import com.java.entity.params.answertopic.MsAnswerTopicUpdate;
import lombok.Data;

import java.util.List;

@Data
public class MsAnswerTestpaperCorretUpdate {
    Integer answerTestpaperId;
    List<MsAnswerTopicUpdate> updates;
}
