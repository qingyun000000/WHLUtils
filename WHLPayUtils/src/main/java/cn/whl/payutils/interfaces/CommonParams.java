package cn.whl.payutils.interfaces;

import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;

/**
 * 非回调Dto封装基础接口
 * @author wuhailong
 */
public interface CommonParams {
    
    public Platform getPlatform();

    public void setPlatform(Platform platform);

    public PayType getPayType();

    public void setPayType(PayType payType);
}
