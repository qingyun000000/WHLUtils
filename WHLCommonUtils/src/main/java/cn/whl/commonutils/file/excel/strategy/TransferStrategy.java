package cn.whl.commonutils.file.excel.strategy;

import java.util.List;

/**
 * 列-属性 转换策略
 * @author wuhailong
 */
public interface TransferStrategy {
    
    public List<String> transferToParamList(List<String> columnNames);
    
}
