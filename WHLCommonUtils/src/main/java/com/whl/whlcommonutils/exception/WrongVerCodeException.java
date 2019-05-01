package com.whl.whlcommonutils.exception;

/**
 * 验证码错误异常
 * @author Administrator
 */
public class WrongVerCodeException extends Exception{

    public WrongVerCodeException() {
    }

    public WrongVerCodeException(String message) {
        super(message);
    }

    public WrongVerCodeException(Throwable cause) {
        super(cause);
    }
    
}
