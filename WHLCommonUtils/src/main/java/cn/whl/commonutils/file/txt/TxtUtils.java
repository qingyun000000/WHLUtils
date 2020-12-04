package cn.whl.commonutils.file.txt;

import cn.whl.commonutils.exception.NotExistException;
import cn.whl.commonutils.page.Page;
import com.alibaba.fastjson.JSON;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * txt工具
 * @author wuhailong
 */
public class TxtUtils {
    
    public static <T> List<T> getListByTxtLineJson(String filePath, Class<T> clazz) throws NotExistException, FileNotFoundException, IOException{
        File inputFile = new File(filePath);
        if(!inputFile.exists()){
            throw new NotExistException("文件");
        }
        
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        List<T> lists = new ArrayList<>();
        String s;
        try{
            s = in.readLine();
            while(s != null && s.length() > 0){
                String lineStr = new String(s.getBytes("utf-8"), "utf-8");
                T t = JSON.parseObject(lineStr, clazz);
                lists.add(t);
                s = in.readLine();
            }
        }finally{
            in.close();
        }
        
        return lists;
       
    }
    
    public static void main(String[] args){
        try {
            List<Page> lists = TxtUtils.getListByTxtLineJson("/usr/2.txt", Page.class);
            System.out.println(JSON.toJSONString(lists));
        } catch (NotExistException ex) {
            Logger.getLogger(TxtUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TxtUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
