package cn.whl.payutils.alipay.dto.close;

import cn.whl.payutils.alipay.dto.AliPayIn;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.interfaces.close.CloseIn;
import cn.whl.payutils.interfaces.pay.PayIn;


/**
 * 阿里支付订单关闭传入参数封装
 * @author wuhailong
 */
public class AliPayCloseInDto extends AliPayIn implements CloseIn{
    //通用部分 
    private String tradeNo;   //与outTradeNo二选一， 支付宝交易流水号
    
    private String outTradeNo;   //与outTradeNo二选一， 商户网站唯一订单号

    private String operatorId;    //可选， 买家自定义操作员Id， <28位

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
}
