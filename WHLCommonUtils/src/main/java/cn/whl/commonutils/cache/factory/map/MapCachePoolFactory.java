package cn.whl.commonutils.cache.factory.map;

import cn.whl.commonutils.cache.factory.CachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import cn.whl.commonutils.cache.pool.map.MapListCachePool;

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
    
    /**
     * 获取Map<String, List>型缓存池
     * @return
     */
    public MapListCachePool getListCachePool();
    
    /**
     * 获取Map<String, List>型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    public <T> MapListCachePool<T> getListCachePool(Class<T> clazz);
    
    /**
     * 获取Map型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    public <T> MapCachePool<T> getCachePool(Class<T> clazz);
}
