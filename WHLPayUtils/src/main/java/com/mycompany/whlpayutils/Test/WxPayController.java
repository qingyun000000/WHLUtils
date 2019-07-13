package com.mycompany.whlpayutils.Test;

import com.mycompany.whlpayutils.interfaces.Pay;
import com.mycompany.whlpayutils.interfaces.PayNotifyDo;
import com.mycompany.whlpayutils.interfaces.PayNotifyDoParams;
import com.mycompany.whlpayutils.wx.WeChatParams;
import com.mycompany.whlpayutils.wx.WeChatPay;
import com.mycompany.whlpayutils.wx.WeChatPayNotifyDoParams;
import com.mycompany.whlpayutils.wx.WeChatPayNotifyParams;
import com.mycompany.whlpayutils.wx.WeChatPayOrderParams;

/**
 *
 * @author Administrator
 */
public class WxPayController {
    
    static Pay<WeChatParams> pay = new WeChatPay();
    
    public static void main(String[] args){
        payNotify();
    }

    private static void payOrder() {
        WeChatPayOrderParams weChatParams = new WeChatPayOrderParams();
        weChatParams.setAppId("wx11b764518a486e6b");
        weChatParams.setBody("sde");
        weChatParams.setDeviceInfo("weew");
        weChatParams.setKey("tangchaokejitangchaokejitangchao");
        weChatParams.setMchId("1469855002");
        weChatParams.setNotifyUrl("https://192.168.0.123/pay/wx/payNotify");
        weChatParams.setOpenId("fas");
        weChatParams.setOutTradeNo("dfaer");
        weChatParams.setSpbillCreateIp("133.135.183.132");
        weChatParams.setTotalFee("2.3");
        weChatParams.setTradeType("JSAPI");
        weChatParams.setUnifiedOrderUrl("https://api.mch.weixin.qq.com/pay/unifiedorder");
        
        Object payOrder = pay.payOrder(weChatParams);
        System.out.println(payOrder);
    }
    
    private static void payNotify() {
        WeChatPayNotifyParams weChatParams = new WeChatPayNotifyParams();
        weChatParams.setAppId("wx11b764518a486e6b");
        weChatParams.setKey("tangchaokejitangchaokejitangchao");
        weChatParams.setMchId("1469855002");
        
        Object payOrder = pay.payNotify(weChatParams, (PayNotifyDo<WeChatPayNotifyDoParams>) (WeChatPayNotifyDoParams t) -> {
            System.out.println("订单状态修改");
            return null;
        });
        System.out.println(payOrder);
    }
    
}
