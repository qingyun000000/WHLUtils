package com.whl.whlcommonutils.exception;

/**
 * 错误用户异常
 * @author Administrator
 */
public class WrongUserException extends Exception{

    public WrongUserException() {
    }

    public WrongUserException(String message) {
        super(message);
    }

    public WrongUserException(Throwable cause) {
        super(cause);
    }
    
}
