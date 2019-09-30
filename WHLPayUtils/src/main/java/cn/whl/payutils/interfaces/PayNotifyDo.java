package cn.whl.payutils.interfaces;

/**
 * 支付回调策略
 * @author wuhailong
 */
public interface PayNotifyDo{
    
    public Object payNotifyDo(PayInDto in);
}
