package cn.whl.commonutils.token;

/**
 * Token工具
 * @author wuhailong
 */
public class TokenTool {
    
    public static String createToken(String id) throws Exception{
        return createToken(id, new SimpleToken());
    }
    
    public static String decodeToken(String code) throws Exception{
        return decodeToken(code, new SimpleToken());
    }
    
    public static String createToken(String id, Token token) throws Exception{
        return token.createToken(id);
    }
    
    public static String decodeToken(String code, Token token) throws Exception{
        return token.decodeToken(code);
    }
    
}
