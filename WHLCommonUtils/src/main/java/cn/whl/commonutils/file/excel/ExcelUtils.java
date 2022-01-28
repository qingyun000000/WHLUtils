package cn.whl.commonutils.file.excel;

import cn.whl.commonutils.exception.CommonException;
import cn.whl.commonutils.file.excel.enums.ExcelFileType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * xls和xlsx工具
 * @author wuhailong
 */
public class ExcelUtils {
    
    private static final Excel XLS = new XLS();
    
    private static final Excel XLSX = new XLSX();
    
    public static <T> List<T> read(String path, int sheetPage, Class<T> clazz) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException, CommonException{
        File file = new File(path);
        return read(file, sheetPage, clazz);
    }
    
    public static <T> List<T> read(File file, int sheetPage, Class<T> clazz) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException, CommonException{
        InputStream inputStream = new FileInputStream(file);
        
        List<T> result = null;
        if(file.getName().endsWith("xls")){
            result = read(ExcelFileType.XLS, inputStream, sheetPage, clazz);
        }else if(file.getName().endsWith("xlsx")){
            result = read(ExcelFileType.XLSX, inputStream, sheetPage, clazz);
        }
        return result;
    }
    
    public static <T> List<T> read(ExcelFileType type, InputStream inputStream, int sheetPage, Class<T> clazz) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException, CommonException{
        List<T> result = null;
        if(type == ExcelFileType.XLS){
            result = XLS.read(inputStream, sheetPage, clazz);
        }else if(type == ExcelFileType.XLSX){
            result = XLSX.read(inputStream, sheetPage, clazz);
        }
        return result;
    }
    
    
    
    public static <T> void write(String path, OutputStream outputStream, List<T> list, String sheetName) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException{
        File file = new File(path);
        write(file, list, sheetName);
    }
    
    public static <T> void write(File file, List<T> list, String sheetName) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException{
        
        OutputStream outputStream = new FileOutputStream(file);
        
        if(file.getName().endsWith("xls")){
            write(ExcelFileType.XLS, outputStream, list, sheetName);
        }else if(file.getName().endsWith("xlsx")){
            write(ExcelFileType.XLSX, outputStream, list, sheetName);
        }
    }
    
    public static <T> void write(ExcelFileType type, OutputStream outputStream, List<T> list, String sheetName) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException{
        
        if(type == ExcelFileType.XLS){
            XLS.write(outputStream, list, sheetName);
        }else if(type == ExcelFileType.XLSX){
            XLSX.write(outputStream, list, sheetName);
        }
        
        outputStream.flush();
    }
    
    public static void main(String[] args) throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalAccessException, IllegalAccessException, IOException, InvocationTargetException {
        
        FileOutputStream outputStream = new FileOutputStream("/usr/test" + new Random().nextInt(1000) + ".xls");
        List<File> list = new ArrayList<>();
        list.add(new File("/usr/book.xls"));
        write(ExcelFileType.XLS, outputStream, list, "可一个");
    }
    
           
    


}
