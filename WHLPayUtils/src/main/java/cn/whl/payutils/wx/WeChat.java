package cn.whl.payutils.wx;

import cn.whl.payutils.Pay;
import cn.whl.payutils.utils.HttpUtil;
import cn.whl.payutils.wx.dto.WeChatAccountQueryInDto;
import cn.whl.payutils.wx.dto.WeChatAccountQueryOutDto;
import cn.whl.payutils.wx.dto.WeChatCloseInDto;
import cn.whl.payutils.wx.dto.WeChatCloseNotifyDto;
import cn.whl.payutils.wx.dto.WeChatCloseNotifyResultDto;
import cn.whl.payutils.wx.dto.WeChatCloseOutDto;
import cn.whl.payutils.wx.dto.WeChatPayByMchInDto;
import cn.whl.payutils.wx.dto.WeChatPayByMchNotifyDto;
import cn.whl.payutils.wx.dto.WeChatPayByMchNotifyResultDto;
import cn.whl.payutils.wx.dto.WeChatPayByMchOutDto;
import cn.whl.payutils.wx.dto.WeChatPayByMchQueryInDto;
import cn.whl.payutils.wx.dto.WeChatPayByMchQueryOutDto;
import cn.whl.payutils.wx.dto.WeChatPayInDto;
import cn.whl.payutils.wx.dto.WeChatPayNotifyDto;
import cn.whl.payutils.wx.dto.WeChatPayNotifyResultDto;
import cn.whl.payutils.wx.dto.WeChatPayOutDto;
import cn.whl.payutils.wx.dto.WeChatQueryInDto;
import cn.whl.payutils.wx.dto.WeChatQueryOutDto;
import cn.whl.payutils.wx.dto.WeChatRefundInDto;
import cn.whl.payutils.wx.dto.WeChatRefundNotifyDto;
import cn.whl.payutils.wx.dto.WeChatRefundNotifyResultDto;
import cn.whl.payutils.wx.dto.WeChatRefundOutDto;
import cn.whl.payutils.wx.dto.WeChatRefundQueryInDto;
import cn.whl.payutils.wx.dto.WeChatRefundQueryOutDto;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

/**
 * 微信支付类
 * @author wuhailong
 */
public class WeChat implements Pay<WeChatPayInDto, WeChatPayOutDto,
        WeChatPayNotifyDto, WeChatPayNotifyResultDto,
        WeChatQueryInDto, WeChatQueryOutDto,
        WeChatCloseInDto, WeChatCloseOutDto,
        WeChatCloseNotifyDto, WeChatCloseNotifyResultDto,
        WeChatRefundInDto, WeChatRefundOutDto,
        WeChatRefundNotifyDto, WeChatRefundNotifyResultDto,
        WeChatRefundQueryInDto, WeChatRefundQueryOutDto,
        WeChatPayByMchInDto, WeChatPayByMchOutDto,
        WeChatPayByMchQueryInDto, WeChatPayByMchQueryOutDto,
        WeChatAccountQueryInDto, WeChatAccountQueryOutDto,
        WeChatPayByMchNotifyDto, WeChatPayByMchNotifyResultDto> {
    
    @Override
    public WeChatPayOutDto pay(WeChatPayInDto payParams) {
       
        String url = payParams.getUnifiedOrderUrl();

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

        try {
            String requestParams = WxUtil.generateSignedXml(parameters, payParams.getKey());
            String result = HttpUtil.doPost(url, requestParams);
            

            Map<String, String> resultMap = WxUtil.xmlToMap(result);

            
            return new WeChatPayOutDto();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public WeChatPayNotifyResultDto payNotify(WeChatPayNotifyDto payNotifyParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatQueryOutDto query(WeChatQueryInDto oderParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatCloseOutDto close(WeChatCloseInDto closeParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatCloseNotifyResultDto closeNotify(WeChatCloseNotifyDto closeNotifyParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatRefundOutDto refund(WeChatRefundInDto refundParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatRefundNotifyResultDto refundNotify(WeChatRefundNotifyDto refundParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatRefundQueryOutDto refundQuery(WeChatRefundQueryInDto refundQueryParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatPayByMchOutDto payByMch(WeChatPayByMchInDto payByMchParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatPayByMchQueryOutDto payByMchQuery(WeChatPayByMchQueryInDto payByMchQueryParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatAccountQueryOutDto accountQuery(WeChatAccountQueryInDto accountQueryParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WeChatPayByMchNotifyResultDto payByMchNotify(WeChatPayByMchNotifyDto payByMchNotifyParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

   
    
}
