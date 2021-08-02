package cn.whl.payutils.alipay.vo.agreement;

import cn.whl.payutils.alipay.vo.AliPayOut;
import cn.whl.payutils.common.agreement.SignOut;

/**
 * 阿里支付订单关闭返回参数封装
 * @author wuhailong
 */
public class AliPaySignOut extends AliPayOut implements SignOut{
    //通用部分 
    private String externalAgreementNo;     //商户签约号，代扣协议中标示用户的唯一签约号（确保在商户系统中唯一）
    
    
     
    private String form;      //提交表单

    public String getExternalAgreementNo() {
        return externalAgreementNo;
    }

    public void setExternalAgreementNo(String externalAgreementNo) {
        this.externalAgreementNo = externalAgreementNo;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
    
}
