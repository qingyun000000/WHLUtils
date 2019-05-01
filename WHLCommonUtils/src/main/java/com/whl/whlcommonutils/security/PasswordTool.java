package com.whl.whlcommonutils.security;

/**
 * 工具类：密码
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-4-12
 * @updateTime 2019-5-1
 */
public class PasswordTool {
    
    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String Encrypt(String password){
        return MD5.MD5Encrypt(password);
    }
    
    /**
     * 判断明文和密码是否一致
     * @param password
     * @param ciphertext
     * @return
     */
    public static Boolean Equals(String password, String ciphertext){
        String md5 = MD5.MD5Encrypt(password);
        if(md5.equals(ciphertext)){
             return true;
        }
        return false;
    }
}
