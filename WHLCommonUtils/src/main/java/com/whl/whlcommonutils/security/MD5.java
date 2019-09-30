package com.whl.whlcommonutils.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 工具类：MD5
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-4-12
 * @updateTime 2019-5-1
 */
public class MD5 {
    public static String MD5Encrypt(String input){
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
}
