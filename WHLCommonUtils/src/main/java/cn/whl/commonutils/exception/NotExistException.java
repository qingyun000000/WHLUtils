package cn.whl.commonutils.exception;

/**
 * 不存在异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class NotExistException extends CommonException{
    
    private static final String CODE = "NEXIST";

    public NotExistException() {
    }

    public NotExistException(String message) {
        super(message);
    }

    public NotExistException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "[" + this.getMessage() + "] 不存在";
    }
    
    
}
