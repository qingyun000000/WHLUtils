package cn.whl.payutils.wx.dto;

import cn.whl.payutils.PayOutDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;

/**
 * 微信支付商户支付返回参数封装
 * @author wuhailong
 */
public class WeChatPayByMchOutDto extends WeChatOutDto implements PayOutDto{

    //接口部分
    private Platform platform;
    
    private PayType payType;

    @Override
    public Platform getPlatform() {
        return platform;
    }

    @Override
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public PayType getPayType() {
        return payType;
    }

    @Override
    public void setPayType(PayType payType) {
        this.payType = payType;
    }
    
    
}
