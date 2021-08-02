package cn.whl.payutils.common;

import cn.whl.payutils.alipay.AliPay;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignIn;
import cn.whl.payutils.alipay.vo.close.AliPayCloseIn;
import cn.whl.payutils.alipay.vo.create.AliPayCreateIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayNotifyIn;
import cn.whl.payutils.alipay.vo.query.AliPayQueryIn;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.common.accountQuery.AccountQueryIn;
import cn.whl.payutils.common.accountQuery.AccountQueryOut;
import cn.whl.payutils.common.agreement.SignIn;
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
import cn.whl.payutils.wx.vo.agreement.WeChatSignIn;

/**
 * 订单工具类
 * @author wuhailong
 */
public class PayUtils {
    
    private static final Pay alipay = new AliPay();

    private static final Pay wechat = new WeChat();
    
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
        }
        
        return null;
    }
    
    /**
     * 创建订单
     * @param in
     * @return
     * @throws Exception 
     */
    public static CreateOut create(CreateIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPayCreateIn createParams = (AliPayCreateIn)in;
            return alipay.create(createParams);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatCreateIn createParams = (WeChatCreateIn)in;
            return wechat.create(createParams);
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
            AliPayPayNotifyIn payParams = (AliPayPayNotifyIn)in;
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
    
    public static SignOut sign(SignIn in) throws Exception{
        if(in.getPlatform() == Platform.ALIPAY){
            AliPaySignIn payParams = (AliPaySignIn)in;
            return alipay.sign(payParams);
        }else if(in.getPlatform() == Platform.WECHAT){
            WeChatSignIn payParams = (WeChatSignIn)in;
            return wechat.sign(payParams);
        }
        return null;
    }
}
