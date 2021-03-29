package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.factory.map.MapCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import java.util.HashMap;
import java.util.Map;
import cn.whl.commonutils.cache.pool.map.memory.MemoryMapCachePool;

/**
 * 工厂：享元工厂，每个类型生成单例缓存池。
 * 每个类只提供一个缓存池（缓存池唯一)
 * 工厂为单例模式
 * 且获取工厂和缓存池时均双重判断实现
 * @author wuhailong
 */
public class SingletonForClassMemoryMapCachePoolSingletonFactory implements MapCachePoolFactory{
    
    /**
     * volatile型变量，多线程及时刷新
     */
    private static volatile SingletonForClassMemoryMapCachePoolSingletonFactory factory;
    
    /**
     * 私有构造方法
     */
    private SingletonForClassMemoryMapCachePoolSingletonFactory(){
    }  
    
    /**
     * 获取工厂（单例模式）
     * @return MapCachePoolFactory
     */
    public static SingletonForClassMemoryMapCachePoolSingletonFactory getFactory(){
        if(factory == null){
            synchronized(SingletonForClassMemoryMapCachePoolSingletonFactory.class){     //同步块
                if(factory == null){                                            //双重判断
                    factory = new SingletonForClassMemoryMapCachePoolSingletonFactory(); 
                }
            }
        }
        return factory;
    }
   
    /**
     * 缓存池集合，缓存池的享元模式容器
     * volatile型变量，多线程及时刷新
     */
    private volatile Map<Class, MemoryMapCachePool> pool = new HashMap<>();
    
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
            synchronized(SingletonForClassMemoryMapCachePoolSingletonFactory.class){     //同步块
                if(cachePool == null){                                          //双重判断
                    cachePool = new MemoryMapCachePool<>(); 
                    pool.put(clazz, cachePool);
                }
            }
        }
        return cachePool;
    }

    @Override
    public MapCachePool getCachePool() {
        return getCachePool(Object.class);
    }
    
}
