package com.whl.whlcommonutils.exception;

/**
 * 密码错误异常
 * @author Administrator
 */
public class WrongPasswordException extends Exception{

    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException(Throwable cause) {
        super(cause);
    }
    
}
