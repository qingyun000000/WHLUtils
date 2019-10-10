package cn.whl.commonutils.sort.strategy;

/**
 * 排序策略接口
 * @author wuhailong
 * @param <T>
 */
public interface ISortStrategy<T> {
    
    /**
     * 判断策略
     * 交换类排序当为真时交换（判断时总是one的坐标小，two的坐标大）
     * 
     * @param one
     * @param two
     * @return 
     */
    public boolean strag(T one, T two);
    
}
