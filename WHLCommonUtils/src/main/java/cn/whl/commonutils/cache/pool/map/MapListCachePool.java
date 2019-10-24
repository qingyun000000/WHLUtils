package cn.whl.commonutils.cache.pool.map;

import java.util.List;

/**
 * 接口：Map型缓存池，泛型，继承CachePool
 * @author wuhailong
 * @param <T> 存入的List的数据类型
 */
public interface MapListCachePool <T> extends MapCachePool<List<T>>{
    
    /**
     * 分段取出，取出Map的一个Value(列表）中的一段
     * @param key   Map的Key
     * @param start  开始位置下标
     * @param count  段长的长度（取出元素的数量）
     * @return  子列表
     */
    public List<T> getByStartAndCount(String key, int start, int count);
    
    /**
     * 获取Key对应的List长度
     * @param key Map的Key
     * @return  对应Value(列表）的size
     */
    public int listSize(String key);
}
