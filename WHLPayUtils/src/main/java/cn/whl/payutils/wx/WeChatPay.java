package cn.whl.payutils.wx;

import cn.whl.payutils.alipay.dto.AliPayOutDto;
import cn.whl.payutils.wx.dto.WeChatInDto;
import cn.whl.payutils.Pay;
import cn.whl.payutils.PayOutDto;
import cn.whl.payutils.utils.HttpUtil;
import cn.whl.payutils.wx.dto.WeChatOutDto;
import cn.whl.payutils.wx.dto.WeChatPayInDto;
import cn.whl.payutils.wx.dto.WeChatPayOutDto;
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
public class WeChatPay //implements Pay<WeChatPayInDto, WeChatPayOutDto>{
{
    
    //日志输出工具
    private static final Logger LOGGER = LoggerFactory.getLogger(WeChatPay.class);

    public WeChatPayOutDto pay(WeChatPayInDto payParams) {
        LOGGER.info("进入微信下单");
        
        String url = payParams.getUnifiedOrderUrl();
        LOGGER.info("微信支付url:" + url);

        String nonceStr = UUID.randomUUID().toString().replace("-", "");
        
        // 金额
        int totalFee = WxUtil.yuanToFen(String.valueOf(payParams.getTotalFee()));

        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("appid", payParams.getAppId());
        parameters.put("mch_id", payParams.getMchId());
        parameters.put("device_info", payParams.getDeviceInfo());
        parameters.put("body", payParams.getBody());
        parameters.put("nonce_str", nonceStr);
        parameters.put("openid", payParams.getOpenId());
        parameters.put("out_trade_no", payParams.getOutTradeNo());
        parameters.put("total_fee", String.valueOf(totalFee));
        parameters.put("spbill_create_ip", payParams.getSpbillCreateIp());
        parameters.put("notify_url", payParams.getNotifyUrl());
        parameters.put("trade_type", payParams.getTradeType());
        LOGGER.info("支付请求parameters:" + parameters);

        try {
            String requestParams = WxUtil.generateSignedXml(parameters, payParams.getKey());
            String result = HttpUtil.doPost(url, requestParams);
            
            LOGGER.info(result);

            Map<String, String> resultMap = WxUtil.xmlToMap(result);

            LOGGER.info("微信支付返回的结果:" + resultMap);
            
            return new WeChatPayOutDto();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    

   
    
}
