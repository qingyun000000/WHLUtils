package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryIn;
import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryOut;
import cn.whl.payutils.alipay.vo.pay.AliPayPayOut;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchIn;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchOut;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchQueryIn;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchQueryOut;
import cn.whl.payutils.enums.PayType;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransUniTransferModel;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;

/**
 * 阿里支付订单退款方法
 * @author wuhailong
 */
public class AliPayPayByMchUtils {

    static AliPayPayByMchOut payByMch(AliPayPayByMchIn in) throws AlipayApiException, Exception {
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(),in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
        
        AlipayFundTransUniTransferModel model = new AlipayFundTransUniTransferModel();
        model.setOutBizNo(in.getOutTradeNo());
        model.setTransAmount(in.getAmt().toPlainString());
        model.setProductCode(in.getProductCode());
        if(in.getBizScene() != null && !"".equals(in.getBizScene())){
            model.setBizScene(in.getBizScene());
        }
        if(in.getPayeeInfo()!= null ){
            model.setPayeeInfo(in.getPayeeInfo());
        }
        request.setBizModel(model);
        
        AlipayFundTransUniTransferResponse response = alipayClient.execute(request);
        
        System.out.println(response.isSuccess());
        System.out.println(response.getCode());
        System.out.println(response.getMsg());
        System.out.println(response.getSubMsg());
        System.out.println(response.getOutBizNo());
        System.out.println(response.getStatus());
        System.out.println(response.getBody());
        
        if (response.isSuccess()) {
            System.out.println("调用成功");
            AliPayPayByMchOut out = new AliPayPayByMchOut();
            out.setPayType(PayType.PAY);
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            return out;
        } else {
            System.out.println(response);
            throw new Exception("支付失败");
        }
    }

    static AliPayPayByMchQueryOut query(AliPayPayByMchQueryIn payByMchQueryParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static AliPayAccountQueryOut accountQuery(AliPayAccountQueryIn accountQueryParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
