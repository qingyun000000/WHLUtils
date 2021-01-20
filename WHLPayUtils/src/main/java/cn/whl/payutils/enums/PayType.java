package cn.whl.payutils.enums;

/**
 * 支付方式
 * @author wuhailong
 */
public enum PayType {
    
    COMMON,      //通用，给不用经过前端跳转的场景使用 【支付宝支付】【支付宝下单】
    WAP,         //手机网站下单并跳转， 【支付宝下单】
    PAGE,        //网页下单并跳转， 【支付宝下单】
    APP,         //app下单并跳转， 【支付宝下单】
    PRE          //交易预创建， 【支付宝下单】
    
}
