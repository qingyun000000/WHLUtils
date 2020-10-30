package cn.whl.payutils.alipay;

import cn.whl.payutils.alipay.dto.query.AliPayQueryInDto;
import cn.whl.payutils.alipay.dto.query.AliPayQueryOutDto;
import cn.whl.payutils.enums.Platform;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import java.math.BigDecimal;

/**
 * 阿里支付订单查询方法
 * @author wuhailong
 */
public class AliPayQueryUtils {
    
    public static AliPayQueryOutDto query(AliPayQueryInDto in) throws AlipayApiException, Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(in.getServerUrl(),in.getAppId(), in.getPrivateKey(), in.getFormat(), in.getCharSet(), in.getAlipayPublicKey(), in.getSignType());
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        if(in.getTradeNo() != null && !"".equals(in.getTradeNo())){
            model.setTradeNo(in.getTradeNo());
        }
        if(in.getOutTradeNo() != null && !"".equals(in.getOutTradeNo())){
            model.setOutTradeNo(in.getOutTradeNo());
        }
        if(in.getOrgPid()!= null && !"".equals(in.getOrgPid())){
            model.setOrgPid(in.getOrgPid());
        }
        if(in.getQueryOptions()!= null && !"".equals(in.getQueryOptions())){
            model.setQueryOptions(in.getQueryOptions());
        }
        
        request.setBizModel(model);
       
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        
        if("10000".equals(response.getCode())){
            AliPayQueryOutDto out = new AliPayQueryOutDto();
            
            out.setCode(response.getCode());
            out.setMsg(response.getMsg());
            out.setSubCode(response.getSubMsg());
            out.setSubMsg(response.getSubMsg());
            out.setOutTradeNo(response.getOutTradeNo());
            out.setTradeNo(response.getTradeNo());
            out.setSubject(response.getSubject());
            out.setBody(response.getBody());
            out.setBuyerLogonId(response.getBuyerLogonId());
            out.setBuyerUserType(response.getBuyerUserType());
            out.setBuyerUserId(response.getBuyerUserId());
            out.setBuyerUserName(response.getBuyerUserName());
            out.setTradeStatus(response.getTradeStatus());
            out.setTotalAmount(new BigDecimal(response.getTotalAmount()));
            out.setTransCurrency(response.getTransCurrency());
            out.setSettleCurrency(response.getSettleCurrency());
            out.setSettleAmount(new BigDecimal(response.getSettleAmount()));
            out.setPayCurrency(response.getPayCurrency());
            out.setPayAmount(new BigDecimal(response.getPayAmount()));
            out.setSettleTransRate(new Double(response.getSettleTransRate()));
            out.setTransPayRate(new Double(response.getTransPayRate()));
            out.setBuyerPayAmount(new BigDecimal(response.getBuyerPayAmount()));
            out.setReceiptAmount(new BigDecimal(response.getReceiptAmount()));
            out.setMdiscountAmount(new BigDecimal(response.getMdiscountAmount()));
            out.setDiscountAmount(new BigDecimal(response.getDiscountAmount()));
            out.setPointAmount(new BigDecimal(response.getPointAmount()));
            out.setInvoiceAmount(new BigDecimal(response.getInvoiceAmount()));
            out.setSendPayDate(response.getSendPayDate());
            out.setStoreId(response.getStoreId());
            out.setStoreName(response.getStoreName());
            out.setTerminalId(response.getTerminalId());
            out.setFundBillList(response.getFundBillList());
            out.setChargeFlags(response.getChargeFlags());
            out.setSettlementId(response.getSettlementId());
            out.setTradeSettleInfo(response.getTradeSettleInfo());
            out.setAuthTradePayMode(response.getAuthTradePayMode());
            out.setAlipaySubMerchantId(response.getAlipaySubMerchantId());
            out.setExtInfos(response.getExtInfos());
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
