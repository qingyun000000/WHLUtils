package cn.whl.commonutils.sort.method;

import java.util.List;
import cn.whl.commonutils.sort.strategy.ISortStrategy;

/**
 * 排序方法
 * @author wuhailong
 */
public interface SortMethod {
    
    public <T> void sort(T[] array, ISortStrategy<T> strag);
    
    public <T> void sort(List<T> list, ISortStrategy<T> strag);
    
}
