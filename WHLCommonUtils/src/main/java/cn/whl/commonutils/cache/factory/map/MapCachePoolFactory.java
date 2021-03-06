package cn.whl.commonutils.cache.factory.map;

import cn.whl.commonutils.cache.factory.CachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import cn.whl.commonutils.cache.pool.map.MapListCachePool;
import cn.whl.commonutils.exception.CommonException;

/**
 * 工厂接口：Map型缓存池工厂
 * @author wuhailong
 */
public interface MapCachePoolFactory extends CachePoolFactory{
    
    /**
     * 获取Map型缓存池
     * @return
     */
    public MapCachePool getCachePool();
    
    public <T> MapCachePool<T> getCachePool(Class<T> clazz) throws CommonException;
    
}
