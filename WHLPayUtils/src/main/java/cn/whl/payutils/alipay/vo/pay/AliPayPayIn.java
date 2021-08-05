package cn.whl.payutils.alipay.vo.pay;

import cn.whl.payutils.alipay.vo.AliPayIn;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;
import java.math.BigDecimal;
import cn.whl.payutils.common.pay.PayIn;


/**
 * 阿里支付支付交易传入参数封装
 * @author wuhailong
 */
public class AliPayPayIn extends AliPayIn implements PayIn{
    //通用部分 
    private String outTradeNo;   //必选， 商户网站唯一订单号
    
    private String scene;       //必选, 支付场景。枚举值：
                                //bar_code：当面付条码支付场景；
                                //security_code：当面付刷脸支付场景，对应的auth_code为fp开头的刷脸标识串；
                                //周期扣款或代扣场景无需传入，协议号通过agreement_params参数传递；
                                //支付宝预授权和新当面资金授权场景无需传入，授权订单号通过 auth_no字段传入。
                                //默认值为bar_code。
    
    private String authCode;    //支付授权码。
                                //当面付场景传买家的付款码（25~30开头的长度为16~24位的数字，实际字符串长度以开发者获取的付款码长度为准）或者刷脸标识串（fp开头的35位字符串）；
                                //周期扣款或代扣场景无需传入，协议号通过agreement_params参数传递；
                                //支付宝预授权和新当面资金授权场景无需传入，授权订单号通过 auth_no字段传入。
                                //注：交易的买家与卖家不能相同。

    private String productCode;     //可选，产品码。
                                    //商家和支付宝签约的产品码。 枚举值（点击查看签约情况）：
                                    //FACE_TO_FACE_PAYMENT：当面付产品；
                                    //CYCLE_PAY_AUTH：周期扣款产品；
                                    //GENERAL_WITHHOLDING：代扣产品；
                                    //PRE_AUTH_ONLINE：支付宝预授权产品；
                                    //PRE_AUTH：新当面资金授权产品；
                                    //默认值为FACE_TO_FACE_PAYMENT。
                                    //注意：非当面付产品使用本接口时，本参数必填。请传入对应产品码。

    private BigDecimal totalAmount;     //必选，订单总金额，0.01-100000000

    private String subject;      //必选， 商品标题/订单标题， <256位

    private String body;         //可选， 交易描述，<128位

    private String timeoutExpress = "1h";  //可选， 最晚付款时间 1m-15d  m, h, d, 1c-当天

    private String timeExpire;      //可选， 绝对超时时间 yyyy-MM-dd HH:mm

    private String goodsType;       //可选，商品主类型 0-虚拟类 1-实物类

    private String passbackParams;   //可选，公共回传参数，同步返回或异步通知时原样返回，<512位， 需UrlEncode

    private String promoParams;      //可选，优惠参数（仅与支付宝协商后可用），<512位

    private ExtendParams extendParams;   //可选， 业务扩展参数
          //sys_service_provider_id  64 系统商编号
          //hb_fq_num        5  花呗分期数
          //hb_fq_seller_percent    3  手续续比例百分值
          //industry_reflux_info    512  行业数据回流信息
          //card_type           32  卡类型
    
    private String merchantOrderNo;          //可选， 商户原始订单号， <32位
    
    private String enablePayChannels;        //可选， 可用渠道，只能在指定渠道内付款，与disable_pay_channel互斥， <128位
    
    private String disablePayChannels;       //可选， 禁用渠道，只能在指定渠道内付款，与enable_pay_channel互斥， <128位
    
    private String storeId;                  //可选， 商户门店编号， <32位
     
    private String businessParams;           //可选， 商户传入业务信息，具体值要与支付宝约定，json格式， <512位
    
    private ExtUserInfo extUserInfo;         //可选， 外部指定买家
          //name    16  姓名，仅need_check_info=T有效
          //mobile  20  手机号，暂不校验
          //cert_type  32 证件类型，仅need_check_info=T有效  身份证：IDENTITY_CARD, 护照：PASSPORT，军官证：OFFICER_CARD，士兵证：SOLDIER_CARD，户口本：HOKOU
          //cert_no    64 证件号
          //min_age    3  最小买家年龄
          //fix_buyer  8   是否强制校验付款人身份信息  T/F
          //need_check_info   1  是否强制校验身份信息  T/F
    
    
    

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(String timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }


    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPassbackParams() {
        return passbackParams;
    }

    public void setPassbackParams(String passbackParams) {
        this.passbackParams = passbackParams;
    }

    public String getPromoParams() {
        return promoParams;
    }

    public void setPromoParams(String promoParams) {
        this.promoParams = promoParams;
    }

    public ExtendParams getExtendParams() {
        return extendParams;
    }

    public void setExtendParams(ExtendParams extendParams) {
        this.extendParams = extendParams;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getEnablePayChannels() {
        return enablePayChannels;
    }

    public void setEnablePayChannels(String enablePayChannels) {
        this.enablePayChannels = enablePayChannels;
    }

    public String getDisablePayChannels() {
        return disablePayChannels;
    }

    public void setDisablePayChannels(String disablePayChannels) {
        this.disablePayChannels = disablePayChannels;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getBusinessParams() {
        return businessParams;
    }

    public void setBusinessParams(String businessParams) {
        this.businessParams = businessParams;
    }

    public ExtUserInfo getExtUserInfo() {
        return extUserInfo;
    }

    public void setExtUserInfo(ExtUserInfo extUserInfo) {
        this.extUserInfo = extUserInfo;
    }

    
}
