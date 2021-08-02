package cn.whl.payutils.alipay.vo.refund;

import cn.whl.payutils.alipay.vo.AliPayOut;
import cn.whl.payutils.alipay.vo.AliPayOut;
import com.alipay.api.domain.RefundRoyaltyResult;
import com.alipay.api.domain.TradeFundBill;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import cn.whl.payutils.common.refund.RefundQueryOut;

/**
 * 阿里支付下单传入参数封装
 * @author wuhailong
 */
public class AliPayRefundQueryOut extends AliPayOut implements RefundQueryOut{
    //通用部分 
    private String outTradeNo;                 //商户网站唯一订单号                    
     
    private String tradeNo;                    //支付宝系统交易流水号
    
    private String outRequestNo;               //退款请求号
    
    private String refundReason;               //退款原因
    
    private BigDecimal totalAmount;            //订单金额
    
    private BigDecimal refundAmount;           //退款金额
    
    private List<RefundRoyaltyResult> refundRoyaltys;    //退分帐明细
    
    private Date gmtRefundPay;      //退款支付时间
    
    private List<TradeFundBill> refundDetailItemList;      //退款使用的资金渠道
    
    private BigDecimal sendBackFee;                //本次商户实际退回金额
    
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

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public List<RefundRoyaltyResult> getRefundRoyaltys() {
        return refundRoyaltys;
    }

    public void setRefundRoyaltys(List<RefundRoyaltyResult> refundRoyaltys) {
        this.refundRoyaltys = refundRoyaltys;
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

    public BigDecimal getSendBackFee() {
        return sendBackFee;
    }

    public void setSendBackFee(BigDecimal sendBackFee) {
        this.sendBackFee = sendBackFee;
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
