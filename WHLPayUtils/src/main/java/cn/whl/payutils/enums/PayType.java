package cn.whl.payutils.enums;

/**
 * 支付方式
 * @author wuhailong
 */
public enum PayType {
    
    CREATE,      //
    WAP,         //手机网站下单并跳转， 【支付宝下单】
    PAGE,        //网页下单并跳转， 【支付宝下单】
    APP,         //app下单并跳转， 【支付宝下单】
    PRE,         //交易预创建， 【支付宝下单】
    
    PAY,         //【支付宝支付】
    
    REFUND,      //退货
    
    
    SIGN,       //代扣协议签署
    
    
    
    
}
