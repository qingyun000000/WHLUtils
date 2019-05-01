package com.whl.whlcommonutils.exception;

/**
 * 发送短信验证码失败异常
 * @author Administrator
 */
public class SendSMSFailException extends Exception{

    public SendSMSFailException() {
    }

    public SendSMSFailException(String message) {
        super(message);
    }

    public SendSMSFailException(Throwable cause) {
        super(cause);
    }
    
}
