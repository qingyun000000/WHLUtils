package cn.whl.commonutils.exception;

/**
 * 金额不为零异常
 * @createTime 2020-8-14
 * @updateTime 2020-8-14
 * @author wuhailong
 */
public class AmtNotZeroException extends CommonException{
    
    private static final String CODE = "AMTNOTZERO";

    public AmtNotZeroException() {
    }

    public AmtNotZeroException(String message) {
        super(message);
    }

    public AmtNotZeroException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "[" + this.getMessage() + "] 金额不为0";
    }
    
    
}
