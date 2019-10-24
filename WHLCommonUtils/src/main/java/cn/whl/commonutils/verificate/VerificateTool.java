package cn.whl.commonutils.verificate;

/**
 * 格式校验工具
 * @author wuhailong
 */
public class VerificateTool {
    
    /**
     * 手机号码校验
     * @param str
     * @return
     */
    public static boolean isCellPhone(String str){
        
        return false;
    }
    
    /**
     * 非空字符串校验
     * @param str
     * @return
     */
    public static boolean notEmpty(String str){
        if(str == null || str.trim().length() == 0){
            return false;
        }
        return true;
    }
    
    /**
     * 空字符串校验
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return !notEmpty(str);
    }
    
    /**
     * 数校验
     * @param str
     * @return
     */
    public static boolean isNumber(String str){
       
        return false;
    }
    
    /**
     * 邮箱校验
     * @param str
     * @return
     */
    public static boolean isEmail(String str){
       
        return false;
    }
    
    /**
     * IPv4校验
     * @param str
     * @return
     */
    public static boolean isIPv4(String str){
        
        return false;
    }
    
    /**
     * IPv6校验
     * @param str
     * @return
     */
    public static boolean isIPv6(String str){
       
        return false;
    }
    
    /**
     * 长度校验
     * @param str
     * @param minLength
     * @param maxLength
     * @return
     */
    public static boolean coinLength(String str, int minLength, int maxLength){
        if(str.length() >= minLength && str.length() <= maxLength){
            return true;
        }
        return false;
    }
    
}
