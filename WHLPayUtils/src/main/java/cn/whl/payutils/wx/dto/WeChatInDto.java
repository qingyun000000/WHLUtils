package cn.whl.payutils.wx.dto;

import cn.whl.payutils.PayInDto;

/**
 * 微信支付传入参数封装
 * @author wuhailong
 */
public class WeChatInDto {
    
    private String appId;
    
    private String mchId;
    
    private String key;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
