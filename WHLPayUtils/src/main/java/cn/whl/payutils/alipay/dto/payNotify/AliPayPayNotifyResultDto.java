package cn.whl.payutils.alipay.dto.payNotify;

import cn.whl.payutils.alipay.dto.AliPayNotifyResultDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import java.math.BigDecimal;
import java.util.Date;
import cn.whl.payutils.interfaces.payNotify.PayNotifyResult;

/**
 * 阿里支付下单回调结果参数封装
 * @author wuhailong
 */
public class AliPayPayNotifyResultDto extends AliPayNotifyResultDto implements PayNotifyResult{
    
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
