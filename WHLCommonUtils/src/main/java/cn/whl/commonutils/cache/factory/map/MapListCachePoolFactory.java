package cn.whl.commonutils.cache.factory.map;

import cn.whl.commonutils.cache.factory.CachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import cn.whl.commonutils.cache.pool.map.MapListCachePool;
import cn.whl.commonutils.exception.CommonException;

/**
 * 工厂接口：Map型缓存池工厂
 * @author wuhailong
 */
public interface MapListCachePoolFactory extends CachePoolFactory{
    
    /**
     * 获取Map<String, List>型缓存池
     * @return
     */
    public MapListCachePool getListCachePool();
    
    public <T> MapListCachePool<T> getListCachePool(Class<T> clazz) throws CommonException;
    
}
