package cn.whl.payutils.alipay;

import cn.whl.payutils.Pay;
import cn.whl.payutils.alipay.dto.accountQuery.AliPayAccountQueryInDto;
import cn.whl.payutils.alipay.dto.accountQuery.AliPayAccountQueryOutDto;
import cn.whl.payutils.alipay.dto.close.AliPayCloseInDto;
import cn.whl.payutils.alipay.dto.closeNotify.AliPayCloseNotifyDto;
import cn.whl.payutils.alipay.dto.closeNotify.AliPayCloseNotifyResultDto;
import cn.whl.payutils.alipay.dto.close.AliPayCloseOutDto;
import cn.whl.payutils.alipay.dto.query.AliPayQueryInDto;
import cn.whl.payutils.alipay.dto.query.AliPayQueryOutDto;
import cn.whl.payutils.alipay.dto.payByMch.AliPayPayByMchInDto;
import cn.whl.payutils.alipay.dto.payByMchNotify.AliPayPayByMchNotifyDto;
import cn.whl.payutils.alipay.dto.payByMchNotify.AliPayPayByMchNotifyResultDto;
import cn.whl.payutils.alipay.dto.payByMch.AliPayPayByMchOutDto;
import cn.whl.payutils.alipay.dto.payByMchQuery.AliPayPayByMchQueryInDto;
import cn.whl.payutils.alipay.dto.payByMchQuery.AliPayPayByMchQueryOutDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.alipay.dto.pay.AliPayPayInDto;
import cn.whl.payutils.alipay.dto.payNotify.AliPayPayNotifyDto;
import cn.whl.payutils.alipay.dto.payNotify.AliPayPayNotifyResultDto;
import cn.whl.payutils.alipay.dto.pay.AliPayPayOutDto;
import cn.whl.payutils.alipay.dto.refund.AliPayRefundInDto;
import cn.whl.payutils.alipay.dto.refundNotify.AliPayRefundNotifyDto;
import cn.whl.payutils.alipay.dto.refundNotify.AliPayRefundNotifyResultDto;
import cn.whl.payutils.alipay.dto.refund.AliPayRefundOutDto;
import cn.whl.payutils.alipay.dto.refundQuery.AliPayRefundQueryInDto;
import cn.whl.payutils.alipay.dto.refundQuery.AliPayRefundQueryOutDto;
import java.math.BigDecimal;

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
        
        if(payParams.getPayType() == PayType.WAP){
            out = AliPayPayUtils.wapPay(payParams);
        }else if(payParams.getPayType() == PayType.APP){
            out = AliPayPayUtils.appPay(payParams);
        }else if(payParams.getPayType() == PayType.PAGE){
            out = AliPayPayUtils.pagePay(payParams);
        }else{
            System.out.println("暂不支持此支付方式");
        }
        
        return out;
    }

    @Override
    public AliPayPayNotifyResultDto payNotify(AliPayPayNotifyDto aliPayPayNotifyDto) throws Exception {
        AliPayPayNotifyResultDto outDto = new AliPayPayNotifyResultDto();
        outDto.setTradeNo(aliPayPayNotifyDto.getTrade_no());
        outDto.setOutTradeNo(aliPayPayNotifyDto.getOut_trade_no());
        outDto.setPayAmt(new BigDecimal(aliPayPayNotifyDto.getTotal_amount()));
        return outDto;
    }

    @Override
    public AliPayQueryOutDto query(AliPayQueryInDto oderParams) throws Exception {
        AliPayQueryOutDto out = AliPayQueryUtils.query(oderParams);
        
        return out;
    }

    @Override
    public AliPayCloseOutDto close(AliPayCloseInDto closeParams) throws Exception {
        AliPayCloseOutDto out = AliPayCloseUtils.close(closeParams);
        
        return out;
    }

    @Override
    public AliPayCloseNotifyResultDto closeNotify(AliPayCloseNotifyDto closeNotifyParams) throws Exception {
        AliPayCloseNotifyResultDto outDto = new AliPayCloseNotifyResultDto();
        return outDto;
    }

    @Override
    public AliPayRefundOutDto refund(AliPayRefundInDto refundParams) throws Exception {
        AliPayRefundOutDto out = AliPayRefundUtils.refund(refundParams);
        
        return out;
    }

    @Override
    public AliPayRefundNotifyResultDto refundNotify(AliPayRefundNotifyDto refundNotifyParams) throws Exception {
        AliPayRefundNotifyResultDto outDto = new AliPayRefundNotifyResultDto();
        return outDto;
    }

    @Override
    public AliPayRefundQueryOutDto refundQuery(AliPayRefundQueryInDto refundQueryParams) throws Exception {
        AliPayRefundQueryOutDto out = AliPayRefundUtils.query(refundQueryParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchOutDto payByMch(AliPayPayByMchInDto payByMchParams) throws Exception {
        AliPayPayByMchOutDto out = AliPayPayByMchUtils.payByMch(payByMchParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchQueryOutDto payByMchQuery(AliPayPayByMchQueryInDto payByMchQueryParams) throws Exception {
        AliPayPayByMchQueryOutDto out = AliPayPayByMchUtils.query(payByMchQueryParams);
        
        return out;
    }

    @Override
    public AliPayAccountQueryOutDto accountQuery(AliPayAccountQueryInDto accountQueryParams) throws Exception {
        AliPayAccountQueryOutDto out = AliPayPayByMchUtils.accountQuery(accountQueryParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchNotifyResultDto payByMchNotify(AliPayPayByMchNotifyDto payByMchNotifyParams) throws Exception {
        AliPayPayByMchNotifyResultDto outDto = new AliPayPayByMchNotifyResultDto();
        return outDto;
    }

 


    
    
}
