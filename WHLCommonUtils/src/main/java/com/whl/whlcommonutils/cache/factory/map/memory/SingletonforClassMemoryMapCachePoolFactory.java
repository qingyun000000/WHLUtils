package com.whl.whlcommonutils.cache.factory.map.memory;

import com.whl.whlcommonutils.cache.pool.map.memory.MemoryMapCachePool;
import com.whl.whlcommonutils.cache.factory.map.MapCachePoolFactory;
import com.whl.whlcommonutils.cache.pool.map.MapCachePool;
import java.util.HashMap;
import java.util.Map;

/**
 * 工厂：享元工厂，每个类型生成单例缓存池。
 * 每个类只提供一个缓存池（缓存池唯一，通过工厂为单例模式，且获取工厂和缓存池时均双重判断实现）
 * @author wuhailong
 * @version 0.0.1
 * @createTime 2019-1-13
 * @updateTime 2019-4-16
 */
/* 
 * 0.0.1版：初始版本
 */
public class SingletonforClassMemoryMapCachePoolFactory implements MapCachePoolFactory{
    
    /**
     * volatile型变量，多线程及时刷新
     */
    private static volatile SingletonforClassMemoryMapCachePoolFactory factory;
    
    /**
     * 私有构造方法
     */
    private SingletonforClassMemoryMapCachePoolFactory(){
    }  
    
    /**
     * 获取工厂（单例模式）
     * @return MapCachePoolFactory
     */
    public static MapCachePoolFactory getFactory(){
        if(factory == null){
            synchronized(SingletonforClassMemoryMapCachePoolFactory.class){     //同步块
                if(factory == null){                                            //双重判断
                    factory = new SingletonforClassMemoryMapCachePoolFactory(); 
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
    public <T> MapCachePool<T> getCachePool(Class<T> clazz){
        MemoryMapCachePool<T> cachePool = pool.get(clazz);
        if(cachePool == null){
            synchronized(SingletonforClassMemoryMapCachePoolFactory.class){     //同步块
                if(cachePool == null){                                          //双重判断
                    cachePool = new MemoryMapCachePool<>(); 
                    pool.put(clazz, cachePool);
                }
            }
        }
        return cachePool;
    }
    
}
