package cn.whl.commonutils.file.excel;

import cn.whl.commonutils.exception.CommonException;
import cn.whl.commonutils.file.excel.strategy.DefaultTransferStrategy;
import cn.whl.commonutils.file.excel.strategy.MapTransferStrategy;
import cn.whl.commonutils.file.excel.strategy.TransferStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author wuhailong
 */
public class XLSX implements Excel{

    @Override
    public <T> List<T> read(InputStream inputStream, int sheetPage, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException {
        return read(inputStream, sheetPage, new DefaultTransferStrategy(), clazz);
    }

    @Override
    public <T> List<T> read(InputStream inputStream, int sheetPage, Map<String, String> transferMap, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException {
        return read(inputStream, sheetPage, new MapTransferStrategy(transferMap), clazz);
    }
    
    @Override
    public <T> List<T> read(InputStream inputStream, int sheetPage, TransferStrategy transferStrategy, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException {
        //工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        
        //sheet页
        XSSFSheet sheet = workbook.getSheetAt(sheetPage);
        
        //获取列名
        List<String> columnNames = getColumnNameList(sheet);
        
        //获取属性名
        List<String> paramsNames = transferStrategy.transferToParamList(columnNames);
        
        if(paramsNames.size() != columnNames.size()){
            throw new CommonException("类属性和列名长度不一致");
        }
        
        //行内容转换为对象
        List<T> result = getObjectList(sheet, clazz, paramsNames);
        
        return result;
    }
    
    private <T> List<T> getObjectList(XSSFSheet sheet, Class<T> clazz, List<String> paramNames) throws InstantiationException, IllegalAccessException {
        //返回值初始化
        List<T> result = new ArrayList<>();
        
        //行对象和对应的map对象变量复用
        XSSFRow row = null;
        Map<String, Object> map = null;
        
        //每行读取
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            //对象初始化或者获取
            map = new HashMap<>();
            row = sheet.getRow(i);
            
            //实体对象返回，不能复用
            T t = clazz.newInstance();
            
            //读取单元格，放入map
            int j = 0;
            for(Cell cell : row) {
                Object cellContent = getCellContent(cell);
                map.put(paramNames.get(j), cellContent);
                j++;
            }
            
            //map对象转对象
            try {
                //BeanUtils.copyProperties(t, map);
                BeanUtils.populate(t, map);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(XLS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //放入返回列表
            result.add(t);
        }
        
        return result;
    }

    private Object getCellContent(Cell cell) {
        Object cellContent = null;
        
        CellType cellType = cell.getCellType();
        if(cellType == CellType.BOOLEAN){
            cellContent= cell.getBooleanCellValue();
        }else if(cellType == CellType.NUMERIC){
            //先看是否是日期格式
            if (DateUtil.isCellDateFormatted(cell)) {
                //读取日期格式
                cellContent= cell.getDateCellValue();
                
            } else {
                //读取数字
                cellContent = cell.getNumericCellValue();
                
            }
        }else if(cellType == CellType.FORMULA){
            cellContent = cell.getCellFormula();
        }else if(cellType == CellType.STRING){
            cellContent = cell.getStringCellValue();
        }else if(cellType == CellType.ERROR){
            
        }else if(cellType == CellType._NONE){
            
        }else if(cellType == CellType.BLANK){
            cellContent = null;
        }else {
            cellContent = null;
        }
        return cellContent;
    }

    private List<String> getColumnNameList(XSSFSheet sheet) {
        List<String> columnNames = new ArrayList<>();
        XSSFRow row = sheet.getRow(0);
        for(Cell cell : row) {
            String columnName = cell.getStringCellValue();
            columnNames.add(columnName);
        }
        return columnNames;
    }

    @Override
    public <T> void write(OutputStream outputStream, List<T> list, String sheetName) throws IllegalAccessException, InvocationTargetException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> void write(OutputStream outputStream, List<T> list, String sheetName, Map<String, String> transferMap) throws IllegalAccessException, InvocationTargetException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
