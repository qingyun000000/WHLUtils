package cn.whl.payutils.alipay.vo.create;

import cn.whl.payutils.alipay.vo.AliPayOut;
import java.math.BigDecimal;
import cn.whl.payutils.common.create.CreateOut;

/**
 * 阿里支付下单返回参数封装
 * @author wuhailong
 */
public class AliPayCreateOut extends AliPayOut implements CreateOut{
    //通用部分 
    
    //precreate/create部分 
    private String outTradeNo;   //商户网站唯一订单号
    
    private String resultJson;         //response.body的Json串
    
    //create部分
    private String tradeNo;      //支付宝系统交易流水号
    
    private BigDecimal totalAmount;     //订单总金额，0.01-100000000
    
    private String sellerId;        //收款方支付宝用户ID
    
    private String merchantOrderNo;          //商户原始订单号， <32位
    
    //wap + page
    private String form;                      //form创建字符串   
    
    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getResultJson() {
        return resultJson;
    }

    public void setResultJson(String resultJson) {
        this.resultJson = resultJson;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
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
