package cn.whl.commonutils.exception;

/**
 * 空异常
 * @createTime 2019-11-29
 * @updateTime 2019-11-29
 * @author wuhailong
 */
public class NullException extends CommonException{
    
    private static final String CODE = "NULL";

    public NullException() {
    }

    public NullException(String message) {
        super(message);
    }

    public NullException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "[" + this.getMessage() + "] 为空值";
    }
    
    
}
