package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.factory.map.MapCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import java.util.HashMap;
import java.util.Map;
import cn.whl.commonutils.cache.pool.map.memory.MemoryMapCachePool;

/**
 * 工厂：享元工厂，每个类型生成单例缓存池。
 * 每个类只提供一个缓存池（缓存池唯一, 缓存池时双重判断实现）
 * @author wuhailong
 */
public class SingletonForClassMemoryMapCachePoolFactory implements MapCachePoolFactory{
    
    /**
     * 缓存池集合，缓存池的享元模式容器
     * volatile型变量，多线程及时刷新
     */
    private volatile Map<Class, MemoryMapCachePool> pool = new HashMap<>();
    
    @Override
    public MapCachePool getCachePool() {
        return getCachePool(Object.class);
    }
    
    /**
     * 获取Map型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    @Override
    public <T> MapCachePool<T> getCachePool(Class<T> clazz) {
        MemoryMapCachePool<T> cachePool = pool.get(clazz);
        if(cachePool == null){
            synchronized(SingletonForClassMemoryMapCachePoolFactory.class){     //同步块
                if(cachePool == null){                                          //双重判断
                    cachePool = new MemoryMapCachePool<>(); 
                    pool.put(clazz, cachePool);
                }
            }
        }
        return cachePool;
    }
    
}
