package cn.whl.payutils;

import cn.whl.payutils.interfaces.accountQuery.AccountQueryIn;
import cn.whl.payutils.interfaces.accountQuery.AccountQueryOut;
import cn.whl.payutils.interfaces.close.CloseIn;
import cn.whl.payutils.interfaces.close.CloseOut;
import cn.whl.payutils.interfaces.closeNotify.CloseNotifyIn;
import cn.whl.payutils.interfaces.closeNotify.CloseNotifyResult;
import cn.whl.payutils.interfaces.payByMch.PayByMchIn;
import cn.whl.payutils.interfaces.payByMch.PayByMchOut;
import cn.whl.payutils.interfaces.payByMchNotify.PayByMchNotifyIn;
import cn.whl.payutils.interfaces.payByMchNotify.PayByMchNotifyResult;
import cn.whl.payutils.interfaces.payByMchQuery.PayByMchQueryIn;
import cn.whl.payutils.interfaces.payByMchQuery.PayByMchQueryOut;
import cn.whl.payutils.interfaces.query.QueryIn;
import cn.whl.payutils.interfaces.query.QueryOut;
import cn.whl.payutils.interfaces.payNotify.PayNotifyIn;
import cn.whl.payutils.interfaces.payNotify.PayNotifyResult;
import cn.whl.payutils.interfaces.refund.RefundIn;
import cn.whl.payutils.interfaces.refund.RefundOut;
import cn.whl.payutils.interfaces.refundNotify.RefundNotifyIn;
import cn.whl.payutils.interfaces.refundNotify.RefundNotifyResult;
import cn.whl.payutils.interfaces.refundQuery.RefundQueryIn;
import cn.whl.payutils.interfaces.refundQuery.RefundQueryOut;
import cn.whl.payutils.interfaces.create.CreateIn;
import cn.whl.payutils.interfaces.create.CreateOut;
import cn.whl.payutils.interfaces.pay.PayIn;
import cn.whl.payutils.interfaces.pay.PayOut;

/**
 * 支付接口
 * @author wuhailong
 * @param <T0>
 * @param <K0>
 * @param <T1>
 * @param <K1>
 * @param <T2>
 * @param <K2>
 * @param <T3>
 * @param <K3>
 * @param <T4>
 * @param <K4>
 * @param <T5>
 * @param <K5>
 * @param <T6>
 * @param <K6>
 * @param <T7>
 * @param <K7>
 * @param <T8>
 * @param <K8>
 * @param <T9>
 * @param <K9>
 * @param <T10>
 * @param <K10>
 * @param <T11>
 * @param <K11>
 * @param <T12>
 * @param <K12>
 */
public interface Pay <T0 extends PayIn, K0 extends PayOut,
                      T1 extends CreateIn, K1 extends CreateOut,
                      T2 extends PayNotifyIn, K2 extends PayNotifyResult,
                      T3 extends QueryIn, K3 extends QueryOut,
                      T4 extends CloseIn, K4 extends CloseOut,
                      T5 extends CloseNotifyIn, K5 extends CloseNotifyResult,
                      T6 extends RefundIn, K6 extends RefundOut,
                      T7 extends RefundNotifyIn, K7 extends RefundNotifyResult,
                      T8 extends RefundQueryIn, K8 extends RefundQueryOut,
                      T9 extends PayByMchIn, K9 extends PayByMchOut,
                      T10 extends PayByMchQueryIn, K10 extends PayByMchQueryOut,
                      T11 extends AccountQueryIn, K11 extends AccountQueryOut,
                      T12 extends PayByMchNotifyIn, K12 extends PayByMchNotifyResult>{
    
    /**
     * 支付下单
     * @param payParams
     * @return
     * @throws java.lang.Exception
     */
    public K0 pay(T0 payParams) throws Exception;
    
    /**
     * 下单
     * @param createParams
     * @return
     * @throws java.lang.Exception
     */
    public K1 create(T1 createParams) throws Exception;
    
    /**
     * 支付回调
     * @param payNotifyParams
     * @return
     * @throws java.lang.Exception
     */
    public K2 payNotify(T2 payNotifyParams) throws Exception;
    
    /**
     * 订单支付状态查询
     * @param oderParams
     * @return
     * @throws java.lang.Exception
     */
    public K3 query(T3 oderParams) throws Exception;
    
    /**
     * 关闭
     * @param closeParams
     * @return
     * @throws java.lang.Exception
     */
    public K4 close(T4 closeParams) throws Exception;
    
    /**
     * 关闭回调
     * @param closeNotifyParams
     * @return
     * @throws java.lang.Exception
     */
    public K5 closeNotify(T5 closeNotifyParams) throws Exception;
    
    /**
     * 商户退款
     * @param refundParams
     * @return
     * @throws java.lang.Exception
     */
    public K6 refund(T6 refundParams) throws Exception;
    
    /**
     * 商户退款回调
     * @param refundNotifyParams
     * @return
     * @throws java.lang.Exception
     */
    public K7 refundNotify(T7 refundNotifyParams) throws Exception;
    
    /**
     * 商户退款查询
     * @param refundQueryParams
     * @return
     * @throws java.lang.Exception
     */
    public K8 refundQuery(T8 refundQueryParams) throws Exception;
    
    /**
     * 商家支付
     * @param payByMchParams
     * @return
     * @throws java.lang.Exception
     */
    public K9 payByMch(T9 payByMchParams) throws Exception;
    
    /**
     * 商家支付结果查询
     * @param payByMchQueryParams
     * @return
     * @throws java.lang.Exception
     */
    public K10 payByMchQuery(T10 payByMchQueryParams) throws Exception;
    
    /**
     * 账户余额查询
     * @param accountQueryParams
     * @return
     * @throws java.lang.Exception
     */
    public K11 accountQuery(T11 accountQueryParams) throws Exception;
    
    /**
     * 商家支付回调
     * @param payByMchNotifyParams
     * @return
     * @throws java.lang.Exception
     */
    public K12 payByMchNotify(T12 payByMchNotifyParams) throws Exception;
    
}
