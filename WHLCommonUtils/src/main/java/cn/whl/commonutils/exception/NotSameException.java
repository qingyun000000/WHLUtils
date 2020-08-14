package cn.whl.commonutils.exception;

import cn.whl.commonutils.verificate.VerificateUtils;

/**
 * 不仙童异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class NotSameException extends CommonException{
    
    private static final String CODE = "NSAME";
    
    private String message1;
    
    private String message2;

    public NotSameException() {
    }

    public NotSameException(String message) {
        super(message);
    }
    
    public NotSameException(String message1, String message2) {
        this.message1 = message1;
        this.message2 = message2;
    }
    

    public NotSameException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        if(VerificateUtils.notEmpty(message1)){
            return "[" + this.getMessage1()+ "与" + this.getMessage2()+ "]不一致";
        }else{
            return "输入错误 [" + this.getMessage() + "] ";
        }
    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
    
    
}
