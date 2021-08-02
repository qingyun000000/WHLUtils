package cn.whl.payutils.wx.vo.agreement;

import cn.whl.payutils.common.CloseIn;
import cn.whl.payutils.common.agreement.SignIn;
import cn.whl.payutils.wx.vo.WeChatIn;

/**
 * 微信支付订单关闭传入参数封装
 * @author wuhailong
 */
public class WeChatSignIn extends WeChatIn implements SignIn{
    
    private String unifiedOrderUrl;
    
    private String deviceInfo;
    
    private String totalFee;
    
    private String body;
    
    private String openId;
    
    private String outTradeNo;
    
    private String spbillCreateIp;
    
    private String notifyUrl;
    
    private String tradeType;

    public String getUnifiedOrderUrl() {
        return unifiedOrderUrl;
    }

    public void setUnifiedOrderUrl(String unifiedOrderUrl) {
        this.unifiedOrderUrl = unifiedOrderUrl;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    
    
    
    
}
