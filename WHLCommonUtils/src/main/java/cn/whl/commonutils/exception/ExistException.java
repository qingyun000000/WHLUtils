package cn.whl.commonutils.exception;

/**
 * 存在异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class ExistException extends CommonException{
    
    private static final String CODE = "EXIST";

    public ExistException() {
    }

    public ExistException(String message) {
        super(message);
    }

    public ExistException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "[" + this.getMessage() + "] 已存在";
    }
    
    
}
