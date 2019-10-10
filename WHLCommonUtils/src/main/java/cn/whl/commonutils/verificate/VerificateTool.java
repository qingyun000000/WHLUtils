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
    
    
    
}
