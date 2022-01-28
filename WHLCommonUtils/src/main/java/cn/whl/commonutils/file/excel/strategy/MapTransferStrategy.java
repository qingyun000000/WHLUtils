package cn.whl.commonutils.file.excel.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 转换策略 ： Map
 * @author wuhailong
 */
public class MapTransferStrategy implements TransferStrategy{
    
    private Map<String, String> map;

    public MapTransferStrategy(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public List<String> transferToParamList(List<String> columnNames) {
        List<String> paramsNames = new ArrayList<>();   //参数名
        for(String columnName : columnNames){          
            if(map.containsKey(columnName)){
                paramsNames.add(map.get(columnName));   //使用map转换值
            } else{
                paramsNames.add(columnName);            //使用列名，会按照列名匹配类属性名
            }
        }
        return paramsNames;
    }
    
    
    
}
