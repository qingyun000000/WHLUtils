package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.pool.map.memory.MemoryMapListCachePool;
import cn.whl.commonutils.cache.factory.map.MapCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import cn.whl.commonutils.cache.pool.map.MapListCachePool;
import cn.whl.commonutils.cache.pool.map.memory.MemoryMapCachePool;

/**
 * 工厂：享元工厂，生成单例缓存池。
 * （同一工厂缓存池唯一，通过单例模式实现）
 * @author wuhailong
 */
public class SimpleSingletonMemoryMapCachePoolFactory implements MapCachePoolFactory{
    
    /**
     * 缓存池
     * volatile型变量，多线程及时刷新
     */
    private volatile MemoryMapListCachePool pool;
    /**
     * 缓存池
     * volatile型变量，多线程及时刷新
     */
    private volatile MemoryMapCachePool pool2;
    
    
    /**
     * 获取Map型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    @Override
    public <T> MapListCachePool<T> getListCachePool(Class<T> clazz){
        if(pool == null){
            synchronized(SimpleSingletonMemoryMapCachePoolFactory.class){     //同步块
                if(pool == null){                                          //双重判断
                    pool = new MemoryMapListCachePool<>(); 
                }
            }
        }
        return pool;
    }

    @Override
    public <T> MapCachePool<T> getCachePool(Class<T> clazz) {
        if(pool2 == null){
            synchronized(SimpleSingletonMemoryMapCachePoolFactory.class){     //同步块
                if(pool2 == null){                                          //双重判断
                    pool2 = new MemoryMapCachePool<>(); 
                }
            }
        }
        return pool2;
    }

    @Override
    public MapCachePool getCachePool() {
        return getCachePool(Object.class);
    }

    @Override
    public MapListCachePool getListCachePool() {
         return getListCachePool(Object.class);
    }
    
}
