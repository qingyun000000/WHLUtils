package cn.whl.commonutils.exception;

/**
 * 输入错误异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class InputNullException extends CommonException{
    
    private static final String CODE = "INPUTNULL";

    public InputNullException() {
    }

    public InputNullException(String message) {
        super(message);
    }

    public InputNullException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "输入 [" + this.getMessage() + "] 为空值";
    }
    
    
}
