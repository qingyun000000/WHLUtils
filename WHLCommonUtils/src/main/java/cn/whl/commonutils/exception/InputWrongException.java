package cn.whl.commonutils.exception;

/**
 * 输入错误异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class InputWrongException extends CommonException{
    
    private static final String CODE = "WRONG";

    public InputWrongException() {
    }

    public InputWrongException(String message) {
        super(message);
    }

    public InputWrongException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "输入 [" + this.getMessage() + "] 错误";
    }
    
    
}
