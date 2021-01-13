package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.vo.create.AliPayCreateIn;
import cn.whl.payutils.alipay.vo.create.AliPayCreateOut;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeCreateModel;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import java.math.BigDecimal;

/**
 * 阿里支付创建订单方法工具
 *
 * @author wuhailong
 */
public class AliPayCreateUtils {

    public static AliPayCreateOut preCreate(AliPayCreateIn in) throws AlipayApiException, Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(), in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setNotifyUrl(in.getNotifyUrl());
        request.setReturnUrl(in.getReturnUrl());
        
        AlipayTradeCreateModel model = new AlipayTradeCreateModel();
        if (in.getBody() != null && !"".equals(in.getBody())) {
            model.setBody(in.getBody());
        }
        model.setSubject(in.getSubject());
        model.setOutTradeNo(in.getOutTradeNo());
        if (in.getTimeoutExpress() != null && !"".equals(in.getTimeoutExpress())) {
            model.setTimeoutExpress(in.getTimeoutExpress());
        }
        model.setTotalAmount(in.getTotalAmount().toPlainString());
        model.setProductCode(in.getProductCode());
        if (in.getExtendParams() != null) {
            model.setExtendParams(in.getExtendParams());
        }
        if (in.getMerchantOrderNo() != null && !"".equals(in.getMerchantOrderNo())) {
            model.setMerchantOrderNo(in.getMerchantOrderNo());
        }
        if (in.getEnablePayChannels() != null && !"".equals(in.getEnablePayChannels())) {
            model.setEnablePayChannels(in.getEnablePayChannels());
        }
        if (in.getDisablePayChannels() != null && !"".equals(in.getDisablePayChannels())) {
            model.setDisablePayChannels(in.getDisablePayChannels());
        }
        if (in.getStoreId() != null && !"".equals(in.getStoreId())) {
            model.setStoreId(in.getStoreId());
        }
        if (in.getExtUserInfo() != null) {
            model.setExtUserInfo(in.getExtUserInfo());
        }
        request.setBizModel(model);
        

        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        
        System.out.println(response.isSuccess());
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        System.out.println(response.getSubMsg());
        System.out.println(response.getOutTradeNo());
        //System.out.println(response.getTradeNo());
        //System.out.println(response.getTotalAmount());
        //System.out.println(response.getSellerId());
        //System.out.println(response.getMerchantOrderNo());
        System.out.println(response.getBody());
        
        if (response.isSuccess()) {
            System.out.println("调用成功");
            AliPayCreateOut out = new AliPayCreateOut();
            //wap支付方式，返回的生成表单的字符串
            out.setPayType(PayType.PRE);
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setOutTradeNo(response.getOutTradeNo());
            out.setResultJson(response.getBody());
            return out;
        } else {
            System.out.println(response);
            throw new Exception("下单失败");
        }
    }

    public static AliPayCreateOut create(AliPayCreateIn in) throws AlipayApiException, Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(), in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();

        AlipayTradeCreateResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功");
            AliPayCreateOut out = new AliPayCreateOut();
            //wap支付方式，返回的生成表单的字符串
            out.setPayType(PayType.COMMON);
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setOutTradeNo(response.getOutTradeNo());
            out.setTradeNo(response.getTradeNo());
            out.setForm(response.getBody());
            return out;
        } else {
            System.out.println(response);
            throw new Exception("下单失败");
        }
    }

    public static AliPayCreateOut wapPay(AliPayCreateIn in) throws AlipayApiException, Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(), in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        request.setNotifyUrl(in.getNotifyUrl());
        request.setReturnUrl(in.getReturnUrl());

        AlipayTradeWapPayModel model = new AlipayTradeWapPayModel();
        if (in.getBody() != null && !"".equals(in.getBody())) {
            model.setBody(in.getBody());
        }
        model.setSubject(in.getSubject());
        model.setOutTradeNo(in.getOutTradeNo());
        if (in.getTimeoutExpress() != null && !"".equals(in.getTimeoutExpress())) {
            model.setTimeoutExpress(in.getTimeoutExpress());
        }
        if (in.getTimeExpire() != null && !"".equals(in.getTimeExpire())) {
            model.setTimeExpire(in.getTimeExpire());
        }
        model.setTotalAmount(in.getTotalAmount().toPlainString());
        if (in.getAuthToken() != null && !"".equals(in.getAuthToken())) {
            model.setAuthToken(in.getAuthToken());
        }
        if (in.getGoodsType() != null && !"".equals(in.getGoodsType())) {
            model.setGoodsType(in.getGoodsType());
        }
        if (in.getPassbackParams() != null && !"".equals(in.getPassbackParams())) {
            model.setPassbackParams(in.getPassbackParams());
        }
        if (in.getQuitUrl() != null && !"".equals(in.getQuitUrl())) {
            model.setQuitUrl(in.getQuitUrl());
        }
        model.setProductCode(in.getProductCode());
        if (in.getPromoParams() != null && !"".equals(in.getPromoParams())) {
            model.setPromoParams(in.getPromoParams());
        }
        if (in.getExtendParams() != null) {
            model.setExtendParams(in.getExtendParams());
        }
        if (in.getMerchantOrderNo() != null && !"".equals(in.getMerchantOrderNo())) {
            model.setMerchantOrderNo(in.getMerchantOrderNo());
        }
        if (in.getEnablePayChannels() != null && !"".equals(in.getEnablePayChannels())) {
            model.setEnablePayChannels(in.getEnablePayChannels());
        }
        if (in.getDisablePayChannels() != null && !"".equals(in.getDisablePayChannels())) {
            model.setDisablePayChannels(in.getDisablePayChannels());
        }
        if (in.getStoreId() != null && !"".equals(in.getStoreId())) {
            model.setStoreId(in.getStoreId());
        }
        if (in.getSpecifiedChannel() != null && !"".equals(in.getSpecifiedChannel())) {
            model.setSpecifiedChannel(in.getSpecifiedChannel());
        }
        if (in.getBusinessParams() != null && !"".equals(in.getBusinessParams())) {
            model.setBusinessParams(in.getBusinessParams());
        }
        if (in.getExtUserInfo() != null) {
            model.setExtUserInfo(in.getExtUserInfo());
        }
        request.setBizModel(model);

        AlipayTradeWapPayResponse response = alipayClient.pageExecute(request);

        System.out.println(response.isSuccess());
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        System.out.println(response.getSubMsg());
        System.out.println(response.getOutTradeNo());
        System.out.println(response.getTradeNo());
        System.out.println(response.getTotalAmount());
        System.out.println(response.getSellerId());
        System.out.println(response.getMerchantOrderNo());
        System.out.println(response.getBody());

        if(response.isSuccess()){
            AliPayCreateOut out = new AliPayCreateOut();
            //page支付方式，返回的生成表单的字符串
            out.setPayType(PayType.PAGE);
            out.setForm(response.getBody());
            return out;
        }else{
            throw new Exception("支付宝下单失败，原因为" + response.getMsg());
        }
        
    }

    public static AliPayCreateOut pagePay(AliPayCreateIn in) throws AlipayApiException, Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(), in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(in.getNotifyUrl());
        request.setReturnUrl(in.getReturnUrl());

        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        if (in.getBody() != null && !"".equals(in.getBody())) {
            model.setBody(in.getBody());
        }
        model.setSubject(in.getSubject());
        model.setOutTradeNo(in.getOutTradeNo());
        if (in.getTimeoutExpress() != null && !"".equals(in.getTimeoutExpress())) {
            model.setTimeoutExpress(in.getTimeoutExpress());
        }
        if (in.getTimeExpire() != null && !"".equals(in.getTimeExpire())) {
            model.setTimeExpire(in.getTimeExpire());
        }
        model.setTotalAmount(in.getTotalAmount() + "");
        if (in.getGoodsType() != null && !"".equals(in.getGoodsType())) {
            model.setGoodsType(in.getGoodsType());
        }
        if (in.getPassbackParams() != null && !"".equals(in.getPassbackParams())) {
            model.setPassbackParams(in.getPassbackParams());
        }
        model.setProductCode(in.getProductCode());
        if (in.getPromoParams() != null && !"".equals(in.getPromoParams())) {
            model.setPromoParams(in.getPromoParams());
        }
        if (in.getExtendParams() != null) {
            model.setExtendParams(in.getExtendParams());
        }
        if (in.getMerchantOrderNo() != null && !"".equals(in.getMerchantOrderNo())) {
            model.setMerchantOrderNo(in.getMerchantOrderNo());
        }
        if (in.getEnablePayChannels() != null && !"".equals(in.getEnablePayChannels())) {
            model.setEnablePayChannels(in.getEnablePayChannels());
        }
        if (in.getDisablePayChannels() != null && !"".equals(in.getDisablePayChannels())) {
            model.setDisablePayChannels(in.getDisablePayChannels());
        }
        if (in.getStoreId() != null && !"".equals(in.getStoreId())) {
            model.setStoreId(in.getStoreId());
        }
        if (in.getBusinessParams() != null && !"".equals(in.getBusinessParams())) {
            model.setBusinessParams(in.getBusinessParams());
        }
        if (in.getExtUserInfo() != null) {
            model.setExtUserInfo(in.getExtUserInfo());
        }
        if (in.getGoodsDetails() != null && in.getGoodsDetails().size() > 0) {
            model.setGoodsDetail(in.getGoodsDetails());
        }
        if (in.getAgreementSignParams() != null) {
            model.setAgreementSignParams(in.getAgreementSignParams());
        }
        if (in.getRoyaltyInfo() != null) {
            model.setRoyaltyInfo(in.getRoyaltyInfo());
        }
        if (in.getSubMerchant() != null) {
            model.setSubMerchant(in.getSubMerchant());
        }
        if (in.getQrPayMode() != null && !"".equals(in.getQrPayMode())) {
            model.setQrPayMode(in.getQrPayMode());
        }
        if (in.getQrcodeWidth() != null && !"".equals(in.getQrcodeWidth())) {
            model.setQrcodeWidth(in.getQrcodeWidth());
        }
        if (in.getSettleInfo() != null) {
            model.setSettleInfo(in.getSettleInfo());
        }
        if (in.getInvoiceInfo() != null) {
            model.setInvoiceInfo(in.getInvoiceInfo());
        }
        if (in.getIntegrationType() != null && !"".equals(in.getIntegrationType())) {
            model.setIntegrationType(in.getIntegrationType());
        }
        if (in.getRequestFromUrl() != null && !"".equals(in.getRequestFromUrl())) {
            model.setRequestFromUrl(in.getRequestFromUrl());
        }
        request.setBizModel(model);

        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);

        System.out.println(response.isSuccess());
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        System.out.println(response.getSubMsg());
        System.out.println(response.getOutTradeNo());
        System.out.println(response.getTradeNo());
        System.out.println(response.getTotalAmount());
        System.out.println(response.getSellerId());
        System.out.println(response.getMerchantOrderNo());
        System.out.println(response.getBody());

        if(response.isSuccess()){
            AliPayCreateOut out = new AliPayCreateOut();
            //page支付方式，返回的生成表单的字符串
            out.setPayType(PayType.PAGE);
            out.setForm(response.getBody());
            return out;
        }else{
            throw new Exception("支付宝下单失败，原因为" + response.getMsg());
        }

    }

    public static AliPayCreateOut appPay(AliPayCreateIn in) throws AlipayApiException, Exception {

        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(), in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(in.getNotifyUrl());
        request.setReturnUrl(in.getReturnUrl());

        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        if (in.getBody() != null && !"".equals(in.getBody())) {
            model.setBody(in.getBody());
        }
        model.setSubject(in.getSubject());
        model.setOutTradeNo(in.getOutTradeNo());
        if (in.getTimeoutExpress() != null && !"".equals(in.getTimeoutExpress())) {
            model.setTimeoutExpress(in.getTimeoutExpress());
        }
        if (in.getTimeExpire() != null && !"".equals(in.getTimeExpire())) {
            model.setTimeExpire(in.getTimeExpire());
        }
        model.setTotalAmount(in.getTotalAmount() + "");
        if (in.getGoodsType() != null && !"".equals(in.getGoodsType())) {
            model.setGoodsType(in.getGoodsType());
        }
        if (in.getPassbackParams() != null && !"".equals(in.getPassbackParams())) {
            model.setPassbackParams(in.getPassbackParams());
        }
        model.setProductCode(in.getProductCode());
        if (in.getPromoParams() != null && !"".equals(in.getPromoParams())) {
            model.setPromoParams(in.getPromoParams());
        }
        if (in.getExtendParams() != null) {
            model.setExtendParams(in.getExtendParams());
        }
        if (in.getMerchantOrderNo() != null && !"".equals(in.getMerchantOrderNo())) {
            model.setMerchantOrderNo(in.getMerchantOrderNo());
        }
        if (in.getEnablePayChannels() != null && !"".equals(in.getEnablePayChannels())) {
            model.setEnablePayChannels(in.getEnablePayChannels());
        }
        if (in.getDisablePayChannels() != null && !"".equals(in.getDisablePayChannels())) {
            model.setDisablePayChannels(in.getDisablePayChannels());
        }
        if (in.getStoreId() != null && !"".equals(in.getStoreId())) {
            model.setStoreId(in.getStoreId());
        }
        if (in.getBusinessParams() != null && !"".equals(in.getBusinessParams())) {
            model.setBusinessParams(in.getBusinessParams());
        }
        if (in.getExtUserInfo() != null) {
            model.setExtUserInfo(in.getExtUserInfo());
        }
        if (in.getGoodsDetails() != null && in.getGoodsDetails().size() > 0) {
            model.setGoodsDetail(in.getGoodsDetails());
        }
        if (in.getAgreementSignParams() != null) {
            model.setAgreementSignParams(in.getAgreementSignParams());
        }
        if (in.getRoyaltyInfo() != null) {
            model.setRoyaltyInfo(in.getRoyaltyInfo());
        }
        if (in.getSubMerchant() != null) {
            model.setSubMerchant(in.getSubMerchant());
        }
        if (in.getQrPayMode() != null && !"".equals(in.getQrPayMode())) {
            model.setQrPayMode(in.getQrPayMode());
        }
        if (in.getQrcodeWidth() != null && !"".equals(in.getQrcodeWidth())) {
            model.setQrcodeWidth(in.getQrcodeWidth());
        }
        if (in.getSettleInfo() != null) {
            model.setSettleInfo(in.getSettleInfo());
        }
        if (in.getInvoiceInfo() != null) {
            model.setInvoiceInfo(in.getInvoiceInfo());
        }
        if (in.getIntegrationType() != null && !"".equals(in.getIntegrationType())) {
            model.setIntegrationType(in.getIntegrationType());
        }
        if (in.getRequestFromUrl() != null && !"".equals(in.getRequestFromUrl())) {
            model.setRequestFromUrl(in.getRequestFromUrl());
        }
        request.setBizModel(model);

        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);

        if ("10000".equals(response.getCode())) {
            AliPayCreateOut out = new AliPayCreateOut();
            //page支付方式，返回的生成表单的字符串
            out.setPayType(PayType.WAP);
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setOutTradeNo(response.getOutTradeNo());
            out.setTradeNo(response.getTradeNo());
            out.setTotalAmount(new BigDecimal(response.getTotalAmount()));
            out.setSellerId(response.getSellerId());
            out.setMerchantOrderNo(response.getMerchantOrderNo());
            out.setForm(response.getBody());
            return out;
        } else if ("20000".equals(response.getCode())) {
            throw new Exception("服务不可用");
        } else if ("20001".equals(response.getCode())) {
            throw new Exception("授权权限不足");
        } else if ("40001".equals(response.getCode())) {
            throw new Exception("缺少必选参数");
        } else if ("40002".equals(response.getCode())) {
            throw new Exception("非法的参数");
        } else if ("40004".equals(response.getCode())) {
            throw new Exception("业务处理失败");
        } else if ("40006".equals(response.getCode())) {
            throw new Exception("权限不足");
        } else {
            throw new Exception("alipay未定义错误");
        }
    }

}
