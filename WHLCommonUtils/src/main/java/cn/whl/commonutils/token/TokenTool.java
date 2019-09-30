package cn.whl.commonutils.token;

/**
 * Token工具
 * @author wuhailong
 */
public class TokenTool {
    
    public static String createToken(Long id){
        id = id + (1L<<60) + 25011407;
        StringBuilder sb = new StringBuilder();
        int basic = 65;
        while(id != 0){
            sb.append((char)((id & 1) + basic));
            id = id >> 1;
            basic++;
            if(basic == 91){
                basic = 65;
            }
        }
        return "TOKEN" + sb.toString();
    }
    
    public static long decodeToken(String code){
        code = code.substring(5, code.length()); 
        int basic = 73;
        long id = 0;
        for(int i = code.length() - 1; i >= 0; i--){
            id += ((int)code.charAt(i) - basic);
            id = id << 1;
            basic--;
            if(basic == 64){
                basic = 90;
            }
        }
        id = id >> 1;
        return id - 25011407 - (1L<<60);
    }
    
}
