package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.vo.pay.AliPayPayIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayOut;
import cn.whl.payutils.enums.PayType;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;

/**
 * 阿里支付支付方法工具
 *
 * @author wuhailong
 */
public class AliPayPayUtils {

    public static AliPayPayOut pay(AliPayPayIn in) throws AlipayApiException, Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(), in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        request.setNotifyUrl(in.getNotifyUrl());
        request.setReturnUrl(in.getReturnUrl());
        
        AlipayTradePayModel model = new AlipayTradePayModel();
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
        model.setAgreementParams(in.getAgreementParams());
        if (in.getExtendParams() != null) {
            model.setExtendParams(in.getExtendParams());
        }
        if (in.getMerchantOrderNo() != null && !"".equals(in.getMerchantOrderNo())) {
            model.setMerchantOrderNo(in.getMerchantOrderNo());
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
        

        AlipayTradePayResponse response = alipayClient.execute(request);
        
        System.out.println(response.isSuccess());
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        System.out.println(response.getSubMsg());
        System.out.println(response.getOutTradeNo());
        System.out.println(response.getTradeNo());
        System.out.println(response.getTotalAmount());
        //System.out.println(response.getSellerId());
        //System.out.println(response.getMerchantOrderNo());
        System.out.println(response.getBody());
        
        if (response.isSuccess()) {
            System.out.println("调用成功");
            AliPayPayOut out = new AliPayPayOut();
            out.setPayType(PayType.PAY);
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setOutTradeNo(response.getOutTradeNo());
            out.setResultJson(response.getBody());
            return out;
        } else {
            System.out.println(response);
            throw new Exception("支付失败");
        }
    }


}
