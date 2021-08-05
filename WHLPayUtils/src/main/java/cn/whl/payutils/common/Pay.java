package cn.whl.payutils.common;

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
import cn.whl.payutils.common.create.CreateIn;
import cn.whl.payutils.common.create.CreateOut;
import cn.whl.payutils.common.pay.PayIn;
import cn.whl.payutils.common.pay.PayNotifyIn;

/**
 * 支付接口
 * @author wuhailong
 * @param <T_Create>
 * @param <K_Create>
 * @param <T_Pay>
 * @param <K_Pay>
 * @param <T_PayN>
 * @param <K_PayN>
 * @param <T_Query>
 * @param <K_Query>
 * @param <T_Close>
 * @param <K_Close>
 * @param <T_CloseN>
 * @param <K_CloseN>
 */
public interface Pay <
                    //创建
                    T_Create extends CreateIn, K_Create extends CreateOut,
                    //支付
                    T_Pay extends PayIn, K_Pay extends PayOut,
                    T_PayN extends PayNotifyIn, K_PayN extends PayNotifyResult,
                    //查询
                    T_Query extends QueryIn, K_Query extends QueryOut,
                    //关闭
                    T_Close extends CloseIn, K_Close extends CloseOut,
                    T_CloseN extends CloseNotifyIn, K_CloseN extends CloseNotifyResult,
                    //退款
                    T6 extends RefundIn, K6 extends RefundOut,
                    T7 extends RefundNotifyIn, K7 extends RefundNotifyResult,
                    T8 extends RefundQueryIn, K8 extends RefundQueryOut,
                    //商户支付
                    T9 extends PayByMchIn, K9 extends PayByMchOut,
                    T10 extends PayByMchQueryIn, K10 extends PayByMchQueryOut,
                    T11 extends AccountQueryIn, K11 extends AccountQueryOut,
                    T12 extends PayByMchNotifyIn, K12 extends PayByMchNotifyResult,
                    //签约
                    T13 extends SignIn, K13 extends SignOut,
                    T_SingN extends SignNotifyIn, K_SignN extends SignNotifyResult
                    >{
    
    /**
     * 下单
     * @param createIn
     * @return
     * @throws java.lang.Exception
     */
    public K_Create create(T_Create createIn) throws Exception;
    
    /**
     * 支付
     * @param createIn
     * @return
     * @throws java.lang.Exception
     */
    public K_Pay pay(T_Pay payIn) throws Exception;
    
    /**
     * 支付回调
     * @param payNotifyIn
     * @return
     * @throws java.lang.Exception
     */
    public K_PayN payNotify(T_PayN payNotifyIn) throws Exception;
    
    /**
     * 订单支付状态查询
     * @param oderIn
     * @return
     * @throws java.lang.Exception
     */
    public K_Query query(T_Query oderIn) throws Exception;
    
    /**
     * 关闭
     * @param closeIn
     * @return
     * @throws java.lang.Exception
     */
    public K_Close close(T_Close closeIn) throws Exception;
    
    /**
     * 关闭回调
     * @param closeNotifyIn
     * @return
     * @throws java.lang.Exception
     */
    public K_CloseN closeNotify(T_CloseN closeNotifyIn) throws Exception;
    
    /**
     * 商户退款
     * @param refundIn
     * @return
     * @throws java.lang.Exception
     */
    public K6 refund(T6 refundIn) throws Exception;
    
    /**
     * 商户退款回调
     * @param refundNotifyIn
     * @return
     * @throws java.lang.Exception
     */
    public K7 refundNotify(T7 refundNotifyIn) throws Exception;
    
    /**
     * 商户退款查询
     * @param refundQueryIn
     * @return
     * @throws java.lang.Exception
     */
    public K8 refundQuery(T8 refundQueryIn) throws Exception;
    
    /**
     * 商家支付
     * @param payByMchIn
     * @return
     * @throws java.lang.Exception
     */
    public K9 payByMch(T9 payByMchIn) throws Exception;
    
    /**
     * 商家支付结果查询
     * @param payByMchQueryIn
     * @return
     * @throws java.lang.Exception
     */
    public K10 payByMchQuery(T10 payByMchQueryIn) throws Exception;
    
    /**
     * 账户余额查询
     * @param accountQueryIn
     * @return
     * @throws java.lang.Exception
     */
    public K11 accountQuery(T11 accountQueryIn) throws Exception;
    
    /**
     * 商家支付回调
     * @param payByMchNotifyIn
     * @return
     * @throws java.lang.Exception
     */
    public K12 payByMchNotify(T12 payByMchNotifyIn) throws Exception;
    
    /**
     * 签约
     * @param signIn
     * @return
     * @throws java.lang.Exception
     */
    public K13 sign(T13 signIn) throws Exception;
    
    /**
     * 签约回调
     * @param signIn
     * @return
     * @throws Exception
     */
    public K_SignN signNotify(T_SingN signNotifyIn) throws Exception;
    
}
