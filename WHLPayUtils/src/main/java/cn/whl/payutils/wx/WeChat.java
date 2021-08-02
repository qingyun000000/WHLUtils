package cn.whl.payutils.wx;

import cn.whl.payutils.alipay.vo.agreement.AliPaySignIn;
import cn.whl.payutils.common.Pay;
import cn.whl.payutils.utils.HttpUtil;
import cn.whl.payutils.wx.vo.WeChatAccountQueryIn;
import cn.whl.payutils.wx.vo.WeChatAccountQueryOut;
import cn.whl.payutils.wx.vo.WeChatCloseIn;
import cn.whl.payutils.wx.vo.WeChatCloseNotify;
import cn.whl.payutils.wx.vo.WeChatCloseNotifyResult;
import cn.whl.payutils.wx.vo.WeChatCloseOut;
import cn.whl.payutils.wx.vo.WeChatPayByMchIn;
import cn.whl.payutils.wx.vo.WeChatPayByMchNotify;
import cn.whl.payutils.wx.vo.WeChatPayByMchNotifyResult;
import cn.whl.payutils.wx.vo.WeChatPayByMchOut;
import cn.whl.payutils.wx.vo.WeChatPayByMchQueryIn;
import cn.whl.payutils.wx.vo.WeChatPayByMchQueryOut;
import cn.whl.payutils.wx.vo.WeChatCreateIn;
import cn.whl.payutils.wx.vo.WeChatPayNotify;
import cn.whl.payutils.wx.vo.WeChatPayNotifyResult;
import cn.whl.payutils.wx.vo.WeChatCrateOut;
import cn.whl.payutils.wx.vo.WeChatPayIn;
import cn.whl.payutils.wx.vo.WeChatPayOut;
import cn.whl.payutils.wx.vo.WeChatQueryIn;
import cn.whl.payutils.wx.vo.WeChatQueryOut;
import cn.whl.payutils.wx.vo.WeChatRefundIn;
import cn.whl.payutils.wx.vo.WeChatRefundNotify;
import cn.whl.payutils.wx.vo.WeChatRefundNotifyResult;
import cn.whl.payutils.wx.vo.WeChatRefundOut;
import cn.whl.payutils.wx.vo.WeChatRefundQueryIn;
import cn.whl.payutils.wx.vo.WeChatRefundQueryOut;
import cn.whl.payutils.wx.vo.agreement.WeChatSignIn;
import cn.whl.payutils.wx.vo.agreement.WeChatSignNotifyIn;
import cn.whl.payutils.wx.vo.agreement.WeChatSignNotifyResult;
import cn.whl.payutils.wx.vo.agreement.WeChatSignOut;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * 微信支付类
 * @author wuhailong
 */
public class WeChat implements Pay<
        WeChatCreateIn, WeChatCrateOut,
        WeChatPayIn, WeChatPayOut,
        WeChatPayNotify, WeChatPayNotifyResult,
        WeChatQueryIn, WeChatQueryOut,
        WeChatCloseIn, WeChatCloseOut,
        WeChatCloseNotify, WeChatCloseNotifyResult,
        WeChatRefundIn, WeChatRefundOut,
        WeChatRefundNotify, WeChatRefundNotifyResult,
        WeChatRefundQueryIn, WeChatRefundQueryOut,
        WeChatPayByMchIn, WeChatPayByMchOut,
        WeChatPayByMchQueryIn, WeChatPayByMchQueryOut,
        WeChatAccountQueryIn, WeChatAccountQueryOut,
        WeChatPayByMchNotify, WeChatPayByMchNotifyResult,
        WeChatSignIn, WeChatSignOut,
        WeChatSignNotifyIn, WeChatSignNotifyResult> {
    
    @Override
    public WeChatCrateOut create(WeChatCreateIn payParams) {
       
        String url = payParams.getUnifiedOrderUrl();

        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        
        // 金额
        int totalFee = WxUtil.yuanToFen(String.valueOf(payParams.getTotalFee()));

        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("appid", payParams.getAppId());
        parameters.put("mch_id", payParams.getMchId());
        parameters.put("device_info", payParams.getDeviceInfo());
        parameters.put("body", payParams.getBody());
        parameters.put("nonce_str", nonceStr);
        parameters.put("openid", payParams.getOpenId());
        parameters.put("out_trade_no", payParams.getOutTradeNo());
        parameters.put("total_fee", String.valueOf(totalFee));
        parameters.put("spbill_create_ip", payParams.getSpbillCreateIp());
        parameters.put("notify_url", payParams.getNotifyUrl());
        parameters.put("trade_type", payParams.getTradeType());

        try {
            String requestParams = WxUtil.generateSignedXml(parameters, payParams.getKey());
            String result = HttpUtil.doPost(url, requestParams);
            

            Map<String, String> resultMap = WxUtil.xmlToMap(result);

            
            return new WeChatCrateOut();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    @Override
    public WeChatPayOut pay(WeChatPayIn payParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public WeChatPayNotifyResult payNotify(WeChatPayNotify payNotifyParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatQueryOut query(WeChatQueryIn oderParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatCloseOut close(WeChatCloseIn closeParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatCloseNotifyResult closeNotify(WeChatCloseNotify closeNotifyParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatRefundOut refund(WeChatRefundIn refundParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatRefundNotifyResult refundNotify(WeChatRefundNotify refundParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatRefundQueryOut refundQuery(WeChatRefundQueryIn refundQueryParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatPayByMchOut payByMch(WeChatPayByMchIn payByMchParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatPayByMchQueryOut payByMchQuery(WeChatPayByMchQueryIn payByMchQueryParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatAccountQueryOut accountQuery(WeChatAccountQueryIn accountQueryParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatPayByMchNotifyResult payByMchNotify(WeChatPayByMchNotify payByMchNotifyParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatSignOut sign(WeChatSignIn signParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatSignNotifyResult signNotify(WeChatSignNotifyIn signParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

   
    
}
