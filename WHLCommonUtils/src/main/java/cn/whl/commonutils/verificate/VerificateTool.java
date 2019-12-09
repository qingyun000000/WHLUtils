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
        if(str == null || str.trim().length() == 0){
            return false;
        }
        String phone;
        if(str.startsWith("+86")){
            phone = str.substring(3);
        }else if(str.startsWith("86")){
            phone = str.substring(2);
        }else{
            phone = str;
        }
        if(!phone.startsWith("13") && !phone.startsWith("15") && !phone.startsWith("17") && !phone.startsWith("18")){
            return false;
        }else if(phone.matches("[1-9]{2}[0-9]{9}")){
            return true;
        }
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
        if(str == null || str.trim().length() == 0){
            return false;
        }
        if(str.matches("[0-9]+(.[0-9]+)")){
            return true;
        }
        return false;
    }
    
    /**
     * 整数校验
     * @param str
     * @return
     */
    public static boolean isInt(String str){
        if(str == null || str.trim().length() == 0){
            return false;
        }
        if(str.matches("[0-9]+")){
            return true;
        }
        return false;
    }
    
    /**
     * 邮箱校验
     * @param str
     * @return
     */
    public static boolean isEmail(String str){
        if(str == null || str.trim().length() == 0){
            return false;
        }
        if(str.matches("[A-Za-z0-9_]+@[A-Za-z0-9]+\\.[A-Za-z]+")){
            return true;
        }
        return false;
    }
    
    /**
     * IPv4校验
     * @param str
     * @return
     */
    public static boolean isIPv4(String str){
        if(str == null || str.trim().length() == 0){
            return false;
        }
        if(str.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}")){
            return true;
        }
        return false;
    }
    
    /**
     * IPv6校验
     * @param str
     * @return
     */
    public static boolean isIPv6(String str){
        if(str == null || str.trim().length() == 0){
            return false;
        }
       
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
        if(str == null || str.trim().length() == 0 ){
            return false;
        }
        if(str.length() >= minLength && str.length() <= maxLength){
            return true;
        }
        return false;
    }
    
    public static boolean existAndGreaterThanZero(Long num){
        if(num != null && num > 0 ){
            return true;
        }
        return false;
    }
    
}
