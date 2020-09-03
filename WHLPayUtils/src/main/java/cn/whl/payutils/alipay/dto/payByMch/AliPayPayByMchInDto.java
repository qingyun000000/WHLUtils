package cn.whl.payutils.alipay.dto.payByMch;

import cn.whl.payutils.alipay.dto.AliPayIn;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import com.alipay.api.domain.AgreementSignParams;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.InvoiceInfo;
import com.alipay.api.domain.Participant;
import com.alipay.api.domain.RoyaltyInfo;
import com.alipay.api.domain.SettleInfo;
import com.alipay.api.domain.SubMerchant;
import java.math.BigDecimal;
import java.util.List;
import cn.whl.payutils.interfaces.pay.PayIn;
import cn.whl.payutils.interfaces.payByMch.PayByMchIn;


/**
 * 阿里支付下单传入参数封装
 * @author wuhailong
 */
public class AliPayPayByMchInDto extends AliPayIn implements PayByMchIn{
    //接口部分
    private Platform platform;
    
    private PayType payType;

    @Override
    public Platform getPlatform() {
        return platform;
    }

    @Override
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public PayType getPayType() {
        return payType;
    }

    @Override
    public void setPayType(PayType payType) {
        this.payType = payType;
    }
    
    //通用部分 
    private String outTradeNo;   //必选， 商户网站唯一订单号

    private String productCode;      //必选，业务产品码：STD_RED_PACKET 收发现金红包；TRANS_ACCOUNT_NO_PWD 单笔无密转帐到支付宝账户；TRANS_BANKCARD_NO_PWD 单笔无密转账到银行卡

    private BigDecimal amt;     //必选，金额，0.01-100000000

    private String bizScene;    //选填，业务场景:PERSONAL_COLLECTION C2C现金红包-领红包；DIRECT_TRANSFER B2C现金红包，单笔无密转账到支付宝/银行卡
    
    private String orderTitle;  //选填，转账业务标题（用户账单显示）
    
    private String originalOrderId;  //选填，原支付宝业务单号（C2C领红包时，传红包支付时返回的支付宝单号；B2C，转账到支付宝/银行卡无需此参数）
    
    private Participant payeeInfo;      //必填，收款方信息
    
    private String remark;           //选填，业务备注
    
    private String businessParams;   //选填，扩展参数，json格式:sub_biz_scene: B2C红包，C2C红包必填（值REDPACKET）; withdraw_timeliness, 预期到账时间（可选，T0：T+0，T1：T+1,支付宝不保证到账）

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public String getBizScene() {
        return bizScene;
    }

    public void setBizScene(String bizScene) {
        this.bizScene = bizScene;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(String originalOrderId) {
        this.originalOrderId = originalOrderId;
    }

    public Participant getPayeeInfo() {
        return payeeInfo;
    }

    public void setPayeeInfo(Participant payeeInfo) {
        this.payeeInfo = payeeInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBusinessParams() {
        return businessParams;
    }

    public void setBusinessParams(String businessParams) {
        this.businessParams = businessParams;
    }
    
    
}
