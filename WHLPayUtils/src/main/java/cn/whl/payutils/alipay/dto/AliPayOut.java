package cn.whl.payutils.alipay.dto;

/**
 * 阿里支付返回结果封装
 * @author wuhailong
 */
public class AliPayOut{
    
    private String code;         //必填， 网关返回码
    
    private String msg;          //必填， 网关返回码描述
    
    private String subCode;      //选填， 业务返回码
    
    private String subMsg;       //选填， 业务返回码描述

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }
    
    
    
}
