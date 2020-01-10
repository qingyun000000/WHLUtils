package cn.whl.commonutils.spring.data.jpa.strategy;

/**
 * 构造策略
 * @author wuhailong
 */
public interface ConstructStrategy<T, K> {
    
    public K construct(T t);
}
