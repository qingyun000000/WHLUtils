package cn.whl.commonutils.sort.method;

import java.util.List;
import cn.whl.commonutils.sort.strag.ISortStrag;

/**
 * 排序方法
 * @author wuhailong
 */
public interface SortMethod {
    
    public <T> void sort(T[] array, ISortStrag<T> strag);
    
    public <T> void sort(List<T> list, ISortStrag<T> strag);
    
}
