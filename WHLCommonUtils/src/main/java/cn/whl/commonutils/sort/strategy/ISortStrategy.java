package cn.whl.commonutils.sort.strategy;

/**
 * 排序策略接口
 * @author wuhailong
 * @param <T>
 */
public interface ISortStrategy<T> {
    
    public boolean strag(T one, T two);
    
}
