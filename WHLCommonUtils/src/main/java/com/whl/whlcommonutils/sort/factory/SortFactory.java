package com.whl.whlcommonutils.sort.factory;

import com.whl.whlcommonutils.sort.method.SortMethod;

/**
 * 排序方法工厂
 * @author wuhailong
 */
public interface SortFactory {
    
    public SortMethod createSortMethod();
    
}
