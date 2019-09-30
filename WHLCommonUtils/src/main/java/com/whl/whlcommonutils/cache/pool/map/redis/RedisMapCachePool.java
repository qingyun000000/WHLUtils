package com.whl.whlcommonutils.cache.pool.map.redis;

import com.whl.whlcommonutils.cache.pool.map.MapCachePool;
import java.util.List;
import java.util.Set;

/**
 * 使用Redis保存数据的Map型缓存池，泛型，实现MapCachePool
 * @author wuhailong
 * @param <T> 存入的List的数据类型
 */
public class RedisMapCachePool <T> implements MapCachePool<T>{

    @Override
    public void put(String key, List<T> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> getByStartAndCount(String key, int start, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean containsKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int listSize(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> getAllKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
