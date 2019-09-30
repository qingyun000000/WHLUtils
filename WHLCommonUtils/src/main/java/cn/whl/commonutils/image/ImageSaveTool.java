package cn.whl.commonutils.image;

import cn.whl.commonutils.Result;
import cn.whl.commonutils.file.FileSaveTool;
import java.io.File;

/**
 * 图片保存工具
 * @author wuhailong
 */
public class ImageSaveTool {
    
    public static Result saveImage(File file, String path, String name){
        return FileSaveTool.saveImage(file, path, name);
    }
    
}
