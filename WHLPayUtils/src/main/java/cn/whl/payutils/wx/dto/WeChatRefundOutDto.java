package cn.whl.payutils.wx.dto;

import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.interfaces.pay.PayOut;
import cn.whl.payutils.interfaces.refund.RefundOut;

/**
 * 微信支付退款返回参数封装
 * @author wuhailong
 */
public class WeChatRefundOutDto extends WeChatOutDto implements RefundOut{

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
