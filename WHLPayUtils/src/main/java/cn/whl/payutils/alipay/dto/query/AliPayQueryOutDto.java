package cn.whl.payutils.alipay.dto.query;

import cn.whl.payutils.alipay.dto.AliPayOut;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import com.alipay.api.domain.TradeFundBill;
import com.alipay.api.domain.TradeSettleInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import cn.whl.payutils.interfaces.query.QueryOut;

/**
 * 阿里支付订单查询返回参数封装
 * @author wuhailong
 */
public class AliPayQueryOutDto extends AliPayOut implements QueryOut{
    //通用部分 
    private String outTradeNo;                 //商户网站唯一订单号                    
     
    private String tradeNo;                    //支付宝系统交易流水号
    
    private String subject;                    //订单标题
    
    private String body;                       //订单描述
    
    private String buyerLogonId;               //买家支付宝账号
    
    private String buyerUserType;              //买家用户类型
    
    private String buyerUserId;                //买家支付宝用户Id
    
    private String buyerUserName;              //买家名称
    
    private String tradeStatus;    //交易状态
    
    private BigDecimal totalAmount;    //订单金额
    
    private String transCurrency;      //标价币种
    
    private String settleCurrency;     //结算币种
    
    private BigDecimal settleAmount;       //结算币种订单金额
    
    private String payCurrency;        //订单支付币种
    
    private BigDecimal payAmount;          //订单支付币种金额
    
    private double settleTransRate;        //结算币种兑换标价币种汇率
    
    private double transPayRate;          //标价币种兑换支付币种汇率
    
    private BigDecimal buyerPayAmount;      //买家实际支付金额
    
    private BigDecimal receiptAmount;       //卖家实收金额
    
    private BigDecimal mdiscountAmount;       //商家优惠金额
    
    private BigDecimal discountAmount;         //平台优惠金额
    
    private BigDecimal pointAmount;         //积分支付的金额
    
    private BigDecimal invoiceAmount;        //可开票金额
    
    private Date sendPayDate;              //交易贷款给卖家时间
    
    private String storeId;               //卖家门店编号
    
    private String storeName;             //商户店铺名
    
    private String terminalId;            //终端编号
    
    private List<TradeFundBill> fundBillList;     //支付使用的资金渠道
    
    private String chargeFlags;           //费率活动标识
    
    private String settlementId;          //支付清算编号，仅银行间联交易返回
    
    private TradeSettleInfo tradeSettleInfo;      //交易结算信息
    
    private String authTradePayMode;           //预授权支付模式
    
    private String alipaySubMerchantId;         //间连商户编号
    
    private String extInfos;                   //额外信息

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getBuyerUserType() {
        return buyerUserType;
    }

    public void setBuyerUserType(String buyerUserType) {
        this.buyerUserType = buyerUserType;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getBuyerUserName() {
        return buyerUserName;
    }

    public void setBuyerUserName(String buyerUserName) {
        this.buyerUserName = buyerUserName;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTransCurrency() {
        return transCurrency;
    }

    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    public String getSettleCurrency() {
        return settleCurrency;
    }

    public void setSettleCurrency(String settleCurrency) {
        this.settleCurrency = settleCurrency;
    }

    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    public String getPayCurrency() {
        return payCurrency;
    }

    public void setPayCurrency(String payCurrency) {
        this.payCurrency = payCurrency;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public double getSettleTransRate() {
        return settleTransRate;
    }

    public void setSettleTransRate(double settleTransRate) {
        this.settleTransRate = settleTransRate;
    }

    public double getTransPayRate() {
        return transPayRate;
    }

    public void setTransPayRate(double transPayRate) {
        this.transPayRate = transPayRate;
    }

    public BigDecimal getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(BigDecimal buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public BigDecimal getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(BigDecimal receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public BigDecimal getMdiscountAmount() {
        return mdiscountAmount;
    }

    public void setMdiscountAmount(BigDecimal mdiscountAmount) {
        this.mdiscountAmount = mdiscountAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(BigDecimal pointAmount) {
        this.pointAmount = pointAmount;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Date getSendPayDate() {
        return sendPayDate;
    }

    public void setSendPayDate(Date sendPayDate) {
        this.sendPayDate = sendPayDate;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public List<TradeFundBill> getFundBillList() {
        return fundBillList;
    }

    public void setFundBillList(List<TradeFundBill> fundBillList) {
        this.fundBillList = fundBillList;
    }

    public String getChargeFlags() {
        return chargeFlags;
    }

    public void setChargeFlags(String chargeFlags) {
        this.chargeFlags = chargeFlags;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public TradeSettleInfo getTradeSettleInfo() {
        return tradeSettleInfo;
    }

    public void setTradeSettleInfo(TradeSettleInfo tradeSettleInfo) {
        this.tradeSettleInfo = tradeSettleInfo;
    }

    public String getAuthTradePayMode() {
        return authTradePayMode;
    }

    public void setAuthTradePayMode(String authTradePayMode) {
        this.authTradePayMode = authTradePayMode;
    }

    public String getAlipaySubMerchantId() {
        return alipaySubMerchantId;
    }

    public void setAlipaySubMerchantId(String alipaySubMerchantId) {
        this.alipaySubMerchantId = alipaySubMerchantId;
    }

    public String getExtInfos() {
        return extInfos;
    }

    public void setExtInfos(String extInfos) {
        this.extInfos = extInfos;
    }
    
}
