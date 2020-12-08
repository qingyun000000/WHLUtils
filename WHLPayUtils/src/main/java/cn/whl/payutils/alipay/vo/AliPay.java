package cn.whl.payutils.alipay.vo;

import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.interfaces.CommonParams;

/**
 * 阿里支付
 * @author wuhailong
 */
public class AliPay implements CommonParams{
    //接口部分
    private PayType payType;

    @Override
    public Platform getPlatform() {
        return Platform.ALIPAY;
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
