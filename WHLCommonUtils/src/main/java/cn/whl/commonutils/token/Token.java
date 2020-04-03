package cn.whl.commonutils.token;

/**
 * token
 * @author wuhailong
 */
public interface Token {
    
    public String createToken(String str) throws Exception;
    
    public String decodeToken(String token) throws Exception;
    
}
