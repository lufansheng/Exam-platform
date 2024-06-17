package com.java.utils;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("操作响应对象")
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(Object data){
        return new Result(200,"操作成功",data);
    }

    public static Result success(){
        return new Result(200,"操作成功",null);
    }

    public static Result error(){
        return new Result(500,"操作失败",null);
    }

    public static Result error(String msg){
        return new Result(500,msg,null);
    }

    public static Result to(boolean rs){
        return rs ? success() : error();
    }
    public static Result to(int rs){
        return rs > 0? success() : error();
    }
}
