package cn.whl.commonutils.exception;

import cn.whl.commonutils.verificate.VerificateUtils;

/**
 * 输入格式校验错误异常
 * @createTime 2019-12-05
 * @updateTime 2019-12-05
 * @author wuhailong
 */
public class InputVerWrongException extends CommonException{
    
    private static final String CODE = "VERWRONG";
    
    private String param;
    
    private String input;
    
    private String msg;

    public InputVerWrongException() {
    }

    public InputVerWrongException(String message) {
        super(message);
    }
    
    public InputVerWrongException(String param, String input, String msg) {
        this.param = param;
        this.input = input;
        this.msg = msg;
    }

    public InputVerWrongException(Throwable cause) {
        super(cause);
    }
    
    @Override
    public String getCODE() {
        return CODE;
    }
    
    @Override
    public String exceptionOut(){
        if(VerificateUtils.notEmpty(param)){
            return "输入 [" + this.getParam() + ":" + this.getInput() + "] 格式校验错误, 正确格式为 [" + this.getMsg() + "]";
        }else{
            return "输入格式校验错误 [" + this.getMessage() + "] ";
        }
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
