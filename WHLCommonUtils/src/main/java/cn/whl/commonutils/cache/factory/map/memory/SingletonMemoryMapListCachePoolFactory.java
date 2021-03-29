package cn.whl.commonutils.cache.factory.map.memory;

import cn.whl.commonutils.cache.pool.map.memory.MemoryMapListCachePool;
import cn.whl.commonutils.cache.factory.map.MapListCachePoolFactory;
import cn.whl.commonutils.cache.pool.map.MapListCachePool;
import cn.whl.commonutils.exception.ActionUnsupportedException;

/**
 * 工厂：享元工厂，生成单例缓存池。
 * （同一工厂缓存池唯一，通过单例模式实现）
 * @author wuhailong
 */
public class SingletonMemoryMapListCachePoolFactory implements MapListCachePoolFactory{
    
    /**
     * 缓存池
     * volatile型变量，多线程及时刷新
     */
    private volatile MemoryMapListCachePool pool;
    
    
    /**
     * 获取Map型缓存池，泛型
     * @param <T>  泛型类型
     * @param clazz  泛型类型Class对象
     * @return  Map型缓存池
     */
    @Override
    public <T> MapListCachePool<T> getListCachePool(Class<T> clazz) throws ActionUnsupportedException{
//        if(pool == null){
//            synchronized(SingletonMemoryMapCachePoolFactory.class){     //同步块
//                if(pool == null){                                          //双重判断
//                    pool = new MemoryMapListCachePool<>(); 
//                }
//            }
//        }
//        return pool;
          throw new ActionUnsupportedException("获取泛型类单例缓存池");  
    }



    @Override
    public MapListCachePool getListCachePool() {
        if(pool == null){
            synchronized(SingletonMemoryMapListCachePoolFactory.class){     //同步块
                if(pool == null){                                          //双重判断
                    pool = new MemoryMapListCachePool(); 
                }
            }
        }
        return pool;
    }
    
}
