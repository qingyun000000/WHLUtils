package cn.whl.payutils.alipay.vo.refund;

import cn.whl.payutils.alipay.vo.AliPayOut;
import com.alipay.api.domain.PresetPayToolInfo;
import com.alipay.api.domain.TradeFundBill;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import cn.whl.payutils.interfaces.refund.RefundOut;

/**
 * 阿里支付退款返回参数封装
 * @author wuhailong
 */
public class AliPayRefundOut extends AliPayOut implements RefundOut{
    //通用部分 
    private String outTradeNo;   //商户网站唯一订单号                    
     
    private String tradeNo;      //支付宝系统交易流水号
    
    private String buyerLogonId; //买家支付宝账号
    
    private String fundChange;   //本次退款是否发生了资金变化，Y-是
    
    private BigDecimal refundFee;    //退款总金额
    
    private String refundCurrency;    //退款币种
    
    private Date gmtRefundPay;      //退款支付时间
    
    private List<TradeFundBill> refundDetailItemList;      //退款使用的资金渠道
    
    private String storeName;       //支付时的门店名称
    
    private String buyerUserId;     //买家支付宝用户Id
    
    private PresetPayToolInfo refundPresetPayToolList;  //退回的前置资产列表
    
    private String refundSettlementId;   //退款清算编号
    
    private BigDecimal presentRefundBuyerAmount;       //买家收到的退款金额
    
    private BigDecimal presentRefundDiscountAmount;    //平台优惠退款金额
    
    private BigDecimal presentRefundMdiscountAmount;   //商家优惠退款金额

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

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getFundChange() {
        return fundChange;
    }

    public void setFundChange(String fundChange) {
        this.fundChange = fundChange;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }

    public Date getGmtRefundPay() {
        return gmtRefundPay;
    }

    public void setGmtRefundPay(Date gmtRefundPay) {
        this.gmtRefundPay = gmtRefundPay;
    }

    public List<TradeFundBill> getRefundDetailItemList() {
        return refundDetailItemList;
    }

    public void setRefundDetailItemList(List<TradeFundBill> refundDetailItemList) {
        this.refundDetailItemList = refundDetailItemList;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public PresetPayToolInfo getRefundPresetPayToolList() {
        return refundPresetPayToolList;
    }

    public void setRefundPresetPayToolList(PresetPayToolInfo refundPresetPayToolList) {
        this.refundPresetPayToolList = refundPresetPayToolList;
    }

    public String getRefundSettlementId() {
        return refundSettlementId;
    }

    public void setRefundSettlementId(String refundSettlementId) {
        this.refundSettlementId = refundSettlementId;
    }

    public BigDecimal getPresentRefundBuyerAmount() {
        return presentRefundBuyerAmount;
    }

    public void setPresentRefundBuyerAmount(BigDecimal presentRefundBuyerAmount) {
        this.presentRefundBuyerAmount = presentRefundBuyerAmount;
    }

    public BigDecimal getPresentRefundDiscountAmount() {
        return presentRefundDiscountAmount;
    }

    public void setPresentRefundDiscountAmount(BigDecimal presentRefundDiscountAmount) {
        this.presentRefundDiscountAmount = presentRefundDiscountAmount;
    }

    public BigDecimal getPresentRefundMdiscountAmount() {
        return presentRefundMdiscountAmount;
    }

    public void setPresentRefundMdiscountAmount(BigDecimal presentRefundMdiscountAmount) {
        this.presentRefundMdiscountAmount = presentRefundMdiscountAmount;
    }
   
    
}
