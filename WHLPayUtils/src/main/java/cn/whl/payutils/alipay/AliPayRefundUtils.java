package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.vo.refund.AliPayRefundIn;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundOut;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundQueryIn;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundQueryOut;
import cn.whl.payutils.enums.Platform;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import java.math.BigDecimal;

/**
 * 阿里支付订单退款方法
 * @author wuhailong
 */
public class AliPayRefundUtils {
    
    public static AliPayRefundOut refund(AliPayRefundIn in) throws AlipayApiException, Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(),in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        if(in.getTradeNo() != null && !"".equals(in.getTradeNo())){
            model.setTradeNo(in.getTradeNo());
        }
        if(in.getOutTradeNo() != null && !"".equals(in.getOutTradeNo())){
            model.setOutTradeNo(in.getOutTradeNo());
        }
        model.setRefundAmount(in.getRefundAmount().toPlainString());
        if(in.getRefundCurrency() != null && !"".equals(in.getRefundCurrency())){
            model.setRefundCurrency(in.getRefundCurrency());
        }
        if(in.getRefundReason() != null && !"".equals(in.getRefundReason())){
            model.setRefundReason(in.getRefundReason());
        }
        if(in.getOutRequestNo() != null && !"".equals(in.getOutRequestNo())){
            model.setOutRequestNo(in.getOutRequestNo());
        }
        if(in.getOperatorId() != null && !"".equals(in.getOperatorId())){
            model.setOperatorId(in.getOperatorId());
        }
        
        if(in.getStoreId() != null && !"".equals(in.getStoreId())){
            model.setStoreId(in.getStoreId());
        }
        if(in.getTerminalId() != null && !"".equals(in.getTerminalId())){
            model.setTerminalId(in.getTerminalId());
        }
        if(in.getGoodsDetail() != null && in.getGoodsDetail().size() > 0){
            model.setGoodsDetail(in.getGoodsDetail());
        }
        if(in.getRefundRoyaltyParameters() != null && in.getRefundRoyaltyParameters().size() > 0){
            model.setRefundRoyaltyParameters(in.getRefundRoyaltyParameters());
        }
        if(in.getOrgPid()!= null && !"".equals(in.getOrgPid())){
            model.setOrgPid(in.getOrgPid());
        }
        request.setBizModel(model);
       
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        
        if("10000".equals(response.getCode())){
            AliPayRefundOut out = new AliPayRefundOut();
            //wap支付方式，返回的生成表单的字符串
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setOutTradeNo(response.getOutTradeNo());
            out.setTradeNo(response.getTradeNo());
            out.setBuyerLogonId(response.getBuyerLogonId());
            out.setFundChange(response.getFundChange());
            out.setRefundFee(new BigDecimal(response.getRefundFee()));
            out.setRefundCurrency(response.getRefundCurrency());
            out.setGmtRefundPay(response.getGmtRefundPay());
            out.setRefundDetailItemList(response.getRefundDetailItemList());
            out.setStoreName(response.getStoreName());
            out.setBuyerUserId(response.getBuyerUserId());
            out.setRefundPresetPayToolList(response.getRefundPresetPaytoolList());
            out.setRefundSettlementId(response.getRefundSettlementId());
            out.setPresentRefundBuyerAmount(new BigDecimal(response.getPresentRefundBuyerAmount()));
            out.setPresentRefundDiscountAmount(new BigDecimal(response.getPresentRefundDiscountAmount()));
            out.setPresentRefundMdiscountAmount(new BigDecimal(response.getPresentRefundMdiscountAmount()));
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

    public static AliPayRefundQueryOut query(AliPayRefundQueryIn in) throws AlipayApiException, Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(),in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
        
        AlipayTradeFastpayRefundQueryModel model = new AlipayTradeFastpayRefundQueryModel();
        if(in.getTradeNo() != null && !"".equals(in.getTradeNo())){
            model.setTradeNo(in.getTradeNo());
        }
        if(in.getOutTradeNo() != null && !"".equals(in.getOutTradeNo())){
            model.setOutTradeNo(in.getOutTradeNo());
        }
        if(in.getOutRequestNo() != null && !"".equals(in.getOutRequestNo())){
            model.setOutRequestNo(in.getOutRequestNo());
        }
        if(in.getOrgPid()!= null && !"".equals(in.getOrgPid())){
            model.setOrgPid(in.getOrgPid());
        }
        request.setBizModel(model);
       
        AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
        
        if("10000".equals(response.getCode())){
            AliPayRefundQueryOut out = new AliPayRefundQueryOut();
            //wap支付方式，返回的生成表单的字符串
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setOutTradeNo(response.getOutTradeNo());
            out.setTradeNo(response.getTradeNo());
            out.setOutRequestNo(response.getOutRequestNo());
            out.setRefundReason(response.getRefundReason());
            out.setTotalAmount(new BigDecimal(response.getTotalAmount()));
            out.setRefundAmount(new BigDecimal(response.getRefundAmount()));
            out.setRefundRoyaltys(response.getRefundRoyaltys());
            out.setGmtRefundPay(response.getGmtRefundPay());
            out.setRefundDetailItemList(response.getRefundDetailItemList());
            out.setSendBackFee(new BigDecimal(response.getSendBackFee()));
            out.setRefundSettlementId(response.getRefundSettlementId());
            out.setPresentRefundBuyerAmount(new BigDecimal(response.getPresentRefundBuyerAmount()));
            out.setPresentRefundDiscountAmount(new BigDecimal(response.getPresentRefundDiscountAmount()));
            out.setPresentRefundMdiscountAmount(new BigDecimal(response.getPresentRefundMdiscountAmount()));
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
