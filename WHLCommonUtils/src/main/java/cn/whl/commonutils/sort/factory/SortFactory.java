package cn.whl.commonutils.sort.factory;

import cn.whl.commonutils.sort.method.SortMethod;

/**
 * 排序方法工厂
 * @author wuhailong
 */
public interface SortFactory {
    
    public SortMethod createSortMethod();
    
}
