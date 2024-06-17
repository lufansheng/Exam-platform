package com.java.entity.vo.title;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MsTitleVo {
  @TableId(type = IdType.AUTO)
  private Integer titleId;
  private Integer testpaperId;




}
