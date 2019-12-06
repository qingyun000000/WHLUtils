package cn.whl.commonutils.exception;

/**
 * 消息型异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class MSGException extends CommonException{
    
    private static final String CODE = "MSG";

    public MSGException() {
    }

    public MSGException(String message) {
        super(message);
    }

    public MSGException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "异常消息 [" + this.getMessage() + "]";
    }
    
    
}
