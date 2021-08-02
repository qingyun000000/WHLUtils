package cn.whl.payutils.alipay.vo.query;

import cn.whl.payutils.alipay.vo.AliPayIn;
import java.util.List;
import cn.whl.payutils.common.QueryIn;


/**
 * 阿里支付订单查询传入参数封装
 * @author wuhailong
 */
public class AliPayQueryIn extends AliPayIn implements QueryIn{
    //通用部分
    private String tradeNo;   //与outTradeNo二选一， 支付宝交易流水号
    
    private String outTradeNo;   //与outTradeNo二选一， 商户网站唯一订单号
    
    private String orgPid;       //仅银行间联模式，收单机构pid
    
    private List<String> queryOptions;  //查询选项，定制查询返回信息

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getOrgPid() {
        return orgPid;
    }

    public void setOrgPid(String orgPid) {
        this.orgPid = orgPid;
    }

    public List<String> getQueryOptions() {
        return queryOptions;
    }

    public void setQueryOptions(List<String> queryOptions) {
        this.queryOptions = queryOptions;
    }
    
}
