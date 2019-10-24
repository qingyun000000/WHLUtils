package cn.whl.commonutils.cache.pool.map;

import cn.whl.commonutils.cache.pool.CachePool;
import java.util.Set;

/**
 * 接口：Map型缓存池，泛型，继承CachePool
 * @author wuhailong
 * @param <T> 数据类型
 */
public interface MapCachePool <T> extends CachePool{
    
    /**
     * 放入元素（列表型）
     * @param key  Map的Key
     * @param t 泛型对象
     */
    public void put(String key, T t);
    
    /**
     * 取出元素
     * @param key   Map的Key
     * @return  子列表
     */
    public T getValue(String key);
    
    /**
     * 判断是否存在Key
     * @param key  Map的Key
     * @return  是否存在
     */
    public Boolean containsKey(String key);
    
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
