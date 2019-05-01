package com.whl.whlcommonutils.exception;

/**
 * 手机号用户为空异常
 * @author Administrator
 */
public class CellPhoneNullException extends Exception{

    public CellPhoneNullException() {
    }

    public CellPhoneNullException(String message) {
        super(message);
    }

    public CellPhoneNullException(Throwable cause) {
        super(cause);
    }
    
}
