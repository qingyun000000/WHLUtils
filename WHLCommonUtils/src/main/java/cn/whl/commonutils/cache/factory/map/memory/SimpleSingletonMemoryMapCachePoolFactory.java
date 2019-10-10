package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.pool.map.memory.MemoryMapCachePool;
import cn.whl.commonutils.cache.factory.map.MapCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;

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
    private volatile MemoryMapCachePool pool;
    
    /**
     * 获取Map型缓存池
     * @return
     */
    public MapCachePool<Object> getCachePool(){
        if(pool == null){
            synchronized(SimpleSingletonMemoryMapCachePoolFactory.class){     //同步块
                if(pool == null){                                          //双重判断
                    pool = new MemoryMapCachePool<>(); 
                }
            }
        }
        return pool;
    }
    
    /**
     * 获取Map型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    @Override
    public <T> MapCachePool<T> getCachePool(Class<T> clazz){
        if(pool == null){
            synchronized(SimpleSingletonMemoryMapCachePoolFactory.class){     //同步块
                if(pool == null){                                          //双重判断
                    pool = new MemoryMapCachePool<>(); 
                }
            }
        }
        return pool;
    }
    
}
