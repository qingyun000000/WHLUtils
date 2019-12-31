package cn.whl.commonutils.exception;

/**
 * 余额不足异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class BalanceInsException extends CommonException{
    
    private static final String CODE = "BALANCEINS";

    public BalanceInsException() {
    }

    public BalanceInsException(String message) {
        super(message);
    }

    public BalanceInsException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return " [" + this.getMessage() + "] 余额不足";
    }
    
    
}
