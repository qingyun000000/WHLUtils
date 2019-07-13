package com.whl.whlcommonutils.rest;

/**
 * 封装类：Rest服务结果
 * @author wuhailong
 * @version 0.0.1
 * @param <T> 泛型
 * @createTime 2019-4-12
 * @updateTime 2019-4-12
 */
public class RestResult<T> {

    /**
     * 默认构造方法
     */
    public RestResult() {
    }
    
    /**
     * 构造时初始化success属性
     * @param success 
     */
    public RestResult(boolean success) {
        this.success = success;
    }
    
    //操作是否成功
    private boolean success;
    
    //消息
    private String message;
    
    //返回对象
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setT(T data) {
        this.data = data;
    }
    
    
    
}
