package cn.whl.commonutils.file.image;

import cn.whl.commonutils.Result;
import cn.whl.commonutils.file.common.FileSaveUtils;
import java.io.File;

/**
 * 图片保存工具
 * @author wuhailong
 */
public class ImageSaveUtils {
    
    /**
     * 保存图片
     * @param file
     * @param path
     * @param name
     * @return
     */
    public static Result saveImage(byte[] file, String path, String name){
        return FileSaveUtils.saveFile(file, path, name);
    }
    
    /**
     * 上传图片到FastDFS
     * @param file
     * @param path
     * @param name
     * @return
     */
    public static Result uploadFileToFastDFS(byte[] file, String path, String name){
        return FileSaveUtils.uploadFileToFastDFS(file, path, name);
    }
    
}
