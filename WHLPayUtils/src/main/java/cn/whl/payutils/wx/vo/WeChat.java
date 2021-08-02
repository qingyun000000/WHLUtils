package cn.whl.payutils.wx.vo;

import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.enums.Platform;
import cn.whl.payutils.common.CommonParams;

/**
 * 阿里支付
 * @author wuhailong
 */
public class WeChat implements CommonParams{
    //接口部分
    private PayType payType;
    
    private boolean waitNotify = false;

    @Override
    public Platform getPlatform() {
        return Platform.WECHAT;
    }

    @Override
    public PayType getPayType() {
        return payType;
    }

    @Override
    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    @Override
    public boolean isWaitNotify() {
        return waitNotify;
    }

    @Override
    public void setWaitNotify(boolean waitNotify) {
        this.waitNotify = waitNotify;
    }
    
}
