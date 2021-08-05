package cn.whl.payutils.alipay.vo.agreement;

import cn.whl.payutils.alipay.vo.AliPayNotifyResult;
import cn.whl.payutils.common.agreement.SignNotifyResult;

/**
 * 阿里支付订单关闭回调结果参数封装
 * @author wuhailong
 */
public class AliPaySignNotifyResult extends AliPayNotifyResult implements SignNotifyResult{
    
    private String externalAgreementNo;       //代扣协议中标示用户的唯一签约号（确保在商户系统中唯一）。
    
    private String externalLogonId;             //用户在商户网站的登录账号，如果商户接口中未传，则不会返回
    
    private String alipayUserId;                //用户签约的支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。(只有签约成功时才会返回)

    public String getExternalAgreementNo() {
        return externalAgreementNo;
    }

    public void setExternalAgreementNo(String externalAgreementNo) {
        this.externalAgreementNo = externalAgreementNo;
    }

    public String getExternalLogonId() {
        return externalLogonId;
    }

    public void setExternalLogonId(String externalLogonId) {
        this.externalLogonId = externalLogonId;
    }

    public String getAlipayUserId() {
        return alipayUserId;
    }

    public void setAlipayUserId(String alipayUserId) {
        this.alipayUserId = alipayUserId;
    }
    
    
}
