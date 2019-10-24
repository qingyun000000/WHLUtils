package cn.whl.commonutils.token;

/**
 * 简单token
 * @author wuhailong
 */
public class SimpleToken implements Token{
    
    private final static int ENTR = 25011407;
    
    private final static String START  = "TOKEN";

    @Override
    public String createToken(Long id) {
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
        return START + sb.toString();
    }

    @Override
    public long decodeToken(String code) {
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
        return id - ENTR - (1L<<60);
    }
    
    

}
