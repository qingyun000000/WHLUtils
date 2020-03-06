package cn.whl.commonutils.security;

import cn.whl.commonutils.security.strategy.MD5Cypher;
import cn.whl.commonutils.security.strategy.CypherStrategory;

/**
 * 密码工具
 * @author wuhailong
 */
public class CypherTool {
    
    /**
     * 加密
     * @param content
     * @param cypher
     * @return
     */
    public static String encrypt(String content, Cypher cypher){
        if(cypher == Cypher.MD5){
            return new MD5Cypher().encrypt(content);
        }
        return new MD5Cypher().encrypt(content);
    }
    
    /**
     * 判断明文和密文是否一致
     * @param content
     * @param ciphertext
     * @param cypher
     * @return
     */
    public static Boolean equals(String content, String ciphertext, Cypher cypher){
        String ct = "";
        if(cypher == Cypher.MD5){
            ct = new MD5Cypher().encrypt(content);
        }
        return ct.equals(ciphertext);
    }
    
    /**
     * 加密
     * @param content
     * @param cypher
     * @return
     */
    public static String encrypt(String content, CypherStrategory cypher){
        return cypher.decrypt(content);
    }
    
    /**
     * 解密
     * @param content
     * @param cypher
     * @return
     */
    public static String decrypt(String content, CypherStrategory cypher){
        return cypher.decrypt(content);
    }
}
