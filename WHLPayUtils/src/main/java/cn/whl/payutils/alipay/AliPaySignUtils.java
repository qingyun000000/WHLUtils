package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.vo.agreement.AliPaySignOut;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignIn;
import cn.whl.payutils.enums.PayType;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayUserAgreementPageSignModel;
import com.alipay.api.request.AlipayUserAgreementPageSignRequest;
import com.alipay.api.response.AlipayUserAgreementPageSignResponse;

/**
 * 阿里支付代扣签约方法
 * @author wuhailong
 */
public class AliPaySignUtils {

    public static AliPaySignOut sign(AliPaySignIn in) throws AlipayApiException, Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(), in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayUserAgreementPageSignRequest request = new AlipayUserAgreementPageSignRequest ();
        request.setNotifyUrl(in.getNotifyUrl());
        request.setReturnUrl(in.getReturnUrl());
        
        AlipayUserAgreementPageSignModel model = new AlipayUserAgreementPageSignModel();
        if(in.getProductCode()!= null && !"".equals(in.getProductCode())){
            model.setProductCode(in.getProductCode());  //销售产品码，商户签约的支付宝合同所对应的产品码。周期扣款场景固定为 CYCLE_PAY_AUTH。
        }
        if(in.getExternalLogonId()!= null && !"".equals(in.getExternalLogonId())){
            model.setExternalLogonId(in.getExternalLogonId()); //用户在商户网站的登录账号，用于在签约页面展示，如果为空，则不展示
        }
        model.setPersonalProductCode(in.getPersonalProductCode()); //个人签约产品码，商户和支付宝签约时确定，商户可咨询技术支持。周期扣款个人签约产品码固定为 CYCLE_PAY_AUTH_P
        if(in.getSignScene()!= null && !"".equals(in.getSignScene())){
            model.setSignScene(in.getSignScene());     //INDUSTRY|CARRENTAL 	协议签约场景，商户和支付宝签约时确定，商户可咨询技术支持。当传入商户签约号external_agreement_no时，场景不能为默认值DEFAULT|DEFAULT。
        }
        if(in.getExternalAgreementNo()!= null && !"".equals(in.getExternalAgreementNo())){
            model.setExternalAgreementNo(in.getExternalAgreementNo());
        }
        if(in.getThirdPartyType()!= null && !"".equals(in.getThirdPartyType())){
            model.setThirdPartyType(in.getThirdPartyType());
        }
        if(in.getSignValidityPeriod()!= null && !"".equals(in.getSignValidityPeriod())){
            model.setSignValidityPeriod(in.getSignValidityPeriod());
        }
        if(in.getZmAuthParams() != null){
            model.setZmAuthParams(in.getZmAuthParams());
        }
        if(in.getProdParams() != null){
            model.setProdParams(in.getProdParams());
        }
        if(in.getPromoParams()!= null && !"".equals(in.getPromoParams())){
            model.setPromoParams(in.getPromoParams());
        }
        if(in.getAccessParams()!= null){
            model.setAccessParams(in.getAccessParams());
        }
        if(in.getSubMerchantParams() != null){
            model.setSubMerchant(in.getSubMerchantParams());
        }
        if(in.getDeviceParams() != null){
            model.setDeviceParams(in.getDeviceParams());
        }
        if(in.getIdentityParams() != null){
            model.setIdentityParams(in.getIdentityParams());
        }
        if(in.getAgreementEffectType()!= null && !"".equals(in.getAgreementEffectType())){
            model.setAgreementEffectType(in.getAgreementEffectType());
        }
        if(in.getUserAgeRange()!= null && !"".equals(in.getUserAgeRange())){
            model.setUserAgeRange(in.getUserAgeRange());
        }
        if(in.getPeriodRuleParams() != null){
            model.setPeriodRuleParams(in.getPeriodRuleParams());
        }
        request.setBizModel(model);
        

        AlipayUserAgreementPageSignResponse response = alipayClient.execute(request);
        
        System.out.println(response.isSuccess());
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        System.out.println(response.getSubMsg());
        //System.out.println(response.getTradeNo());
        //System.out.println(response.getTotalAmount());
        //System.out.println(response.getSellerId());
        //System.out.println(response.getMerchantOrderNo());
        System.out.println(response.getBody());
        
        if (response.isSuccess()) {
            System.out.println("调用成功");
            AliPaySignOut out = new AliPaySignOut();
            out.setPayType(PayType.SIGN);
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setExternalAgreementNo(response.getExternalAgreementNo());
            out.setForm(response.getBody());
            return out;
        } else {
            System.out.println(response);
            throw new Exception("下单失败");
        }
    }
    
}
