package com.whl.whlcommonutils.cache.pool.map.memory;

import com.whl.whlcommonutils.cache.pool.map.MapCachePool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用主存保存数据的Map型缓存池，泛型，实现MapCachePool
 * @author wuhailong
 * @version 0.0.1
 * @createTime 2019-1-13
 * @updateTime 2019-4-16
 * @param <T> 存入的List的数据类型
 */
/*
* 0.0.1版：初始版本
*/
public class MemoryMapCachePool <T> implements MapCachePool<T>{
    
    /**
     * 主存Map
     */
    private final Map<String, List<T>> map = new HashMap<>();
    
    /**
     * 读写锁
     */
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    /**
     * 放入元素（列表型）
     * @param key  Map的Key
     * @param list  Map的Value，泛型类的列表
     */
    @Override
    public void put(String key, List<T> list){
        lock.writeLock().lock();
        try {
            map.put(key, list);
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    /**
     * 分段取出，取出Map的一个Value(列表）中的一段
     * @param key   Map的Key
     * @param start  开始位置下标
     * @param count  段长的长度（取出元素的数量）
     * @return  子列表
     */
    @Override
    public List<T> getByStartAndCount(String key, int start, int count){
        lock.readLock().lock();
        try {
            List<T> list = map.get(key);
            int size = list.size();
            List<T> get = new ArrayList<>();
            
            for(int i = 0; i < count && i < size - start; i++){
                T t = list.get(start + i);
                get.add(t);
            }
            
            return get;
        } finally {
            lock.readLock().unlock();
        }
    }
    
    
    /**
     * 清空
     */
    @Override
    public void clear(){
        lock.writeLock().lock();
        try {
            map.clear();
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    /**
     * 判断是否存在Key
     * @param key  Map的Key
     * @return  是否存在
     */
    @Override
    public Boolean containsKey(String key){
        lock.readLock().lock();
        try {
            return map.containsKey(key);
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * 获取Key对应的List长度
     * @param key Map的Key
     * @return  对应Value(列表）的size
     */
    @Override
    public int listSize(String key){
        lock.readLock().lock();
        try {
            return map.get(key).size();
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * 清除Key对应的记录
     * @param key Map的Key
     */
    @Override
    public void clearByKey(String key) {
        lock.readLock().lock();
        try {
            map.remove(key);
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * 获取所有的Key
     * @return  Key的Set集合
     */
    @Override
    public Set<String> getAllKey() {
        lock.readLock().lock();
        try {
            Set<String> keySet = map.keySet();   //不能把keySet直接返回，因为数组是引用类型，在外部迭代时不能进行删除操作，否则报concurrentmodificationexception
            Set<String> set = new HashSet();
            for(String key : keySet){
                set.add(key);
            }
            return set;
        } finally {
            lock.readLock().unlock();
        }
    }
}
