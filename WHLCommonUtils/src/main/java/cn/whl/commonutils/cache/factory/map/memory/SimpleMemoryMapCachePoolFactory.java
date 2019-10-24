package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.pool.map.memory.MemoryMapListCachePool;
import cn.whl.commonutils.cache.factory.map.MapCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import cn.whl.commonutils.cache.pool.map.MapListCachePool;
import cn.whl.commonutils.cache.pool.map.memory.MemoryMapCachePool;

/**
 * 工厂：生成缓存池。
 * @author wuhailong
 */
public class SimpleMemoryMapCachePoolFactory implements MapCachePoolFactory{
    
    /**
     * 获取Map型缓存池
     * @return
     */
    @Override
    public MapCachePool getCachePool(){
        return new MemoryMapCachePool<>(); 
    }
    
    @Override
    public MapListCachePool getListCachePool() {
        return new MemoryMapListCachePool<>();
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

    /**
     * 获取Map<String， List>型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    @Override
    public <T> MapListCachePool<T> getListCachePool(Class<T> clazz) {
        return new MemoryMapListCachePool<>(); 
    }

    
    
}
