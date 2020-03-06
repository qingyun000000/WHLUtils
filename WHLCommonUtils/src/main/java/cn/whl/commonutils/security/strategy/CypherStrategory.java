package cn.whl.commonutils.security.strategy;

/**
 * 密码策略
 * @author wuhailong
 */
public interface CypherStrategory {
    
    public String encrypt(String input);
    
    public String decrypt(String input);
}
