package cn.whl.payutils.alipay;

import cn.whl.payutils.Pay;
import cn.whl.payutils.alipay.dto.AliPayCloseInDto;
import cn.whl.payutils.alipay.dto.AliPayCloseNotifyInDto;
import cn.whl.payutils.alipay.dto.AliPayCloseNotifyOutDto;
import cn.whl.payutils.alipay.dto.AliPayCloseOutDto;
import cn.whl.payutils.alipay.dto.AliPayQueryInDto;
import cn.whl.payutils.alipay.dto.AliPayQueryOutDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchInDto;
import cn.whl.payutils.alipay.dto.AliPayPayByMchOutDto;
import cn.whl.payutils.enums.PayType;
import cn.whl.payutils.alipay.dto.AliPayPayInDto;
import cn.whl.payutils.alipay.dto.AliPayPayNotifyInDto;
import cn.whl.payutils.alipay.dto.AliPayPayNotifyOutDto;
import cn.whl.payutils.alipay.dto.AliPayPayOutDto;
import cn.whl.payutils.alipay.dto.AliPayRefundInDto;
import cn.whl.payutils.alipay.dto.AliPayRefundNotifyInDto;
import cn.whl.payutils.alipay.dto.AliPayRefundNotifyOutDto;
import cn.whl.payutils.alipay.dto.AliPayRefundOutDto;
import cn.whl.payutils.alipay.dto.AliPayRefundQueryInDto;
import cn.whl.payutils.alipay.dto.AliPayRefundQueryOutDto;

/**
 * 阿里支付
 * @author wuhailong
 */
public class AliPay implements Pay<AliPayPayInDto, AliPayPayOutDto,
        AliPayPayNotifyInDto, AliPayPayNotifyOutDto,
        AliPayQueryInDto, AliPayQueryOutDto,
        AliPayCloseInDto, AliPayCloseOutDto,
        AliPayCloseNotifyInDto, AliPayCloseNotifyOutDto,
        AliPayRefundInDto, AliPayRefundOutDto,
        AliPayRefundNotifyInDto, AliPayRefundNotifyOutDto,
        AliPayRefundQueryInDto, AliPayRefundQueryOutDto,
        AliPayPayByMchInDto, AliPayPayByMchOutDto>{

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
    public AliPayPayNotifyOutDto payNotify(AliPayPayNotifyInDto aliPayPayNotifyInDto) throws Exception {
        AliPayPayNotifyOutDto outDto = new AliPayPayNotifyOutDto();
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
    public AliPayCloseNotifyOutDto closeNotify(AliPayCloseNotifyInDto closeNotifyParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AliPayRefundOutDto refund(AliPayRefundInDto refundParams) throws Exception {
        AliPayRefundOutDto out = AliPayRefundTool.refund(refundParams);
        
        return out;
    }

    @Override
    public AliPayRefundNotifyOutDto refundNotify(AliPayRefundNotifyInDto refundParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AliPayRefundQueryOutDto refundQuery(AliPayRefundQueryInDto refundQueryParams) throws Exception {
        AliPayRefundQueryOutDto out = AliPayRefundTool.query(refundQueryParams);
        
        return out;
    }

    @Override
    public AliPayPayByMchOutDto payByMch(AliPayPayByMchInDto payByMchParams) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 


    
    
}
