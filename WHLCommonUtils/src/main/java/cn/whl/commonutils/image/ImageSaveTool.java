package cn.whl.commonutils.image;

import cn.whl.commonutils.Result;
import cn.whl.commonutils.file.common.FileSaveTool;
import java.io.File;

/**
 * 图片保存工具
 * @author wuhailong
 */
public class ImageSaveTool {
    
    /**
     * 保存图片
     * @param file
     * @param path
     * @param name
     * @return
     */
    public static Result saveImage(File file, String path, String name){
        return FileSaveTool.saveFile(file, path, name);
    }
    
    /**
     * 上传图片到FastDFS
     * @param file
     * @param path
     * @param name
     * @return
     */
    public static Result uploadFileToFastDFS(File file, String path, String name){
        return FileSaveTool.uploadFileToFastDFS(file, path, name);
    }
    
}
