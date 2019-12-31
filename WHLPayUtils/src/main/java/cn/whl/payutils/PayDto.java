package cn.whl.payutils;

import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;

/**
 * 非回调Dto封装基础接口
 * @author wuhailong
 */
public interface PayDto {
    
    public Platform getPlatform();

    public void setPlatform(Platform platform);

    public PayType getPayType();

    public void setPayType(PayType payType);
}
