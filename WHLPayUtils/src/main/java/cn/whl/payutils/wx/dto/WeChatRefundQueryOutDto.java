package cn.whl.payutils.wx.dto;

import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.interfaces.pay.PayOut;
import cn.whl.payutils.interfaces.refundQuery.RefundQueryOut;

/**
 * 微信支付退款查询返回参数封装
 * @author wuhailong
 */
public class WeChatRefundQueryOutDto extends WeChatOutDto implements RefundQueryOut{

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
