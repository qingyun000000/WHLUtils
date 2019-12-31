package cn.whl.payutils;

/**
 * 支付接口
 * @author wuhailong
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
 */
public interface Pay <T1 extends PayInDto, K1 extends PayOutDto,
                      T2 extends NotifyDto, K2 extends NotifyResultDto,
                      T3 extends PayInDto, K3 extends PayOutDto,
                      T4 extends PayInDto, K4 extends PayOutDto,
                      T5 extends NotifyDto, K5 extends NotifyResultDto,
                      T6 extends PayInDto, K6 extends PayOutDto,
                      T7 extends NotifyDto, K7 extends NotifyResultDto,
                      T8 extends PayInDto, K8 extends PayOutDto,
                      T9 extends PayInDto, K9 extends PayOutDto>{
    
    /**
     * 支付下单
     * @param payParams
     * @return
     * @throws java.lang.Exception
     */
    public K1 pay(T1 payParams) throws Exception;
    
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
     * @param refundParams
     * @return
     * @throws java.lang.Exception
     */
    public K7 refundNotify(T7 refundParams) throws Exception;
    
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
    
    
    
    
}
