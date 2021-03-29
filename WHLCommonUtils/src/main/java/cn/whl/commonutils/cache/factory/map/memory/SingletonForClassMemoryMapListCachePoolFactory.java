package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.pool.map.memory.MemoryMapListCachePool;
import cn.whl.commonutils.cache.factory.map.MapListCachePoolFactory;
import java.util.HashMap;
import java.util.Map;
import cn.whl.commonutils.cache.pool.map.MapListCachePool;

/**
 * 工厂：享元工厂，每个类型生成单例缓存池。
 * 每个类只提供一个缓存池（缓存池唯一, 缓存池时双重判断实现）
 * @author wuhailong
 */
public class SingletonForClassMemoryMapListCachePoolFactory implements MapListCachePoolFactory{
    
    /**
     * 缓存池集合，缓存池的享元模式容器
     * volatile型变量，多线程及时刷新
     */
    private volatile Map<Class, MemoryMapListCachePool> pool = new HashMap<>();
    
    @Override
    public MapListCachePool getListCachePool() {
        return getListCachePool(Object.class);
    }
    
    /**
     * 获取Map<String, List>型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型List类型Class对象
     * @return  Map型缓存池
     */
    @Override
    public <T> MapListCachePool<T> getListCachePool(Class<T> clazz){
        MemoryMapListCachePool<T> cachePool = pool.get(clazz);
        if(cachePool == null){
            synchronized(SingletonForClassMemoryMapListCachePoolFactory.class){     //同步块
                if(cachePool == null){                                          //双重判断
                    cachePool = new MemoryMapListCachePool<>(); 
                    pool.put(clazz, cachePool);
                }
            }
        }
        return cachePool;
    }
    
}
