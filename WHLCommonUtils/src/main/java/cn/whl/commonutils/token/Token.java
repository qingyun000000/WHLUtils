package cn.whl.commonutils.token;

/**
 * token
 * @author wuhailong
 */
public interface Token {
    
    public String createToken(Long id);
    
    public long decodeToken(String code);
    
}
