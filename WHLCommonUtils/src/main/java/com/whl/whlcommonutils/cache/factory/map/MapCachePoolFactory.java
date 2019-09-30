package com.whl.whlcommonutils.cache.factory.map;

import com.whl.whlcommonutils.cache.pool.map.MapCachePool;

/**
 * 工厂接口：生产Map型缓存池
 * @author wuhailong
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
