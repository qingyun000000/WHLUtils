package cn.whl.commonutils.security.strategy;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 工具类：MD5Cypher
 * @author wuhailong
 */
public class MD5Cypher implements CypherStrategory{

    @Override
    public String encrypt(String input){
        StringBuilder hexValue = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(input.getBytes("utf-8"));
            
            for (int i = 0; i < bytes.length; i++) {
                int val = ((int) bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
           
        }
        return hexValue.toString();
    }

    @Override
    public String decrypt(String content) {
        throw new UnsupportedOperationException("MD5不支持解密");
    }
}
