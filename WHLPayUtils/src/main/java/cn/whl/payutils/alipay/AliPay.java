package cn.whl.payutils.alipay;

import cn.whl.payutils.Pay;
import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryIn;
import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryOut;
import cn.whl.payutils.alipay.vo.close.AliPayCloseIn;
import cn.whl.payutils.alipay.vo.closeNotify.AliPayCloseNotify;
import cn.whl.payutils.alipay.vo.closeNotify.AliPayCloseNotifyResult;
import cn.whl.payutils.alipay.vo.close.AliPayCloseOut;
import cn.whl.payutils.alipay.vo.query.AliPayQueryIn;
import cn.whl.payutils.alipay.vo.query.AliPayQueryOut;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchIn;
import cn.whl.payutils.alipay.vo.payByMchNotify.AliPayPayByMchNotify;
import cn.whl.payutils.alipay.vo.payByMchNotify.AliPayPayByMchNotifyResult;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchOut;
import cn.whl.payutils.alipay.vo.payByMchQuery.AliPayPayByMchQueryIn;
import cn.whl.payutils.alipay.vo.payByMchQuery.AliPayPayByMchQueryOut;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.alipay.vo.pay.AliPayPayIn;
import cn.whl.payutils.alipay.vo.payNotify.AliPayPayNotify;
import cn.whl.payutils.alipay.vo.payNotify.AliPayPayNotifyResult;
import cn.whl.payutils.alipay.vo.pay.AliPayPayOut;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundIn;
import cn.whl.payutils.alipay.vo.refundNotify.AliPayRefundNotify;
import cn.whl.payutils.alipay.vo.refundNotify.AliPayRefundNotifyResult;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundOut;
import cn.whl.payutils.alipay.vo.refundQuery.AliPayRefundQueryIn;
import cn.whl.payutils.alipay.vo.refundQuery.AliPayRefundQueryOut;
import java.math.BigDecimal;

/**
 * 阿里支付
 * @author wuhailong
 */
public class AliPay implements Pay<AliPayPayIn, AliPayPayOut,
        AliPayPayNotify, AliPayPayNotifyResult,
        AliPayQueryIn, AliPayQueryOut,
        AliPayCloseIn, AliPayCloseOut,
        AliPayCloseNotify, AliPayCloseNotifyResult,
        AliPayRefundIn, AliPayRefundOut,
        AliPayRefundNotify, AliPayRefundNotifyResult,
        AliPayRefundQueryIn, AliPayRefundQueryOut,
        AliPayPayByMchIn, AliPayPayByMchOut,
        AliPayPayByMchQueryIn, AliPayPayByMchQueryOut,
        AliPayAccountQueryIn, AliPayAccountQueryOut,
        AliPayPayByMchNotify, AliPayPayByMchNotifyResult>{

    @Override
    public AliPayPayOut pay(AliPayPayIn payParams) throws Exception{
        AliPayPayOut out = null;
        
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
    public AliPayPayNotifyResult payNotify(AliPayPayNotify aliPayPayNotifyDto) throws Exception {
        AliPayPayNotifyResult outDto = new AliPayPayNotifyResult();
        outDto.setTradeNo(aliPayPayNotifyDto.getTrade_no());
        outDto.setOutTradeNo(aliPayPayNotifyDto.getOut_trade_no());
        outDto.setPayAmt(new BigDecimal(aliPayPayNotifyDto.getTotal_amount()));
        return outDto;
    }

    @Override
    public AliPayQueryOut query(AliPayQueryIn oderParams) throws Exception {
        AliPayQueryOut out = AliPayQueryUtils.query(oderParams);
        
        return out;
    }

    @Override
    public AliPayCloseOut close(AliPayCloseIn closeParams) throws Exception {
        AliPayCloseOut out = AliPayCloseUtils.close(closeParams);
        
        return out;
    }

    @Override
    public AliPayCloseNotifyResult closeNotify(AliPayCloseNotify closeNotifyParams) throws Exception {
        AliPayCloseNotifyResult outDto = new AliPayCloseNotifyResult();
        return outDto;
    }

    @Override
    public AliPayRefundOut refund(AliPayRefundIn refundParams) throws Exception {
        AliPayRefundOut out = AliPayRefundUtils.refund(refundParams);
        
        return out;
    }

    @Override
    public AliPayRefundNotifyResult refundNotify(AliPayRefundNotify refundNotifyParams) throws Exception {
        AliPayRefundNotifyResult outDto = new AliPayRefundNotifyResult();
        return outDto;
    }

    @Override
    public AliPayRefundQueryOut refundQuery(AliPayRefundQueryIn refundQueryParams) throws Exception {
        AliPayRefundQueryOut out = AliPayRefundUtils.query(refundQueryParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchOut payByMch(AliPayPayByMchIn payByMchParams) throws Exception {
        AliPayPayByMchOut out = AliPayPayByMchUtils.payByMch(payByMchParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchQueryOut payByMchQuery(AliPayPayByMchQueryIn payByMchQueryParams) throws Exception {
        AliPayPayByMchQueryOut out = AliPayPayByMchUtils.query(payByMchQueryParams);
        
        return out;
    }

    @Override
    public AliPayAccountQueryOut accountQuery(AliPayAccountQueryIn accountQueryParams) throws Exception {
        AliPayAccountQueryOut out = AliPayPayByMchUtils.accountQuery(accountQueryParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchNotifyResult payByMchNotify(AliPayPayByMchNotify payByMchNotifyParams) throws Exception {
        AliPayPayByMchNotifyResult outDto = new AliPayPayByMchNotifyResult();
        return outDto;
    }

 


    
    
}
