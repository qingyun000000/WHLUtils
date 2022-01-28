package cn.whl.commonutils.file.excel;

import cn.whl.commonutils.exception.CommonException;
import cn.whl.commonutils.file.excel.strategy.DefaultTransferStrategy;
import cn.whl.commonutils.file.excel.strategy.MapTransferStrategy;
import cn.whl.commonutils.file.excel.strategy.TransferStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 *
 * @author wuhailong
 */
public class XLS implements Excel{

    @Override
    public <T> List<T> read(InputStream inputStream, int sheetPage, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException{
        return read(inputStream, sheetPage, new DefaultTransferStrategy(), clazz);
    }
    
    @Override
    public <T> List<T> read(InputStream inputStream, int sheetPage, Map<String, String> transferMap, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException{
        return read(inputStream, sheetPage, new MapTransferStrategy(transferMap), clazz);
    }
    
    @Override
    public <T> List<T> read(InputStream inputStream, int sheetPage, TransferStrategy transferStrategy, Class<T> clazz) throws InstantiationException, IllegalAccessException, IOException, CommonException{
        //工作簿
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        
        //sheet页
        HSSFSheet sheet = workbook.getSheetAt(sheetPage);
        
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

    private <T> List<T> getObjectList(HSSFSheet sheet, Class<T> clazz, List<String> paramNames) throws InstantiationException, IllegalAccessException {
        //返回值初始化
        List<T> result = new ArrayList<>();
        
        //行对象和对应的map对象变量复用
        HSSFRow row = null;
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

    private List<String> getColumnNameList(HSSFSheet sheet) {
        List<String> columnNames = new ArrayList<>();
        HSSFRow row = sheet.getRow(0);
        for(Cell cell : row) {
            String columnName = cell.getStringCellValue();
            columnNames.add(columnName);
        }
        return columnNames;
    }
    
    @Override
    public <T> void write(OutputStream OutputStream, List<T> list, String sheetName) throws IllegalAccessException, InvocationTargetException, IOException {
        //生成空转换器
        Map<String, String> transferMap = new HashMap<>();
        
        write(OutputStream, list, sheetName, transferMap);
    }

    @Override
    public <T> void write(OutputStream outputStream, List<T> list, String sheetName, Map<String, String> transferMap) throws IllegalAccessException, InvocationTargetException, IOException {
        //工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        
        //sheet页
        HSSFSheet sheet = workbook.createSheet(sheetName);
        
        //类名转列名
        T obj1 = list.get(0);
        Field[] fields = obj1.getClass().getDeclaredFields();
        List<String> columnNames = new ArrayList<>();
        List<String> paramNames = new ArrayList<>();   //参数名，与map对应，保存类型
        for(Field field : fields){
            String name = field.getName();
            if(transferMap.get(name) != null){      //有转换关系，使用转换后的列名
                columnNames.add(transferMap.get(name));
            }else{                                  //无转换关系，直接写属性名
                columnNames.add(name);
            }
            paramNames.add(name);
        }
        
        //写列名（标题栏）
        writeColumnNameList(sheet, columnNames);
        
        //对象转换为行内容
        writeObjectList(sheet, list, paramNames);
        
        workbook.write(outputStream);
    }
    
    private void writeColumnNameList(HSSFSheet sheet,  List<String> columnNames) {
        HSSFCellStyle titleStyle = buildTitleStyle(sheet);
        HSSFRow row = sheet.createRow(0);
        int j = 0;
        for (String columnName : columnNames) {
            HSSFCell cell = row.createCell(j, CellType.STRING);
            cell.setCellStyle(titleStyle);
            cell.setCellValue(columnName);
            j++;
        }
    }
    
    private HSSFCellStyle buildTitleStyle(HSSFSheet sheet){
        HSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直对齐
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN); //左边框
        cellStyle.setBorderRight(BorderStyle.THIN); //右边框
        cellStyle.setBorderTop(BorderStyle.THIN); //上边
        HSSFFont headerFont = (HSSFFont) sheet.getWorkbook().createFont(); // 创建字体样式
        headerFont.setBold(true); //字体加粗
        headerFont.setFontName("仿宋"); // 设置字体类型
        headerFont.setFontHeightInPoints((short) 15); // 设置字体大小
        cellStyle.setFont(headerFont); // 为标题样式设置字体样式
        return cellStyle;
    }
    
    private <T> void writeObjectList(HSSFSheet sheet, List<T> list, List<String> paramNames) throws IllegalAccessException, InvocationTargetException {
        HSSFCellStyle columnStyle = buildColumStyle(sheet);
        Map<String, Object> map = null;
        int i =1;
        for(T obj : list){
            HSSFRow row = sheet.createRow(i);
            int j = 0;
            for (String paramName : paramNames) {
                HSSFCell cell = row.createCell(j);
                cell.setCellStyle(columnStyle);
                
                Object value = null;
                try {
                    Class<?> clazz = obj.getClass();
                    Field field = clazz.getDeclaredField(paramName);
                    field.setAccessible(true);
                    value = field.get(obj);
                } catch (NoSuchFieldException | SecurityException ex) {
                    Logger.getLogger(XLS.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(value instanceof Number){
                    System.out.println("Double:" + value);
                    cell.setCellType(CellType.NUMERIC);
                    Double value1 = new Double(value + "");
                    cell.setCellValue(value1);
                }else {
                    System.out.println("String:" + value);
                    cell.setCellType(CellType.STRING);
                    if(value != null){
                        cell.setCellValue(value.toString());
                    }
                }
                
                
                j++;
            }
            i++;
        }
    }

    private HSSFCellStyle buildColumStyle(HSSFSheet sheet) {
        HSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.LEFT);//水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直对齐
        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
        cellStyle.setBorderLeft(BorderStyle.THIN); //左边框
        cellStyle.setBorderRight(BorderStyle.THIN); //右边框
        cellStyle.setBorderTop(BorderStyle.THIN); //上边
        HSSFFont headerFont = (HSSFFont) sheet.getWorkbook().createFont(); // 创建字体样式
        headerFont.setBold(false); //字体加粗
        headerFont.setFontName("仿宋"); // 设置字体类型
        headerFont.setFontHeightInPoints((short) 11); // 设置字体大小
        cellStyle.setFont(headerFont); // 为标题样式设置字体样式
        return cellStyle;
    }

    

    
    
    
}
