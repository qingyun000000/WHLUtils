package cn.whl.commonutils.exception;

/**
 * 服务运行异常
 * @createTime 2019-11-29
 * @updateTime 2019-11-29
 * @author wuhailong
 */
public class ServiceRunException extends Exception{
    
    private static final String CODE = "RUN";

    public ServiceRunException() {
    }

    public ServiceRunException(String message) {
        super(message);
    }

    public ServiceRunException(Throwable cause) {
        super(cause);
    }

    public String getCODE() {
        return CODE;
    }
    
    public String exceptionOut(){
        return "服务运行失败 [" + this.getMessage() + "]";
    }
    
}
