package cn.whl.commonutils.token;

import cn.whl.commonutils.exception.CommonException;

/**
 * Token工具
 * @author wuhailong
 */
public class TokenUtils {
    
    public static String createToken(String id) throws Exception{
        return createToken(id, new SimpleToken());
    }
    
    public static String decodeToken(String code) throws CommonException{
        return decodeToken(code, new SimpleToken());
    }
    
    public static String createToken(String id, Token token) throws Exception{
        return token.createToken(id);
    }
    
    public static String decodeToken(String code, Token token) throws CommonException{
        return token.decodeToken(code);
    }
    
}
