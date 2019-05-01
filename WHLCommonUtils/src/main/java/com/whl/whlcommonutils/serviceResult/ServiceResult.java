package com.whl.whlcommonutils.serviceResult;

/**
 * 服务端结果返回，用于替代非对象、数组、集合框架等数据（比如返回成功信息、错误信息）
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-5-1
 * @updateTime 2019-5-1
 */
public class ServiceResult {
    
    //操作是否成功
    private boolean success;
    
    //消息
    private String message;
    
    //Long类型参数, 用于返回id等信息
    private Long resultId;
    
    //String类型参数, 用于返回url
    private String url;
    
    //String类型参数，用于返回各种名称、title、stem等
    private String name;
    
    //int类型参数，用于返回int型数据
    private int intValue;

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

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
    
}
