package cn.whl.payutils.alipay.dto;

import cn.whl.payutils.PayInDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import com.alipay.api.domain.AgreementSignParams;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.InvoiceInfo;
import com.alipay.api.domain.RoyaltyInfo;
import com.alipay.api.domain.SettleInfo;
import com.alipay.api.domain.SubMerchant;
import java.util.List;


/**
 * 阿里支付下单传入参数封装
 * @author wuhailong
 */
public class AliPayRefundQueryInDto extends AliPayInDto implements PayInDto{
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
