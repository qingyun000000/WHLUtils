package cn.whl.payutils.wx;

import cn.whl.payutils.wx.dto.WeChatPayOrderInDto;
import cn.whl.payutils.alipay.dto.AliPayOutDto;
import cn.whl.payutils.wx.dto.WeChatInDto;
import cn.whl.payutils.Pay;
import cn.whl.payutils.PayOutDto;
import cn.whl.payutils.strategy.PayNotifyDo;
import cn.whl.payutils.utils.HttpUtil;
import cn.whl.payutils.wx.dto.WeChatOutDto;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信支付类
 * @author wuhailong
 */
public class WeChatPay implements Pay<WeChatInDto, WeChatOutDto>{
    
    //日志输出工具
    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatPay.class);

    @Override
    public WeChatOutDto payOrder(WeChatInDto params) {
        WeChatPayOrderInDto payOrderParams = (WeChatPayOrderInDto) params;
        LOGGER.info("进入微信下单");
        
        String url = payOrderParams.getUnifiedOrderUrl();
        LOGGER.info("微信支付url:" + url);

        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        
        // 金额
        int totalFee = WxUtil.yuanToFen(String.valueOf(payOrderParams.getTotalFee()));

        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("appid", payOrderParams.getAppId());
        parameters.put("mch_id", payOrderParams.getMchId());
        parameters.put("device_info", payOrderParams.getDeviceInfo());
        parameters.put("body", payOrderParams.getBody());
        parameters.put("nonce_str", nonceStr);
        parameters.put("openid", payOrderParams.getOpenId());
        parameters.put("out_trade_no", payOrderParams.getOutTradeNo());
        parameters.put("total_fee", String.valueOf(totalFee));
        parameters.put("spbill_create_ip", payOrderParams.getSpbillCreateIp());
        parameters.put("notify_url", payOrderParams.getNotifyUrl());
        parameters.put("trade_type", payOrderParams.getTradeType());
        LOGGER.info("支付请求parameters:" + parameters);

        try {
            String requestParams = WxUtil.generateSignedXml(parameters, payOrderParams.getKey());
            String result = HttpUtil.doPost(url, requestParams);
            
            LOGGER.info(result);

            Map<String, String> resultMap = WxUtil.xmlToMap(result);

            LOGGER.info("微信支付返回的结果:" + resultMap);
            
            return new WeChatOutDto();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    @Override
    public WeChatOutDto orderQuery(WeChatInDto params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatOutDto payNotify(WeChatInDto params, PayNotifyDo payNotifyDo) {
        
        payNotifyDo.payNotifyDo(params);
        
        return null;
    }

    @Override
    public WeChatOutDto refund(WeChatInDto params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatOutDto refundNotify(WeChatInDto params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatOutDto payByMch(WeChatInDto params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

   
    
}
