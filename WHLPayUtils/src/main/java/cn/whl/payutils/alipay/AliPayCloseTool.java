package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.dto.AliPayCloseInDto;
import cn.whl.payutils.alipay.dto.AliPayCloseOutDto;
import cn.whl.payutils.enums.Platform;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;

/**
 * 阿里支付订单关闭方法
 * @author wuhailong
 */
public class AliPayCloseTool {
    
    public static AliPayCloseOutDto close(AliPayCloseInDto in) throws AlipayApiException, Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(),in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setNotifyUrl(in.getNotifyUrl());
        
        AlipayTradeCloseModel model = new AlipayTradeCloseModel();
        if(in.getTradeNo() != null && !"".equals(in.getTradeNo())){
            model.setTradeNo(in.getTradeNo());
        }
        if(in.getOutTradeNo() != null && !"".equals(in.getOutTradeNo())){
            model.setOutTradeNo(in.getOutTradeNo());
        }
        if(in.getOperatorId() != null && !"".equals(in.getOperatorId())){
            model.setOperatorId(in.getOperatorId());
        }
        
        request.setBizModel(model);
       
        AlipayTradeCloseResponse response = alipayClient.execute(request);
        
        if("10000".equals(response.getCode())){
            AliPayCloseOutDto out = new AliPayCloseOutDto();
            //wap支付方式，返回的生成表单的字符串
            out.setPlatform(Platform.alipay);
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setOutTradeNo(response.getOutTradeNo());
            out.setTradeNo(response.getTradeNo());
            return out;
        }else if("20000".equals(response.getCode())){
            throw new Exception("服务不可用");
        }else if("20001".equals(response.getCode())){
            throw new Exception("授权权限不足");
        }else if("40001".equals(response.getCode())){
            throw new Exception("缺少必选参数");
        }else if("40002".equals(response.getCode())){
            throw new Exception("非法的参数");
        }else if("40004".equals(response.getCode())){
            throw new Exception("业务处理失败");
        }else if("40006".equals(response.getCode())){
            throw new Exception("权限不足");
        }else{
            throw new Exception("alipay未定义错误");
        }
        
    }
    
    
}
