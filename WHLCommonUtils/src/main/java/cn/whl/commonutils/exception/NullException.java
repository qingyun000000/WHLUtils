package cn.whl.commonutils.exception;

/**
 * 空异常
 * @createTime 20191129
 * @updateTime 20191129
 * @author wuhailong
 */
public class NullException extends CommonException{
    
    private final String CODE = "NULL";

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
        return "[" + this.getMessage() + "]为空值";
    }
    
    
}
