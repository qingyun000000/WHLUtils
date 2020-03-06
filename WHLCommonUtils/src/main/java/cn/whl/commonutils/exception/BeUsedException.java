package cn.whl.commonutils.exception;

/**
 * 输入错误异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class BeUsedException extends CommonException{
    
    private static final String CODE = "BEUSEDWRONG";

    public BeUsedException() {
    }

    public BeUsedException(String message) {
        super(message);
    }

    public BeUsedException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return " [" + this.getMessage() + "] 已经被使用";
    }
    
    
}
