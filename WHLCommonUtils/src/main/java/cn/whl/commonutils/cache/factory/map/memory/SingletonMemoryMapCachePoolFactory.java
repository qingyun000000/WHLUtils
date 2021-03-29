package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.factory.map.MapCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapCachePool;
import cn.whl.commonutils.cache.pool.map.memory.MemoryMapCachePool;
import cn.whl.commonutils.exception.ActionUnsupportedException;

/**
 * 工厂：享元工厂，生成单例缓存池。
 * （同一工厂缓存池唯一，通过单例模式实现）
 * @author wuhailong
 */
public class SingletonMemoryMapCachePoolFactory implements MapCachePoolFactory{
    
    /**
     * 缓存池
     * volatile型变量，多线程及时刷新
     */
    private volatile MemoryMapCachePool pool;
    
    @Override
    public <T> MapCachePool<T> getCachePool(Class<T> clazz) throws ActionUnsupportedException {
//        if(pool2 == null){
//            synchronized(SingletonMemoryMapCachePoolFactory.class){     //同步块
//                if(pool2 == null){                                          //双重判断
//                    pool2 = new MemoryMapCachePool<>(); 
//                }
//            }
//        }
//        return pool2;
          throw new ActionUnsupportedException("获取泛型类单例缓存池");  
    }

    @Override
    public MapCachePool getCachePool() {
        if(pool == null){
            synchronized(SingletonMemoryMapCachePoolFactory.class){     //同步块
                if(pool == null){                                          //双重判断
                    pool = new MemoryMapCachePool(); 
                }
            }
        }
        return pool;
    }

    
}
