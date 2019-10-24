package cn.whl.commonutils.token;

/**
 * Token工具
 * @author wuhailong
 */
public class TokenTool {
    
    public static String createToken(Long id){
        return createToken(id, new SimpleToken());
    }
    
    public static long decodeToken(String code){
        return decodeToken(code, new SimpleToken());
    }
    
    public static String createToken(Long id, Token token){
        return token.createToken(id);
    }
    
    public static long decodeToken(String code, Token token){
        return token.decodeToken(code);
    }
    
}
