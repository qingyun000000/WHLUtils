package cn.whl.payutils.common;

import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;

/**
 * 非回调封装基础接口
 * @author wuhailong
 */
public interface CommonParams {
    
    public Platform getPlatform();

    public PayType getPayType();

    public void setPayType(PayType payType);
    
    public boolean isWaitNotify();
    
    public void setWaitNotify(boolean waitNotify);
}
