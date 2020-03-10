package cn.whl.commonutils.exception;

/**
 * 操作不支持异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class ActionUnsupportedException extends CommonException{
    
    private static final String CODE = "UNSUPPORTED";

    public ActionUnsupportedException() {
    }

    public ActionUnsupportedException(String message) {
        super(message);
    }

    public ActionUnsupportedException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "不支持 [" + this.getMessage() + "] 操作";
    }
    
    
}
