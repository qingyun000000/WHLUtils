package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.factory.map.MapCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import java.util.HashMap;
import java.util.Map;
import cn.whl.commonutils.cache.pool.map.memory.MemoryMapCachePool;

/**
 * 工厂：享元工厂，每个字符串生成单例缓存池。
 * 每个字符串只提供一个缓存池（缓存池唯一, 缓存池时双重判断实现）
 * @author wuhailong
 */
public class SingletonForStringMemoryMapCachePoolFactory implements MapCachePoolFactory{
    
    /**
     * 缓存池集合，缓存池的享元模式容器
     * volatile型变量，多线程及时刷新
     */
    private volatile Map<String, MemoryMapCachePool> pool = new HashMap<>();

    @Override
    public MapCachePool getCachePool() {
        MemoryMapCachePool cachePool = pool.get("");
        if(cachePool == null){
            synchronized(SingletonForClassMemoryMapCachePoolSingletonFactory.class){     //同步块
                if(cachePool == null){                                          //双重判断
                    cachePool = new MemoryMapCachePool<>(); 
                    pool.put("", cachePool);
                }
            }
        }
        return cachePool;
    }
    
    public MapCachePool getCachePool(String str) {
        MemoryMapCachePool cachePool = pool.get(str);
        if(cachePool == null){
            synchronized(SingletonForClassMemoryMapCachePoolSingletonFactory.class){     //同步块
                if(cachePool == null){                                          //双重判断
                    cachePool = new MemoryMapCachePool<>(); 
                    pool.put(str, cachePool);
                }
            }
        }
        return cachePool;
    }

    @Override
    public <T> MapCachePool<T> getCachePool(Class<T> clazz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
