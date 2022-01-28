package cn.whl.payutils.common;

import cn.whl.payutils.alipay.AliPay;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignIn;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignNotifyIn;
import cn.whl.payutils.alipay.vo.close.AliPayCloseIn;
import cn.whl.payutils.alipay.vo.create.AliPayCreateIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayNotifyIn;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchIn;
import cn.whl.payutils.alipay.vo.query.AliPayQueryIn;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundIn;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.common.accountQuery.AccountQueryIn;
import cn.whl.payutils.common.accountQuery.AccountQueryOut;
import cn.whl.payutils.common.agreement.SignIn;
import cn.whl.payutils.common.agreement.SignNotifyIn;
import cn.whl.payutils.common.agreement.SignNotifyResult;
import cn.whl.payutils.common.agreement.SignOut;
import cn.whl.payutils.common.close.CloseNotifyIn;
import cn.whl.payutils.common.close.CloseNotifyResult;
import cn.whl.payutils.common.pay.PayNotifyResult;
import cn.whl.payutils.common.refund.RefundIn;
import cn.whl.payutils.common.refund.RefundNotifyIn;
import cn.whl.payutils.common.refund.RefundQueryOut;
import cn.whl.payutils.wx.vo.WeChatCloseIn;
import cn.whl.payutils.wx.vo.WeChatCreateIn;
import cn.whl.payutils.wx.vo.WeChatPayNotify;
import cn.whl.payutils.wx.vo.WeChatQueryIn;
import cn.whl.payutils.common.create.CreateIn;
import cn.whl.payutils.wx.WeChat;
import cn.whl.payutils.common.create.CreateOut;
import cn.whl.payutils.common.pay.PayIn;
import cn.whl.payutils.common.pay.PayNotifyIn;
import cn.whl.payutils.wx.vo.WeChatPayByMchIn;
import cn.whl.payutils.wx.vo.WeChatRefundIn;
import cn.whl.payutils.wx.vo.agreement.WeChatSignIn;
import cn.whl.payutils.wx.vo.agreement.WeChatSignNotifyIn;

/**
 * 订单工具类
 * @author wuhailong
 */
public class PayUtils {
    
    private static final Pay ALIPAY = new AliPay();

    private static final Pay WECHAT = new WeChat();
    
    /**
     * 创建订单
     * @param in
     * @return
     * @throws Exception 
     */
    public static CreateOut create(CreateIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayCreateIn createIn = (AliPayCreateIn)in;
            return ALIPAY.create(createIn);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatCreateIn createIn = (WeChatCreateIn)in;
            return WECHAT.create(createIn);
        }
        
        return null;
    }
    
    /**
     * 支付
     * @param in
     * @return
     * @throws Exception 
     */
    public static PayOut pay(PayIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayPayIn payIn = (AliPayPayIn)in;
            return ALIPAY.pay(payIn);
        }
        
        return null;
    }
    
    /**
     * 支付回调
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static PayNotifyResult payNotify(PayNotifyIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayPayNotifyIn payNotifyIn = (AliPayPayNotifyIn)in;
            return ALIPAY.payNotify(payNotifyIn);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatPayNotify payIn = (WeChatPayNotify)in;
            return WECHAT.payNotify(payIn);
        }
        
        return null;
    }
    
    /**
     * 订单支付状态查询
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static QueryOut query(QueryIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayQueryIn payIn = (AliPayQueryIn)in;
            return ALIPAY.query(payIn);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatQueryIn payIn = (WeChatQueryIn)in;
            return WECHAT.query(payIn);
        }
        
        return null;
    }
    
    /**
     * 关闭
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static CloseOut close(CloseIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayCloseIn payIn = (AliPayCloseIn)in;
            return ALIPAY.close(payIn);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatCloseIn payIn = (WeChatCloseIn)in;
            return WECHAT.close(payIn);
        }
        
        return null;
    }
    
    /**
     * 关闭回调
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static CloseNotifyResult closeNotify(CloseNotifyIn in) throws Exception{
        return null;
    }
    
    /**
     * 商户退款
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static RefundOut refund(RefundIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayRefundIn refundIn = (AliPayRefundIn)in;
            return ALIPAY.refund(refundIn);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatRefundIn refundIn = (WeChatRefundIn)in;
            return WECHAT.refund(refundIn);
        }
        
        return null;
    }
    
    /**
     * 商户退款回调
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static RefundNotifyResult refundNotify(RefundNotifyIn in) throws Exception{
        return null;
    }
    
    /**
     * 商户退款查询
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static RefundQueryOut refundQuery(RefundQueryIn in) throws Exception{
        return null;
    }
    
    /**
     * 商家支付
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static PayByMchOut payByMch(PayByMchIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayPayByMchIn payByMchIn = (AliPayPayByMchIn)in;
            return ALIPAY.payByMch(payByMchIn);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatPayByMchIn payByMchIn = (WeChatPayByMchIn)in;
            return WECHAT.payByMch(payByMchIn);
        }
        
        return null;
    }
    
    /**
     * 商家支付结果查询
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static PayByMchQueryOut payByMchQuery(PayByMchQueryIn in) throws Exception{
        return null;
    }
    
    /**
     * 账户余额查询
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static AccountQueryOut accountQuery(AccountQueryIn in) throws Exception{
        return null;
    }
    
    /**
     * 商家支付回调
     * @param in
     * @return
     * @throws java.lang.Exception
     */
    public static PayByMchNotifyResult payByMchNotify(PayByMchNotifyIn in) throws Exception{
        return null;
    }
    
    /**
     * 代扣签约
     * @param in
     * @return
     * @throws Exception
     */
    public static SignOut sign(SignIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPaySignIn payIn = (AliPaySignIn)in;
            return ALIPAY.sign(payIn);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatSignIn payIn = (WeChatSignIn)in;
            return WECHAT.sign(payIn);
        }
        return null;
    }
    
    /**
     * 代扣签约回调
     * @param in
     * @return
     * @throws Exception
     */
    public static SignNotifyResult signNotify(SignNotifyIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPaySignNotifyIn payIn = (AliPaySignNotifyIn)in;
            return ALIPAY.signNotify(payIn);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatSignNotifyIn payIn = (WeChatSignNotifyIn)in;
            return WECHAT.signNotify(payIn);
        }
        
        return null;
    }
}
