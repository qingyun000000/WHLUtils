package com.whl.whlcommonutils.security;

/**
 * 工具类：密码
 * @author wuhailong
 */
public class PasswordTool {
    
    /**
     * 密码加密
     * @param password
     * @param cypher
     * @return
     */
    public static String Encrypt(String password, Cypher cypher){
        if(cypher == Cypher.MD5){
            return MD5.MD5Encrypt(password);
        }
        return MD5.MD5Encrypt(password);
    }
    
    /**
     * 判断明文和密码是否一致
     * @param password
     * @param ciphertext
     * @return
     */
    public static Boolean Equals(String password, String ciphertext, Cypher cypher){
        String ct = "";
        if(cypher == Cypher.MD5){
            ct = MD5.MD5Encrypt(password);
        }
        if(ct.equals(ciphertext)){
             return true;
        }
        return false;
    }
}
