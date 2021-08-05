package cn.whl.payutils.alipay;

import cn.whl.payutils.common.Pay;
import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryIn;
import cn.whl.payutils.alipay.vo.accountQuery.AliPayAccountQueryOut;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignOut;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignIn;
import cn.whl.payutils.alipay.vo.agreement.AliPaySignNotifyIn;
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
        AliPaySignNotifyIn, AliPaySignNotifyResult>{

    @Override
    public AliPayCreateOut create(AliPayCreateIn createIn) throws Exception{
        AliPayCreateOut out = null;
        
        if(createIn.getPayType() == PayType.CREATE){
            out = AliPayCreateUtils.create(createIn);
        }else if(createIn.getPayType() == PayType.PRE){
            out = AliPayCreateUtils.preCreate(createIn);
        }else if(createIn.getPayType() == PayType.WAP){
            out = AliPayCreateUtils.wapPay(createIn);
        }else if(createIn.getPayType() == PayType.APP){
            out = AliPayCreateUtils.appPay(createIn);
        }else if(createIn.getPayType() == PayType.PAGE){
            out = AliPayCreateUtils.pagePay(createIn);
        }else{
            System.out.println("暂不支持此支付方式");
        }
        
        return out;
    }
    
    @Override
    public AliPayPayOut pay(AliPayPayIn payIn) throws Exception{
        AliPayPayOut out = AliPayPayUtils.pay(payIn);
        
        return out;
    }

    @Override
    public AliPayPayNotifyResult payNotify(AliPayPayNotifyIn aliPayPayNotifyIn) throws Exception {
        AliPayPayNotifyResult result = new AliPayPayNotifyResult();
        result.setTradeNo(aliPayPayNotifyIn.getTrade_no());
        result.setOutTradeNo(aliPayPayNotifyIn.getOut_trade_no());
        result.setPayAmt(new BigDecimal(aliPayPayNotifyIn.getTotal_amount()));
        result.setPayer(aliPayPayNotifyIn.getBuyer_id());
        return result;
    }

    @Override
    public AliPayQueryOut query(AliPayQueryIn oderIn) throws Exception {
        AliPayQueryOut out = AliPayQueryUtils.query(oderIn);
        
        return out;
    }

    @Override
    public AliPayCloseOut close(AliPayCloseIn closeIn) throws Exception {
        AliPayCloseOut out = AliPayCloseUtils.close(closeIn);
        
        return out;
    }

    @Override
    public AliPayCloseNotifyResult closeNotify(AliPayCloseNotifyIn closeNotifyIn) throws Exception {
        AliPayCloseNotifyResult result = new AliPayCloseNotifyResult();
        return result;
    }

    @Override
    public AliPayRefundOut refund(AliPayRefundIn refundIn) throws Exception {
        AliPayRefundOut out = AliPayRefundUtils.refund(refundIn);
        
        return out;
    }

    @Override
    public AliPayRefundNotifyResult refundNotify(AliPayRefundNotifyIn refundNotifyIn) throws Exception {
        AliPayRefundNotifyResult result = new AliPayRefundNotifyResult();
        return result;
    }

    @Override
    public AliPayRefundQueryOut refundQuery(AliPayRefundQueryIn refundQueryIn) throws Exception {
        AliPayRefundQueryOut out = AliPayRefundUtils.query(refundQueryIn);
        
        return out;
    }

    @Override
    public AliPayPayByMchOut payByMch(AliPayPayByMchIn payByMchIn) throws Exception {
        AliPayPayByMchOut out = AliPayPayByMchUtils.payByMch(payByMchIn);
        
        return out;
    }

    @Override
    public AliPayPayByMchQueryOut payByMchQuery(AliPayPayByMchQueryIn payByMchQueryIn) throws Exception {
        AliPayPayByMchQueryOut out = AliPayPayByMchUtils.query(payByMchQueryIn);
        
        return out;
    }

    @Override
    public AliPayAccountQueryOut accountQuery(AliPayAccountQueryIn accountQueryIn) throws Exception {
        AliPayAccountQueryOut out = AliPayPayByMchUtils.accountQuery(accountQueryIn);
        
        return out;
    }

    @Override
    public AliPayPayByMchNotifyResult payByMchNotify(AliPayPayByMchNotifyIn payByMchNotifyIn) throws Exception {
        AliPayPayByMchNotifyResult result = new AliPayPayByMchNotifyResult();
        return result;
    }

    @Override
    public AliPaySignOut sign(AliPaySignIn signIn) throws Exception {
        
        AliPaySignOut out = AliPaySignUtils.sign(signIn);
        
        return out;
    }

    @Override
    public AliPaySignNotifyResult signNotify(AliPaySignNotifyIn aliPaySignNotifyIn) throws Exception {
        AliPaySignNotifyResult result = new AliPaySignNotifyResult();
        result.setExternalAgreementNo(aliPaySignNotifyIn.getExternal_agreement_no());
        result.setExternalLogonId(aliPaySignNotifyIn.getExternal_logon_id());
        result.setAlipayUserId(aliPaySignNotifyIn.getAlipay_user_id());
        return result;
    }

    

 


    
    
}
