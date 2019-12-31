package cn.whl.payutils.alipay.dto;

import cn.whl.payutils.NotifyDto;


/**
 * 阿里支付下单传入参数封装
 * @author wuhailong
 */
public class AliPayPayNotifyInDto extends AliPayNotifyDto implements NotifyDto{
    
    private String tradeNo;
    
    private String appId;
    
    private String outTradeNo;
    
    private String outBizNO;
    
    private String buyerId;
    
    private String sellerId;
    
    private String tradeStatus;
    
    private String totalAmount;

    private String receiptAmount;
    
    private String invoiceAmount;
    
    private String buyerPayAmount;
    
}
