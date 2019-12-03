package cn.whl.commonutils.exception;

/**
 * 通用异常
 * @createTime 20191129
 * @updateTime 20191129
 * @author wuhailong
 */
public class CommonException extends Exception{
    
    private final String CODE = "COMMONEXP";

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
        return "通用异常：[" + this.getMessage() + "]";
    }
    
}
