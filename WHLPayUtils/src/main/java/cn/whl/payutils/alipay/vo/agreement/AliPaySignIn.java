package cn.whl.payutils.alipay.vo.agreement;

import cn.whl.payutils.alipay.vo.AliPayIn;
import cn.whl.payutils.common.agreement.SignIn;
import com.alipay.api.domain.AccessParams;
import com.alipay.api.domain.DeviceParams;
import com.alipay.api.domain.IdentityParams;
import com.alipay.api.domain.PeriodRuleParams;
import com.alipay.api.domain.ProdParams;
import com.alipay.api.domain.SubMerchantParams;
import com.alipay.api.domain.ZmAuthParams;


/**
 * 阿里支付订单关闭传入参数封装
 * @author wuhailong
 */
public class AliPaySignIn extends AliPayIn implements SignIn{
    
    private String productCode;             //可选，销售产品码，商户签约的支付宝合同所对应的产品码。周期扣款场景固定为 CYCLE_PAY_AUTH。     
    
    private String externalLogonId;         //可选，用户在商户网站的登录账号，用于在签约页面展示，如果为空，则不展示
    
    private String personalProductCode;      //必选，个人签约产品码，商户和支付宝签约时确定，商户可咨询技术支持。周期扣款个人签约产品码固定为 CYCLE_PAY_AUTH_P
    
    private String signScene = "INDUSTRY|CARRENTAL";    //可选，协议签约场景，商户和支付宝签约时确定，商户可咨询技术支持。当传入商户签约号external_agreement_no时，场景不能为默认值DEFAULT|DEFAULT。

    private String externalAgreementNo;     //可选，商户签约号，代扣协议中标示用户的唯一签约号（确保在商户系统中唯一）。
                                            //格式规则：支持大写小写字母和数字，最长32位。商户系统按需传入，如果同一用户在同一产品码、同一签约场景下，签订了多份代扣协议，那么需要指定并传入该值。
    
    private String thirdPartyType = "PARTNER";          //可选，签约第三方主体类型。对于三方协议，表示当前用户和哪一类的第三方主体进行签约。
                                            //取值范围：
                                            //1. PARTNER（平台商户）
                                            //2. MERCHANT（集团商户），集团下子商户可共享用户签约内容
                                            //默认为PARTNER。
    
    private String signValidityPeriod;      //可选，当前用户签约请求的协议有效周期。
                                            //整形数字加上时间单位的协议有效期，从发起签约请求的时间开始算起。
                                            //目前支持的时间单位：
                                            //1. d：天
                                            //2. m：月
                                            //如果未传入，默认为长期有效。
    
    private ZmAuthParams zmAuthParams;      //可选， 芝麻授权信息，针对于信用代扣签约。json格式。
                                            //buckle_app_id 可选 商户在芝麻端申请的appId
                                            //buckle_merchant_id 必填 商户在芝麻端申请的merchantId
    
    private ProdParams prodParams;          //可选，签约产品属性，json格式
                                            //auth_biz_params 可选 预授权业务信息	 {"platform":"taobao"}
    
    private String promoParams;             //可选, 签约营销参数，此值为json格式；具体的key需与营销约定 {"key":"value"}
    
    private AccessParams accessParams;      //可选，请按当前接入的方式进行填充，且输入值必须为文档中的参数取值范围。扫码或者短信页面签约需要拼装http的请求地址访问中间页面，钱包h5页面签约可直接拼接scheme的请求地址
                                            //channel 必填 目前支持以下值：1. ALIPAYAPP （钱包h5页面签约）2. QRCODE(扫码签约) 3. QRCODEORSMS(扫码签约或者短信签约)	ALIPAYAPP
    
    private SubMerchantParams subMerchantParams;    //可选, 此参数用于传递子商户信息，无特殊需求时不用关注。目前商户代扣、海外代扣、淘旅行信用住产品支持传入该参数（在销售方案中“是否允许自定义子商户信息”需要选是）。
                                                    //sub_merchant_id	String	可选	20	子商户的商户id	2088123412341234
                                                    //sub_merchant_name	String	可选	50	子商户的商户名称	滴滴出行
                                                    //sub_merchant_service_name	String	可选	50	子商户的服务名称	滴滴出行免密支付
                                                    //sub_merchant_service_description	String	可选	150	子商户的服务描述	免密付车费，单次最高500
    
    private DeviceParams deviceParams;      //可选，设备信息参数，在使用设备维度签约代扣协议时，可以传这些信息
                                            //device_id	String	可选	256	设备Id	device12345
                                            //device_name	String	可选	128	设备名称	电视
                                            //device_type	String	可选	128	设备类型，目前有四种值：
                                            //VR一体机：VR_MACHINE、电视：TV、身份证：ID_CARD、工牌：WORK_CARD	TV
    
    private IdentityParams identityParams;  //可选，用户实名信息参数，包含：姓名、身份证号、签约指定uid。商户传入用户实名信息参数，支付宝会对比用户在支付宝端的实名信息。
                                            //user_name	String	可选	64	用户姓名	张三
                                            //cert_no	String	可选	64	用户身份证号	61102619921108888
                                            //identity_hash	String	可选	128	用户实名信息hash值	8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92
                                            //sign_user_id	String	可选	32	签约指定用户的uid，如用户登录的uid和指定的用户uid不一致则报错	2088202888530893
    
    private String agreementEffectType;     //协议生效类型, 用于指定协议是立即生效还是等待商户通知再生效. 可空, 不填默认为立即生效.
                                            //DIRECT: 立即生效.
                                            //NOTICE: 商户通知生效, 需要再次调用alipay.user.agreement.sign.effect （支付宝个人协议签约生效接口）接口推进协议生效.
                                            //默认为DIRECT
    
    private String userAgeRange;            //商户希望限制的签约用户的年龄范围，min表示可签该协议的用户年龄下限，max表示年龄上限。如{"min": "18","max": "30"}表示18=<年龄<=30的用户可以签约该协议。
    
    private PeriodRuleParams periodRuleParams;  //特殊可选，周期管控规则参数period_rule_params，在签约周期扣款产品（如CYCLE_PAY_AUTH_P）时必传，在签约其他产品时无需传入。 周期扣款产品，会按照这里传入的参数提示用户，并对发起扣款的时间、金额、次数等做相应限制。
                                                //period_type	String	必填	20	周期类型period_type是周期扣款产品必填，枚举值为DAY和MONTH。DAY即扣款周期按天计，MONTH代表扣款周期按自然月。与另一参数period组合使用确定扣款周期，例如period_type为DAY，period=30，则扣款周期为30天；period_type为MONTH，period=3，则扣款周期为3个自然月。自然月是指，不论这个月有多少天，周期都计算到月份中的同一日期。例如1月3日到2月3日为一个自然月，1月3日到4月3日为三个自然月。注意周期类型使用MONTH的时候，计划扣款时间execute_time不允许传28日之后的日期（可以传28日），以此避免有些月份可能不存在对应日期的情况。
                                                //period	Number	必填	8	周期数period是周期扣款产品必填。与另一参数period_type组合使用确定扣款周期，例如period_type为DAY，period=90，则扣款周期为9.
                                                //execute_time	String	必填	16	首次执行时间execute_time是周期扣款产品必填，即商户发起首次扣款的时间。精确到日，格式为yyyy-MM-dd, 结合其他必填的扣款周期参数，会确定商户以后的扣款计划。发起扣款的时间需符合这里的扣款计划。	2019-01-23
                                                //single_amount	Price	必填	32	单次扣款最大金额single_amount是周期扣款产品必填，即每次发起扣款时限制的最大金额，单位为元。商户每次发起扣款都不允许大于此金额。	10.99
                                                //total_amount	Price	可选	32	总金额限制，单位为元。如果传入此参数，商户多次扣款的累计金额不允许超过此金额。	600
                                                //total_payments	Number	可选	8	总扣款次数。如果传入此参数，则商户成功扣款的次数不能超过此次数限制（扣款失败不计入）。	12

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getExternalLogonId() {
        return externalLogonId;
    }

    public void setExternalLogonId(String externalLogonId) {
        this.externalLogonId = externalLogonId;
    }

    public String getPersonalProductCode() {
        return personalProductCode;
    }

    public void setPersonalProductCode(String personalProductCode) {
        this.personalProductCode = personalProductCode;
    }

    public String getSignScene() {
        return signScene;
    }

    public void setSignScene(String signScene) {
        this.signScene = signScene;
    }

    public String getExternalAgreementNo() {
        return externalAgreementNo;
    }

    public void setExternalAgreementNo(String externalAgreementNo) {
        this.externalAgreementNo = externalAgreementNo;
    }

    public String getThirdPartyType() {
        return thirdPartyType;
    }

    public void setThirdPartyType(String thirdPartyType) {
        this.thirdPartyType = thirdPartyType;
    }

    public String getSignValidityPeriod() {
        return signValidityPeriod;
    }

    public void setSignValidityPeriod(String signValidityPeriod) {
        this.signValidityPeriod = signValidityPeriod;
    }

    public ZmAuthParams getZmAuthParams() {
        return zmAuthParams;
    }

    public void setZmAuthParams(ZmAuthParams zmAuthParams) {
        this.zmAuthParams = zmAuthParams;
    }

    public ProdParams getProdParams() {
        return prodParams;
    }

    public void setProdParams(ProdParams prodParams) {
        this.prodParams = prodParams;
    }

    public String getPromoParams() {
        return promoParams;
    }

    public void setPromoParams(String promoParams) {
        this.promoParams = promoParams;
    }

    public AccessParams getAccessParams() {
        return accessParams;
    }

    public void setAccessParams(AccessParams accessParams) {
        this.accessParams = accessParams;
    }

    public SubMerchantParams getSubMerchantParams() {
        return subMerchantParams;
    }

    public void setSubMerchantParams(SubMerchantParams subMerchantParams) {
        this.subMerchantParams = subMerchantParams;
    }

    public DeviceParams getDeviceParams() {
        return deviceParams;
    }

    public void setDeviceParams(DeviceParams deviceParams) {
        this.deviceParams = deviceParams;
    }

    public IdentityParams getIdentityParams() {
        return identityParams;
    }

    public void setIdentityParams(IdentityParams identityParams) {
        this.identityParams = identityParams;
    }

    public String getAgreementEffectType() {
        return agreementEffectType;
    }

    public void setAgreementEffectType(String agreementEffectType) {
        this.agreementEffectType = agreementEffectType;
    }

    public String getUserAgeRange() {
        return userAgeRange;
    }

    public void setUserAgeRange(String userAgeRange) {
        this.userAgeRange = userAgeRange;
    }

    public PeriodRuleParams getPeriodRuleParams() {
        return periodRuleParams;
    }

    public void setPeriodRuleParams(PeriodRuleParams periodRuleParams) {
        this.periodRuleParams = periodRuleParams;
    }
    
    
}
