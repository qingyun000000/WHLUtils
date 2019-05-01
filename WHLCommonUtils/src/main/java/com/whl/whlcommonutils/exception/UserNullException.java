package com.whl.whlcommonutils.exception;

/**
 * 用户为空异常
 * @author Administrator
 */
public class UserNullException extends Exception{

    public UserNullException() {
    }

    public UserNullException(String message) {
        super(message);
    }

    public UserNullException(Throwable cause) {
        super(cause);
    }
    
}
