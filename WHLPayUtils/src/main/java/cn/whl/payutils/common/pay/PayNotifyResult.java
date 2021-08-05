package cn.whl.payutils.common.pay;

import cn.whl.payutils.common.CommonParams;
import java.math.BigDecimal;

/**
 * 支付回调返回结果
 * @author wuhailong
 */
public interface PayNotifyResult extends CommonParams{
    
    public String getTradeNo();
    
    public void setTradeNo(String tradeNo);
    
    public String getOutTradeNo();
    
    public void setOutTradeNo(String outTradeNo);
    
    public BigDecimal getPayAmt();
    
    public void setPayAmt(BigDecimal payAmt);
    
    public String getPayer();

    public void setPayer(String payer);
    
}
