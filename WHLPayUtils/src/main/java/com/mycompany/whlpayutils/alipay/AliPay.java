/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.whlpayutils.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.mycompany.whlpayutils.interfaces.Pay;
import com.mycompany.whlpayutils.interfaces.PayNotifyDo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class AliPay implements Pay<AliPayParams>{

    @Override
    public Object payOrder(AliPayParams params) {
        try {
            AliPayPayOrderParams payOrderParams = (AliPayPayOrderParams) params;
            AlipayClient alipayClient = new DefaultAlipayClient(payOrderParams.getServerUrl(),payOrderParams.getAppId(), payOrderParams.getPrivateKey(), payOrderParams.getFormat(), payOrderParams.getCharSet(), payOrderParams.getAlipayPublicKey(), payOrderParams.getSignType());
            AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
            request.setNotifyUrl(payOrderParams.getNotifyUrl());
            String bizContent = "";
            request.setBizContent(bizContent);
            AlipayTradeCreateResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                return response;
            }else{
                
            }
        } catch (AlipayApiException ex) {
            Logger.getLogger(AliPay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public Object orderQuery(AliPayParams params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object payNotify(AliPayParams params, PayNotifyDo payNotifyDo) {
        
        AliPayPayNotifyDoParams aliPayPayNotifyDoParams = new AliPayPayNotifyDoParams();
        payNotifyDo.payNotifyDo(aliPayPayNotifyDoParams);
        
        return null;
    }

    @Override
    public Object refund(AliPayParams params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object refundNotify(AliPayParams params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object payByMch(AliPayParams params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
