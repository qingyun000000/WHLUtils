package cn.whl.commonutils.token;

import cn.whl.commonutils.exception.CommonException;

/**
 * 简单token
 * @author wuhailong
 */
public class SimpleToken implements Token{
    
    private final static String START  = "TOKEN";

    @Override
    public String createToken(String str) throws CommonException{
        return START + str;
    }

    @Override
    public String decodeToken(String code) throws CommonException{
        code = code.substring(START.length(), code.length()); 
        return code;
    }

}
