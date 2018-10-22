package com.hu.common;

import java.io.Serializable;
import java.util.List;

public class RestResult<T> implements Serializable{

    private Integer code; //状态码
    private String msg; //状态信息
    private List<T> data; //返回的数据
    private Integer count; //返回数据的记录数

    private RestResult(){}

    public RestResult(Integer code,Integer count,String msg,List<T> data){
        this.code = code;
        this.count = count;
        this.msg = msg;
        this.data = data;
    }

    public static <T> RestResult<T> SUCCESS(List<T> data){
        return new RestResult<>(0,data.size(),"success",data);
    }

    public static <T> RestResult<T> SUCCESS(List<T> data,String msg){
        return new RestResult<>(0, data != null ? data.size() : 0,msg ,data);
    }

    public static <T> RestResult<T> ERROR(String msg){
        return new RestResult<>(700,null, msg ,null);
    }

    public static <T> RestResult<T> ERROR(){
        return new RestResult<>(700,null,"error",null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
