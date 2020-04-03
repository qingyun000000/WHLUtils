package cn.whl.commonutils.exception;

/**
 * 操作不支持异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class TokenWrongException extends CommonException{
    
    private static final String CODE = "TOKENWRONG";

    public TokenWrongException() {
    }

    public TokenWrongException(String message) {
        super(message);
    }

    public TokenWrongException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        return "用户token校验失败";
    }
    
    
}
