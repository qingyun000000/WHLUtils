package cn.whl.payutils.alipay.vo.close;

import cn.whl.payutils.alipay.vo.AliPayOut;
import cn.whl.payutils.common.CloseOut;

/**
 * 阿里支付订单关闭返回参数封装
 * @author wuhailong
 */
public class AliPayCloseOut extends AliPayOut implements CloseOut{
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
