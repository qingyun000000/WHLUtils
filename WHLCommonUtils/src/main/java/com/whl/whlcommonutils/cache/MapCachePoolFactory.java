package com.whl.whlcommonutils.cache;

/**
 * 工厂接口：生产Map型缓存池
 * @author wuhailong
 * @version 0.0.1
 * @createTime 2019-4-7
 * @updateTime 2019-4-16
 */
/*
* 0.0.1版本，初始化版本，从SingletonforClassMemoryMapCachePoolFactory中提取接口
*/
public interface MapCachePoolFactory {
    
    /**
     * 获取Map型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    public <T> MapCachePool<T> getCachePool(Class<T> clazz);
}
