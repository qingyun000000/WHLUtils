package cn.whl.commonutils.token;

/**
 * 简单token
 * @author wuhailong
 */
public class SimpleToken implements Token{
    
    private final static String START  = "TOKEN";

    @Override
    public String createToken(String str) throws Exception{
        return START + str;
    }

    @Override
    public String decodeToken(String code) throws Exception{
        code = code.substring(START.length(), code.length()); 
        return code;
    }

}
