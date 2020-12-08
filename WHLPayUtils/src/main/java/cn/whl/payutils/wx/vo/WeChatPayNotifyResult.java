package cn.whl.payutils.wx.vo;

import cn.whl.payutils.interfaces.payNotify.PayNotifyResult;
import java.math.BigDecimal;

/**
 * 微信支付支付回调结果参数封装
 * @author wuhailong
 */
public class WeChatPayNotifyResult extends WeChatNotifyResult implements PayNotifyResult{
    
    private String tradeNo;
    
    private String outTradeNo;
    
    private BigDecimal payAmt;

    @Override
    public String getTradeNo() {
        return tradeNo;
    }

    @Override
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String getOutTradeNo() {
        return outTradeNo;
    }

    @Override
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    public BigDecimal getPayAmt() {
        return payAmt;
    }

    @Override
    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }
    
}
