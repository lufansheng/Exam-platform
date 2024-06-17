package com.java.utils;

/*
统一返回实体类
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("分页数据")
@Data
public class TableData<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("提示消息")
    private String msg;

    @ApiModelProperty("数据")
    private List<T> rows;

    @ApiModelProperty("总数量")
    private Long total;

    public TableData(Integer code, String msg, List<T> rows, Long total) {
        this.code = code;
        this.msg = msg;
        this.rows = rows;
        this.total = total;
    }

    //返回分页数据
    public static TableData success(List list, Long total){
        return new TableData(200,"操作成功",list,total);
    }


}
