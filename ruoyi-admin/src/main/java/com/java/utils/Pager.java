package com.java.utils;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Pager {

    @NotNull(message = "页码不能为空")
    private Integer pageNum;

    @NotNull(message = "分页条数不能为空")
    private Integer pageSize;
}
