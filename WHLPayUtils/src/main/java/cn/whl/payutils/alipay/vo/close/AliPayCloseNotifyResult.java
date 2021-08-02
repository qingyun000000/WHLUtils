package cn.whl.payutils.alipay.vo.close;

import cn.whl.payutils.alipay.vo.AliPayNotifyResult;
import cn.whl.payutils.common.close.CloseNotifyResult;

/**
 * 阿里支付订单关闭回调结果参数封装
 * @author wuhailong
 */
public class AliPayCloseNotifyResult extends AliPayNotifyResult implements CloseNotifyResult{
    
    //通用部分 
    private String outTradeNo;   //商户网站唯一订单号                    
     
    private String tradeNo;      //支付宝系统交易流水号
    
    private double totalAmount;     //订单总金额，0.01-100000000
    
    private String sellerId;        //收款方支付宝用户ID
    
    private String merchantOrderNo;          //商户原始订单号， <32位
    
    //wap+app
    
    
    
    
    //page+app
    
    
    
    
    //wap
    private String form;                      //form创建字符串   
    
    //page

    
    
    
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
   
    
}
