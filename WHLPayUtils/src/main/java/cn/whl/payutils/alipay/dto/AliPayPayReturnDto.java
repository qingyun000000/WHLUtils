package cn.whl.payutils.alipay.dto;

/**
 * alipay支付完前台回跳参数（支付完成后，返回商家页面带的参数，页面地址为pay的returnUrl)业务参数部分
 * @author wuhailong
 */
public class AliPayPayReturnDto extends AliPayReturnDto{
    
    private String outTradeNo;   //商户网站唯一订单号                    
     
    private String tradeNo;      //支付宝系统交易流水号
    
    private double totalAmount;     //订单总金额，0.01-100000000
    
    private String sellerId;        //收款方支付宝用户ID

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
    
    
}
