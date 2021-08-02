package cn.whl.payutils.alipay;

import cn.whl.payutils.common.Pay;
import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryIn;
import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryOut;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignOut;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignIn;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignNotifyResult;
import cn.whl.payutils.alipay.vo.close.AliPayCloseIn;
import cn.whl.payutils.alipay.vo.close.AliPayCloseNotifyIn;
import cn.whl.payutils.alipay.vo.close.AliPayCloseNotifyResult;
import cn.whl.payutils.alipay.vo.close.AliPayCloseOut;
import cn.whl.payutils.alipay.vo.query.AliPayQueryIn;
import cn.whl.payutils.alipay.vo.query.AliPayQueryOut;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchIn;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchNotifyIn;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchNotifyResult;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchOut;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchQueryIn;
import cn.whl.payutils.alipay.vo.payByMch.AliPayPayByMchQueryOut;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.alipay.vo.create.AliPayCreateIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayNotifyIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayNotifyResult;
import cn.whl.payutils.alipay.vo.create.AliPayCreateOut;
import cn.whl.payutils.alipay.vo.pay.AliPayPayIn;
import cn.whl.payutils.alipay.vo.pay.AliPayPayOut;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundIn;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundNotifyIn;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundNotifyResult;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundOut;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundQueryIn;
import cn.whl.payutils.alipay.vo.refund.AliPayRefundQueryOut;
import cn.whl.payutils.common.agreement.SignNotifyIn;
import java.math.BigDecimal;

/**
 * 阿里支付
 * @author wuhailong
 */
public class AliPay implements Pay<
        AliPayCreateIn, AliPayCreateOut,
        AliPayPayIn, AliPayPayOut,
        AliPayPayNotifyIn, AliPayPayNotifyResult,
        AliPayQueryIn, AliPayQueryOut,
        AliPayCloseIn, AliPayCloseOut,
        AliPayCloseNotifyIn, AliPayCloseNotifyResult,
        AliPayRefundIn, AliPayRefundOut,
        AliPayRefundNotifyIn, AliPayRefundNotifyResult,
        AliPayRefundQueryIn, AliPayRefundQueryOut,
        AliPayPayByMchIn, AliPayPayByMchOut,
        AliPayPayByMchQueryIn, AliPayPayByMchQueryOut,
        AliPayAccountQueryIn, AliPayAccountQueryOut,
        AliPayPayByMchNotifyIn, AliPayPayByMchNotifyResult,
        AliPaySignIn, AliPaySignOut,
        SignNotifyIn, AliPaySignNotifyResult>{

    @Override
    public AliPayCreateOut create(AliPayCreateIn createParams) throws Exception{
        AliPayCreateOut out = null;
        
        if(createParams.getPayType() == PayType.CREATE){
            out = AliPayCreateUtils.create(createParams);
        }else if(createParams.getPayType() == PayType.PRE){
            out = AliPayCreateUtils.preCreate(createParams);
        }else if(createParams.getPayType() == PayType.WAP){
            out = AliPayCreateUtils.wapPay(createParams);
        }else if(createParams.getPayType() == PayType.APP){
            out = AliPayCreateUtils.appPay(createParams);
        }else if(createParams.getPayType() == PayType.PAGE){
            out = AliPayCreateUtils.pagePay(createParams);
        }else{
            System.out.println("暂不支持此支付方式");
        }
        
        return out;
    }
    
    @Override
    public AliPayPayOut pay(AliPayPayIn payParams) throws Exception{
        AliPayPayOut out = AliPayPayUtils.pay(payParams);
        
        return out;
    }

    @Override
    public AliPayPayNotifyResult payNotify(AliPayPayNotifyIn aliPayPayNotifyIn) throws Exception {
        AliPayPayNotifyResult result = new AliPayPayNotifyResult();
        result.setTradeNo(aliPayPayNotifyIn.getTrade_no());
        result.setOutTradeNo(aliPayPayNotifyIn.getOut_trade_no());
        result.setPayAmt(new BigDecimal(aliPayPayNotifyIn.getTotal_amount()));
        return result;
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
    public AliPayCloseNotifyResult closeNotify(AliPayCloseNotifyIn closeNotifyParams) throws Exception {
        AliPayCloseNotifyResult result = new AliPayCloseNotifyResult();
        return result;
    }

    @Override
    public AliPayRefundOut refund(AliPayRefundIn refundParams) throws Exception {
        AliPayRefundOut out = AliPayRefundUtils.refund(refundParams);
        
        return out;
    }

    @Override
    public AliPayRefundNotifyResult refundNotify(AliPayRefundNotifyIn refundNotifyParams) throws Exception {
        AliPayRefundNotifyResult result = new AliPayRefundNotifyResult();
        return result;
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
    public AliPayPayByMchNotifyResult payByMchNotify(AliPayPayByMchNotifyIn payByMchNotifyParams) throws Exception {
        AliPayPayByMchNotifyResult result = new AliPayPayByMchNotifyResult();
        return result;
    }

    @Override
    public AliPaySignOut sign(AliPaySignIn signParams) throws Exception {
        
        AliPaySignOut out = AliPaySignUtils.sign(signParams);
        
        return out;
    }

    @Override
    public AliPaySignNotifyResult signNotify(SignNotifyIn signParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

 


    
    
}
