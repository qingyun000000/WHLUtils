package cn.whl.payutils.alipay.dto;

import cn.whl.payutils.PayOutDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import java.math.BigDecimal;

/**
 * 阿里支付退款返回参数封装
 * @author wuhailong
 */
public class AliPayRefundOutDto extends AliPayOutDto implements PayOutDto{
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
    
    private String buyerLogonId; //买家支付宝账号
    
    private String fundChange;   //本次退款是否发生了资金变化，Y-是
    
    private BigDecimal refundFee;    //退款总金额
   
    
}
