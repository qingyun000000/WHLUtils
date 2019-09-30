package cn.whl.payutils.interfaces;

/**
 * 支付接口
 * @author wuhailong
 * @param <T>
 * @param <K>
 */
public interface Pay <T extends PayInDto, K extends PayOutDto>{
    
    /**
     * 支付下单
     * @param params
     * @return
     */
    public K payOrder(T params);
    
    /**
     * 订单支付状态查询
     * @param params
     * @return
     */
    public K orderQuery(T params);
    
    /**
     * 支付回调
     * @param params
     * @param payNotifyDo
     * @return
     */
    public K payNotify(T params, PayNotifyDo payNotifyDo);
    
    /**
     * 商户退款
     * @param params
     * @return
     */
    public K refund(T params);
    
    /**
     * 商户退款回调
     * @param params
     * @return
     */
    public K refundNotify(T params);
    
    /**
     * 商家支付
     * @param params
     * @return
     */
    public K payByMch(T params);
    
}
