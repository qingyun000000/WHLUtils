package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.pool.map.memory.MemoryMapCachePool;
import cn.whl.commonutils.cache.factory.map.MapCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;

/**
 * 工厂：生成缓存池。
 * @author wuhailong
 */
public class SimpleMemoryMapCachePoolFactory implements MapCachePoolFactory{
    
    /**
     * 获取Map型缓存池
     * @return
     */
    public MapCachePool<Object> getCachePool(){
        return new MemoryMapCachePool<>(); 
    }
    
    /**
     * 获取Map型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    @Override
    public <T> MapCachePool<T> getCachePool(Class<T> clazz){
        return new MemoryMapCachePool<>(); 
    }
    
}
