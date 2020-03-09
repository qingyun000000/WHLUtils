package cn.whl.commonutils.service.result;

import cn.whl.commonutils.Result;

/**
 * 服务端结果返回
 * @author wuhailong
 */
public class ServiceResult extends Result{
    
    //Boolean类型参数, 用于返回Boolean值
    private Boolean beTrue;
    
    //Long类型参数, 用于返回id等信息
    private Long resultId;
    
    //String类型参数, 用于返回url
    private String url;
    
    //String类型参数，用于返回各种名称、title、stem等
    private String name;
    
    //int类型参数，用于返回int型数据
    private int intValue;
    
    private String exceptionCode;

    public ServiceResult() {
        super.setSuccess(false);
        super.setMessage("输入参数错了吧，服务器啥也没干，给你返回了一个真空！");
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

    public Boolean getBeTrue() {
        return beTrue;
    }

    public void setBeTrue(Boolean beTrue) {
        this.beTrue = beTrue;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
    
}
