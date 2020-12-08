package cn.whl.payutils.alipay.vo.pay;

import cn.whl.payutils.alipay.vo.AliPayIn;
import com.alipay.api.domain.AgreementSignParams;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.InvoiceInfo;
import com.alipay.api.domain.RoyaltyInfo;
import com.alipay.api.domain.SettleInfo;
import com.alipay.api.domain.SubMerchant;
import java.math.BigDecimal;
import java.util.List;
import cn.whl.payutils.interfaces.pay.PayIn;


/**
 * 阿里支付下单传入参数封装
 * @author wuhailong
 */
public class AliPayPayIn extends AliPayIn implements PayIn{
    //通用部分 
    private String outTradeNo;   //必选， 商户网站唯一订单号

    private String productCode;      //必选，销售商品码，商家和支付宝签约的产品码， <64位   

    private BigDecimal totalAmount;     //必选，订单总金额，0.01-100000000

    private String subject;      //必选， 商品标题/订单标题， <256位

    private String body;         //可选， 交易描述，<128位

    private String timeoutExpress;  //可选， 最晚付款时间 1m-15d  m, h, d, 1c-当天

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
    
    
    
    //wap+app
    private String specifiedChannel;         //可选， 指定渠道，目前仅支持pcredit，不能与花呗分期参数同时传入
    
    
    
    //page+app
    private List<GoodsDetail> goodsDetails;            //可选， 商品列表信息
    
    private AgreementSignParams agreementSignParams;   //签约信息，支付后签约场景使用
    
    
    
    //wap
    private String sellerId;        //可选，收款方支付宝用户ID，为空则默认位商户签约账号对应的支付宝用户ID
    
    private String authToken;       //可选，用户授权接口，<40位
    
    private String quitUrl;          //必选，付款中途退出返回商户网站地址， <400位
      
        
       
    //page
    private RoyaltyInfo royaltyInfo;               //可选， 分账信息
    
    private SubMerchant subMerchant;               //可选， 间接受理商户信息体
    
    private String qrPayMode;                     //前置模式（二维码潜入到商户页面iframe, 0-简约前置，w600h300px;1-前置，w300h600px;3-迷你前置w75h75px;4-自定义)
                                                  //跳转模式（支付宝生成的扫码页面，2）
    
    private Long qrcodeWidth;                    //自定义二维码宽度，qrPayMode=4时有效
    
    private SettleInfo settleInfo;                //描述结算信息
    
    private InvoiceInfo invoiceInfo;              //开票信息
    
    private String integrationType;               //请求后页面集成方式，ALIAPP：支付宝钱包内，PCWEB（默认）：PC端访问
    
    private String requestFromUrl;               //请求来源地址，ALIAPP集成方式中途取消返回地址
    
    

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

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
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

    public String getQuitUrl() {
        return quitUrl;
    }

    public void setQuitUrl(String quitUrl) {
        this.quitUrl = quitUrl;
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

    public String getSpecifiedChannel() {
        return specifiedChannel;
    }

    public void setSpecifiedChannel(String specifiedChannel) {
        this.specifiedChannel = specifiedChannel;
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

    public List<GoodsDetail> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public AgreementSignParams getAgreementSignParams() {
        return agreementSignParams;
    }

    public void setAgreementSignParams(AgreementSignParams agreementSignParams) {
        this.agreementSignParams = agreementSignParams;
    }

    public RoyaltyInfo getRoyaltyInfo() {
        return royaltyInfo;
    }

    public void setRoyaltyInfo(RoyaltyInfo royaltyInfo) {
        this.royaltyInfo = royaltyInfo;
    }

    public SubMerchant getSubMerchant() {
        return subMerchant;
    }

    public void setSubMerchant(SubMerchant subMerchant) {
        this.subMerchant = subMerchant;
    }

    public String getQrPayMode() {
        return qrPayMode;
    }

    public void setQrPayMode(String qrPayMode) {
        this.qrPayMode = qrPayMode;
    }

    public Long getQrcodeWidth() {
        return qrcodeWidth;
    }

    public void setQrcodeWidth(Long qrcodeWidth) {
        this.qrcodeWidth = qrcodeWidth;
    }

    public SettleInfo getSettleInfo() {
        return settleInfo;
    }

    public void setSettleInfo(SettleInfo settleInfo) {
        this.settleInfo = settleInfo;
    }

    public InvoiceInfo getInvoiceInfo() {
        return invoiceInfo;
    }

    public void setInvoiceInfo(InvoiceInfo invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }

    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public String getRequestFromUrl() {
        return requestFromUrl;
    }

    public void setRequestFromUrl(String requestFromUrl) {
        this.requestFromUrl = requestFromUrl;
    }
    
}
