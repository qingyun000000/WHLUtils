package cn.whl.commonutils.exception;

/**
 * 远程服务运行异常 : 错误码穿透
 * @createTime 2019-11-29
 * @updateTime 2019-11-29
 * @author wuhailong
 */
public class RemoteServiceRunException extends CommonException{
    
    private String code;
    
    private String message; 

    public RemoteServiceRunException() {
    }

    public RemoteServiceRunException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RemoteServiceRunException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getCODE() {
        return code;
    }
    
    @Override
    public String exceptionOut(){
        return message;
    }
    
}
