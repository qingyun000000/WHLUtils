package cn.whl.commonutils.file.excel.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 默认转换策略 ： 直接对应
 * @author wuhailong
 */
public class DefaultTransferStrategy implements TransferStrategy{

    @Override
    public List<String> transferToParamList(List<String> columnNames) {
        List<String> paramsNames = new ArrayList<>();   //参数名
        for(String columnName : columnNames){          //使用列名，会按照列名匹配类属性名
            paramsNames.add(columnName);
        }
        return paramsNames;
    }
    
    
    
}
