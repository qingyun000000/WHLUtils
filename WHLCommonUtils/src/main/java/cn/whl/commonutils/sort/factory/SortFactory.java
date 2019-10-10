package cn.whl.commonutils.sort.factory;

import cn.whl.commonutils.sort.method.SortMethod;

/**
 * 排序方法工厂
 * @author wuhailong
 */
public interface SortFactory {
    
    /**
     * 生成排序方法
     * @return 
     */
    public SortMethod createSortMethod();
    
}
