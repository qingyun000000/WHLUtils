package cn.whl.commonutils.file.common;

import cn.whl.commonutils.Result;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 文件保存工具
 * @author wuhailong
 */
public class FileSaveUtils {
    
    /**
     * 保存文件
     * @param file
     * @param path
     * @param name
     * @return
     */
    public static Result saveFile(byte[] file, String path, String name){
        Result result = new Result();
        
        File filePath = new File(path + "/");
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        
        //二进制流写入
        
        try (FileOutputStream out = new FileOutputStream(path + "/" + name)){
            out.write(file);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(FileSaveUtils.class.getName()).log(Level.SEVERE, null, ex);
            result.setSuccess(false);
            result.setMessage(ex.getMessage());
        }
        
        result.setSuccess(true);
        result.setMessage(path + "/" + name);
        
        return result;
    }
    
    /**
     * 上传文件到FastDFS
     * @param file
     * @param path
     * @param name
     * @return
     */
    public static Result uploadFileToFastDFS(byte[] file, String path, String name){
        Result result = new Result();
        
        return result;
    }
}
