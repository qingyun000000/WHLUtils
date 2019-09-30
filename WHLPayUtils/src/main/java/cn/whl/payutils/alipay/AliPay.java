package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.dto.AliPayPayOrderInDto;
import cn.whl.payutils.alipay.dto.AliPayInDto;
import cn.whl.payutils.alipay.dto.AliPayOutDto;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import cn.whl.payutils.interfaces.Pay;
import cn.whl.payutils.interfaces.PayNotifyDo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 阿里支付
 * @author wuhailong
 */
public class AliPay implements Pay<AliPayInDto, AliPayOutDto>{

    @Override
    public AliPayOutDto payOrder(AliPayInDto params) {
        try {
            AliPayPayOrderInDto payOrderParams = (AliPayPayOrderInDto) params;
            AlipayClient alipayClient = new DefaultAlipayClient(payOrderParams.getServerUrl(),payOrderParams.getAppId(), payOrderParams.getPrivateKey(), payOrderParams.getFormat(), payOrderParams.getCharSet(), payOrderParams.getAlipayPublicKey(), payOrderParams.getSignType());
            AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
            request.setNotifyUrl(payOrderParams.getNotifyUrl());
            String bizContent = "";
            request.setBizContent(bizContent);
            AlipayTradeCreateResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                                                     
            }else{
                
            }
        } catch (AlipayApiException ex) {
            Logger.getLogger(AliPay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public AliPayOutDto orderQuery(AliPayInDto params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AliPayOutDto payNotify(AliPayInDto params, PayNotifyDo payNotifyDo) {
        
        payNotifyDo.payNotifyDo(params);
        
        return null;
    }

    @Override
    public AliPayOutDto refund(AliPayInDto params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AliPayOutDto refundNotify(AliPayInDto params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AliPayOutDto payByMch(AliPayInDto params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
