package cn.whl.commonutils.exception;

/**
 * 输入错误异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class StateWrongException extends CommonException{
    
    private static final String CODE = "STATEWRONG";

    public StateWrongException() {
    }

    public StateWrongException(String message) {
        super(message);
    }

    public StateWrongException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return " [" + this.getMessage() + "] 状态错误";
    }
    
    
}
