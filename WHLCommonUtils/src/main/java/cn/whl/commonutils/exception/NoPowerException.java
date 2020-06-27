package cn.whl.commonutils.exception;

/**
 * 没有权限异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class NoPowerException extends CommonException{
    
    private static final String CODE = "NOPOWER";

    public NoPowerException() {
    }

    public NoPowerException(String message) {
        super(message);
    }

    public NoPowerException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "用户没有权限进行 [" + this.getMessage() + "] 操作";
    }
    
    
}
