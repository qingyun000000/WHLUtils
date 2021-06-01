package cn.whl.commonutils.token;

import cn.whl.commonutils.exception.CommonException;
import cn.whl.commonutils.thread.ThreadCommonArea;

/**
 * 简单token
 * @author wuhailong
 */
public class SimpleLongToken implements Token{
    
    private final static int ENTR = 25011407;
    
    private final static String START  = "TOKEN";

    @Override
    public String createToken(String str) throws Exception{
        ThreadCommonArea.info(str);
        Long id = new Long(str);
        id = id + (1L<<60) + ENTR;
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
        ThreadCommonArea.info(sb.toString());
        return START + sb.toString();
    }

    @Override
    public String decodeToken(String code) throws CommonException{
        code = code.substring(START.length(), code.length()); 
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
        id = id - ENTR - (1L<<60);
        return id + "";
    }

}
