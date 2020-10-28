package cn.whl.commonutils.exception;

/**
 * 超时异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class TimeOverException extends CommonException{
    
    private static final String CODE = "TIMEOVER";

    public TimeOverException() {
    }

    public TimeOverException(String message) {
        super(message);
    }

    public TimeOverException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return " [" + this.getMessage() + "] 时间超过规定时间";
    }
    
    
}
