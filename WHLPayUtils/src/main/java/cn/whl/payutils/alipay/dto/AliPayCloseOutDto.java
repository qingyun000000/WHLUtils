package cn.whl.payutils.alipay.dto;

import cn.whl.payutils.PayOutDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;

/**
 * 阿里支付订单关闭返回参数封装
 * @author wuhailong
 */
public class AliPayCloseOutDto extends AliPayOutDto implements PayOutDto{
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
    
    //通用部分 
    private String outTradeNo;   //商户网站唯一订单号                    
     
    private String tradeNo;      //支付宝系统交易流水号
    
    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

}
