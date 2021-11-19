package cn.whl.commonutils.token;

import cn.whl.commonutils.exception.CommonException;

/**
 * token
 * @author wuhailong
 */
public interface Token {
    
    public String createToken(String str) throws CommonException;
    
    public String decodeToken(String token) throws CommonException;
    
}
