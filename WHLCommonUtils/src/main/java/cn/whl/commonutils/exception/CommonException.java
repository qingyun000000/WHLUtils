package cn.whl.commonutils.exception;

/**
 * 通用异常
 * @createTime 2019-11-29
 * @updateTime 2019-11-29
 * @author wuhailong
 */
public class CommonException extends Exception{
    
    private static final String CODE = "COMMONEXP";

    public CommonException() {
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public String getCODE() {
        return CODE;
    }
    
    public String exceptionOut(){
        return "通用异常 [" + this.getMessage() + "]";
    }
    
}
