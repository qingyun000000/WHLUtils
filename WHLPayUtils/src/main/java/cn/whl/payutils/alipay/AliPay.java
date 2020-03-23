package cn.whl.payutils.alipay;

import cn.whl.payutils.Pay;
import cn.whl.payutils.alipay.dto.AliPayAccountQueryInDto;
import cn.whl.payutils.alipay.dto.AliPayAccountQueryOutDto;
import cn.whl.payutils.alipay.dto.AliPayCloseInDto;
import cn.whl.payutils.alipay.dto.AliPayCloseNotifyDto;
import cn.whl.payutils.alipay.dto.AliPayCloseNotifyResultDto;
import cn.whl.payutils.alipay.dto.AliPayCloseOutDto;
import cn.whl.payutils.alipay.dto.AliPayQueryInDto;
import cn.whl.payutils.alipay.dto.AliPayQueryOutDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchInDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchNotifyDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchNotifyResultDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchOutDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchQueryInDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchQueryOutDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.alipay.dto.AliPayPayInDto;
import cn.whl.payutils.alipay.dto.AliPayPayNotifyDto;
import cn.whl.payutils.alipay.dto.AliPayPayNotifyResultDto;
import cn.whl.payutils.alipay.dto.AliPayPayOutDto;
import cn.whl.payutils.alipay.dto.AliPayRefundInDto;
import cn.whl.payutils.alipay.dto.AliPayRefundNotifyDto;
import cn.whl.payutils.alipay.dto.AliPayRefundNotifyResultDto;
import cn.whl.payutils.alipay.dto.AliPayRefundOutDto;
import cn.whl.payutils.alipay.dto.AliPayRefundQueryInDto;
import cn.whl.payutils.alipay.dto.AliPayRefundQueryOutDto;

/**
 * 阿里支付
 * @author wuhailong
 */
public class AliPay implements Pay<AliPayPayInDto, AliPayPayOutDto,
        AliPayPayNotifyDto, AliPayPayNotifyResultDto,
        AliPayQueryInDto, AliPayQueryOutDto,
        AliPayCloseInDto, AliPayCloseOutDto,
        AliPayCloseNotifyDto, AliPayCloseNotifyResultDto,
        AliPayRefundInDto, AliPayRefundOutDto,
        AliPayRefundNotifyDto, AliPayRefundNotifyResultDto,
        AliPayRefundQueryInDto, AliPayRefundQueryOutDto,
        AliPayPayByMchInDto, AliPayPayByMchOutDto,
        AliPayPayByMchQueryInDto, AliPayPayByMchQueryOutDto,
        AliPayAccountQueryInDto, AliPayAccountQueryOutDto,
        AliPayPayByMchNotifyDto, AliPayPayByMchNotifyResultDto>{

    @Override
    public AliPayPayOutDto pay(AliPayPayInDto payParams) throws Exception{
        AliPayPayOutDto out = null;
        
        if(payParams.getPayType() == PayType.wap){
            out = AliPayPayTool.wapPay(payParams);
        }else if(payParams.getPayType() == PayType.app){
            out = AliPayPayTool.appPay(payParams);
        }else if(payParams.getPayType() == PayType.page){
            out = AliPayPayTool.pagePay(payParams);
        }else{
            System.out.println("暂不支持此支付方式");
        }
        
        return out;
    }

    @Override
    public AliPayPayNotifyResultDto payNotify(AliPayPayNotifyDto aliPayPayNotifyInDto) throws Exception {
        AliPayPayNotifyResultDto outDto = new AliPayPayNotifyResultDto();
        outDto.setTradeNo(aliPayPayNotifyInDto.getTrade_no());
        return outDto;
    }

    @Override
    public AliPayQueryOutDto query(AliPayQueryInDto oderParams) throws Exception {
        AliPayQueryOutDto out = AliPayQueryTool.query(oderParams);
        
        return out;
    }

    @Override
    public AliPayCloseOutDto close(AliPayCloseInDto closeParams) throws Exception {
        AliPayCloseOutDto out = AliPayCloseTool.close(closeParams);
        
        return out;
    }

    @Override
    public AliPayCloseNotifyResultDto closeNotify(AliPayCloseNotifyDto closeNotifyParams) throws Exception {
        AliPayCloseNotifyResultDto outDto = new AliPayCloseNotifyResultDto();
        return outDto;
    }

    @Override
    public AliPayRefundOutDto refund(AliPayRefundInDto refundParams) throws Exception {
        AliPayRefundOutDto out = AliPayRefundTool.refund(refundParams);
        
        return out;
    }

    @Override
    public AliPayRefundNotifyResultDto refundNotify(AliPayRefundNotifyDto refundNotifyParams) throws Exception {
        AliPayRefundNotifyResultDto outDto = new AliPayRefundNotifyResultDto();
        return outDto;
    }

    @Override
    public AliPayRefundQueryOutDto refundQuery(AliPayRefundQueryInDto refundQueryParams) throws Exception {
        AliPayRefundQueryOutDto out = AliPayRefundTool.query(refundQueryParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchOutDto payByMch(AliPayPayByMchInDto payByMchParams) throws Exception {
        AliPayPayByMchOutDto out = AliPayPayByMchTool.payByMch(payByMchParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchQueryOutDto payByMchQuery(AliPayPayByMchQueryInDto payByMchQueryParams) throws Exception {
        AliPayPayByMchQueryOutDto out = AliPayPayByMchTool.query(payByMchQueryParams);
        
        return out;
    }

    @Override
    public AliPayAccountQueryOutDto accountQuery(AliPayAccountQueryInDto accountQueryParams) throws Exception {
        AliPayAccountQueryOutDto out = AliPayPayByMchTool.accountQuery(accountQueryParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchNotifyResultDto payByMchNotify(AliPayPayByMchNotifyDto payByMchNotifyParams) throws Exception {
        AliPayPayByMchNotifyResultDto outDto = new AliPayPayByMchNotifyResultDto();
        return outDto;
    }

 


    
    
}
