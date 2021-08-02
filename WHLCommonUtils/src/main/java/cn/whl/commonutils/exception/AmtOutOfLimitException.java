package cn.whl.commonutils.exception;

/**
 * 金额超限异常
 * @createTime 2020-8-14
 * @updateTime 2020-8-14
 * @author wuhailong
 */
public class AmtOutOfLimitException extends CommonException{
    
    private static final String CODE = "AMTNOUTOFLIMIT";

    public AmtOutOfLimitException() {
    }

    public AmtOutOfLimitException(String message) {
        super(message);
    }

    public AmtOutOfLimitException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "金额超出 [" + this.getMessage() + "] 限制";
    }
    
    
}
