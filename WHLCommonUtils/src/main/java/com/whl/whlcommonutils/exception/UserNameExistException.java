package com.whl.whlcommonutils.exception;

/**
 * 用户名已存在（冲突）异常
 * @author Administrator
 */
public class UserNameExistException extends Exception{

    public UserNameExistException() {
    }

    public UserNameExistException(String message) {
        super(message);
    }

    public UserNameExistException(Throwable cause) {
        super(cause);
    }
    
}
