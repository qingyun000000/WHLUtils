package cn.whl.payutils.alipay.vo.refundQuery;

import cn.whl.payutils.alipay.vo.AliPayIn;
import cn.whl.payutils.interfaces.refundQuery.RefundQueryIn;


/**
 * 阿里支付下单传入参数封装
 * @author wuhailong
 */
public class AliPayRefundQueryIn extends AliPayIn implements RefundQueryIn{
    //通用部分
    private String tradeNo;   //与outTradeNo二选一， 支付宝交易流水号
    
    private String outTradeNo;   //与outTradeNo二选一， 商户网站唯一订单号
    
    private String outRequestNo;   //退款请求试传入的退款请求号，如果未填则为创建交易时的外部交易号outTradeNo
    
    private String orgPid;       //仅银行间联模式，收单机构pid\

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

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid;
    }
}
