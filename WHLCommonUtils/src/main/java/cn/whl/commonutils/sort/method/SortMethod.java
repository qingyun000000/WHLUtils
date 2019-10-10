package cn.whl.commonutils.sort.method;

import java.util.List;
import cn.whl.commonutils.sort.strategy.ISortStrategy;

/**
 * 排序方法
 * @author wuhailong
 */
public interface SortMethod {
    
    /**
     * 对数组进行排序
     * @param <T>
     * @param array
     * @param strag 
     */
    public <T> void sort(T[] array, ISortStrategy<T> strag);
    
    /**
     * 对列表进行排序
     * @param <T>
     * @param list
     * @param strag 
     */
    public <T> void sort(List<T> list, ISortStrategy<T> strag);
    
}
