package cn.whl.payutils.alipay.dto;

import cn.whl.payutils.PayOutDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;

/**
 * 阿里支付下单传入参数封装
 * @author wuhailong
 */
public class AliPayPayByMchOutDto extends AliPayOutDto implements PayOutDto{
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
