package cn.whl.payutils.strategy;

import cn.whl.payutils.PayInDto;

/**
 * 支付回调策略
 * @author wuhailong
 */
public interface PayNotifyDo{
    
    public Object payNotifyDo(PayInDto in);
}
