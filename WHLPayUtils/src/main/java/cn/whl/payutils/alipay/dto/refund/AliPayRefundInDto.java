package cn.whl.payutils.alipay.dto.refund;

import cn.whl.payutils.alipay.dto.AliPayIn;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.OpenApiRoyaltyDetailInfoPojo;
import java.math.BigDecimal;
import java.util.List;
import cn.whl.payutils.interfaces.pay.PayIn;
import cn.whl.payutils.interfaces.refund.RefundIn;


/**
 * 阿里支付退款传入参数封装
 * @author wuhailong
 */
public class AliPayRefundInDto extends AliPayIn implements RefundIn{
    //通用部分 
    private String tradeNo;   //与outTradeNo二选一， 支付宝交易流水号
    
    private String outTradeNo;   //与outTradeNo二选一， 商户网站唯一订单号
    
    private BigDecimal refundAmount;     //退款金额
    
    private String refundCurrency;      //退款币种信息
    
    private String refundReason;        //退款原因说明
    
    private String outRequestNo;        //标识一次退款请求，用于区分同一交易的多次退款，部分退款必填
    
    private String operatorId;          //商户操作员编号
    
    private String storeId;             //商户门店编号
    
    private String terminalId;          //商户终端编号
    
    private List<GoodsDetail> goodsDetail;   //商品列表信息
    
    private List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters;   //退分帐明细信息
    
    private String orgPid;                //银行间联模式，所属收单机构Pid

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

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getOutRequestNo() {
        return outRequestNo;
    }

    public void setOutRequestNo(String outRequestNo) {
        this.outRequestNo = outRequestNo;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public List<GoodsDetail> getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(List<GoodsDetail> goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public List<OpenApiRoyaltyDetailInfoPojo> getRefundRoyaltyParameters() {
        return refundRoyaltyParameters;
    }

    public void setRefundRoyaltyParameters(List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters) {
        this.refundRoyaltyParameters = refundRoyaltyParameters;
    }

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid;
    }
    
    

    
    
}
