package cn.whl.commonutils.file.excel;

import cn.whl.commonutils.exception.CommonException;
import cn.whl.commonutils.file.excel.strategy.TransferStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wuhailong
 */
public interface Excel {

    public <T> List<T> read(InputStream inputStream, int sheetPage, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException;
    
    public <T> List<T> read(InputStream inputStream, int sheetPage, Map<String, String> transferMap, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException;
    
    public <T> List<T> read(InputStream inputStream, int sheetPage, TransferStrategy transferStrategy, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException;
    
    public <T> void write(OutputStream outputStream, List<T> list, String sheetName) throws IllegalAccessException, InvocationTargetException, IOException;
    
    public <T> void write(OutputStream outputStream, List<T> list, String sheetName, Map<String, String> transferMap) throws IllegalAccessException, InvocationTargetException, IOException;
    
}
