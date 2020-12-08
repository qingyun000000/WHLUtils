package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryIn;
import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryOut;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchIn;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchOut;
import cn.whl.payutils.alipay.vo.payByMchQuery.AliPayPayByMchQueryIn;
import cn.whl.payutils.alipay.vo.payByMchQuery.AliPayPayByMchQueryOut;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransUniTransferModel;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;

/**
 * 阿里支付订单退款方法
 * @author wuhailong
 */
public class AliPayPayByMchUtils {

    static AliPayPayByMchOut payByMch(AliPayPayByMchIn in) {
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
        
        AliPayPayByMchOut out = new AliPayPayByMchOut();
        return out;
    }

    static AliPayPayByMchQueryOut query(AliPayPayByMchQueryIn payByMchQueryParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static AliPayAccountQueryOut accountQuery(AliPayAccountQueryIn accountQueryParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
