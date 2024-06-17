package com.java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MsTitle {

  @TableId(type = IdType.AUTO)
  private Integer titleId;
  private Integer testpaperId;
  private String titleName;
  private String delFlag;

  public MsTitle(Integer titleId, Integer testpaperId, String titleName) {
    this.titleId = titleId;
    this.testpaperId = testpaperId;
    this.titleName = titleName;
  }

  public MsTitle() {
  }
}
