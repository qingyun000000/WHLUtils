package cn.whl.payutils.alipay.vo;

/**
 * alipay前台回跳参数（支付完成后，返回商家页面带的参数，页面地址为pay的returnUrl)公共参数部分
 * @author wuhailong
 */
public class AliPayReturn extends AliPay {
    
    private String appId;
    
    private String method;
    
    private String signType;
    
    private String sign;
    
    private String charset;
    
    private String timestamp;
    
    private String version;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    
    
}
