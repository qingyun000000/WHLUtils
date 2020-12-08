package cn.whl.payutils;

import cn.whl.payutils.alipay.AliPay;
import cn.whl.payutils.alipay.vo.close.AliPayCloseIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayIn;
import cn.whl.payutils.alipay.vo.payNotify.AliPayPayNotify;
import cn.whl.payutils.alipay.vo.query.AliPayQueryIn;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.interfaces.accountQuery.AccountQueryIn;
import cn.whl.payutils.interfaces.accountQuery.AccountQueryOut;
import cn.whl.payutils.interfaces.close.CloseIn;
import cn.whl.payutils.interfaces.close.CloseOut;
import cn.whl.payutils.interfaces.closeNotify.CloseNotifyIn;
import cn.whl.payutils.interfaces.closeNotify.CloseNotifyResult;
import cn.whl.payutils.wx.WeChat;
import cn.whl.payutils.interfaces.pay.PayIn;
import cn.whl.payutils.interfaces.pay.PayOut;
import cn.whl.payutils.interfaces.payByMch.PayByMchIn;
import cn.whl.payutils.interfaces.payByMch.PayByMchOut;
import cn.whl.payutils.interfaces.payByMchNotify.PayByMchNotifyIn;
import cn.whl.payutils.interfaces.payByMchNotify.PayByMchNotifyResult;
import cn.whl.payutils.interfaces.payByMchQuery.PayByMchQueryIn;
import cn.whl.payutils.interfaces.payByMchQuery.PayByMchQueryOut;
import cn.whl.payutils.interfaces.payNotify.PayNotifyIn;
import cn.whl.payutils.interfaces.payNotify.PayNotifyResult;
import cn.whl.payutils.interfaces.query.QueryIn;
import cn.whl.payutils.interfaces.query.QueryOut;
import cn.whl.payutils.interfaces.refund.RefundIn;
import cn.whl.payutils.interfaces.refund.RefundOut;
import cn.whl.payutils.interfaces.refundNotify.RefundNotifyIn;
import cn.whl.payutils.interfaces.refundNotify.RefundNotifyResult;
import cn.whl.payutils.interfaces.refundQuery.RefundQueryIn;
import cn.whl.payutils.interfaces.refundQuery.RefundQueryOut;
import cn.whl.payutils.wx.vo.WeChatCloseIn;
import cn.whl.payutils.wx.vo.WeChatPayIn;
import cn.whl.payutils.wx.vo.WeChatPayNotify;
import cn.whl.payutils.wx.vo.WeChatQueryIn;

/**
 * 订单工具类
 * @author wuhailong
 */
public class PayUtils {
    
    private static AliPay alipay = new AliPay();

    private static WeChat wechat = new WeChat();
    
    /**
     * 支付
     * @param in
     * @return
     * @throws Exception 
     */
    public static PayOut pay(PayIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayPayIn payParams = (AliPayPayIn)in;
            return alipay.pay(payParams);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatPayIn payParams = (WeChatPayIn)in;
            return wechat.pay(payParams);
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
            AliPayPayNotify payParams = (AliPayPayNotify)in;
            return alipay.payNotify(payParams);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatPayNotify payParams = (WeChatPayNotify)in;
            return wechat.payNotify(payParams);
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
            AliPayQueryIn payParams = (AliPayQueryIn)in;
            return alipay.query(payParams);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatQueryIn payParams = (WeChatQueryIn)in;
            return wechat.query(payParams);
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
            AliPayCloseIn payParams = (AliPayCloseIn)in;
            return alipay.close(payParams);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatCloseIn payParams = (WeChatCloseIn)in;
            return wechat.close(payParams);
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
    
    
}
