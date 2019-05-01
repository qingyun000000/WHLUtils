package com.whl.whlcommonutils.exception;

/**
 * 手机号已存在（冲突）异常
 * @author Administrator
 */
public class CellPhoneExistException extends Exception{

    public CellPhoneExistException() {
    }

    public CellPhoneExistException(String message) {
        super(message);
    }

    public CellPhoneExistException(Throwable cause) {
        super(cause);
    }
    
}
