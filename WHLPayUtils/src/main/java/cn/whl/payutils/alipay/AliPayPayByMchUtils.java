package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.dto.AliPayAccountQueryInDto;
import cn.whl.payutils.alipay.dto.AliPayAccountQueryOutDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchInDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchOutDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchQueryInDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchQueryOutDto;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayFundTransUniTransferModel;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;

/**
 * 阿里支付订单退款方法
 * @author wuhailong
 */
public class AliPayPayByMchUtils {

    static AliPayPayByMchOutDto payByMch(AliPayPayByMchInDto in) {
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
        
        AliPayPayByMchOutDto out = new AliPayPayByMchOutDto();
        return out;
    }

    static AliPayPayByMchQueryOutDto query(AliPayPayByMchQueryInDto payByMchQueryParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static AliPayAccountQueryOutDto accountQuery(AliPayAccountQueryInDto accountQueryParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
