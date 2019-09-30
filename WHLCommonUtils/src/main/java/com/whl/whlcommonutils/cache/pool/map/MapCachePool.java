package com.whl.whlcommonutils.cache.pool.map;

import com.whl.whlcommonutils.cache.pool.CachePool;
import java.util.List;
import java.util.Set;

/**
 * 接口：Map型缓存池，泛型，继承CachePool
 * @author wuhailong
 * @version 0.0.1
 * @createTime 2019-1-13
 * @updateTime 2019-4-16
 * @param <T> 存入的List的数据类型
 */
/*
* 0.0.1版：初始版本
*/
public interface MapCachePool <T> extends CachePool{
    
    /**
     * 放入元素（列表型）
     * @param key  Map的Key
     * @param list  Map的Value，泛型类的列表
     */
    public void put(String key, List<T> list);
    
    /**
     * 分段取出，取出Map的一个Value(列表）中的一段
     * @param key   Map的Key
     * @param start  开始位置下标
     * @param count  段长的长度（取出元素的数量）
     * @return  子列表
     */
    public List<T> getByStartAndCount(String key, int start, int count);
    
    
    /**
     * 清空
     */
    @Override
    public void clear();
    
    /**
     * 判断是否存在Key
     * @param key  Map的Key
     * @return  是否存在
     */
    public Boolean containsKey(String key);
    
    /**
     * 获取Key对应的List长度
     * @param key Map的Key
     * @return  对应Value(列表）的size
     */
    public int listSize(String key);
    
    /**
     * 清除Key对应的记录
     * @param key Map的Key
     */
    public void clearByKey(String key);
    
    /**
     * 获取所有的Key
     * @return  Key的Set集合
     */
    public Set<String> getAllKey();
}
