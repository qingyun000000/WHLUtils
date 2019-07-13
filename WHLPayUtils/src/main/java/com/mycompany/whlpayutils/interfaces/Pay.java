package com.mycompany.whlpayutils.interfaces;

/**
 * 支付接口
 * @author Administrator
 * @param <T>
 */
public interface Pay <T>{
    
    public Object payOrder(T params);
    
    public Object orderQuery(T params);
    
    public Object payNotify(T params, PayNotifyDo payNotifyDo);
    
    public Object refund(T params);
    
    public Object refundNotify(T params);
    
    public Object payByMch(T params);
    
}
