package cn.whl.commonutils.sort.strag;

/**
 * 排序策略
 * @author wuhailong
 * @param <T>
 */
public interface ISortStrag<T> {
    
    /**
     * one为输入坐标小的对象，two为输入坐标大的对象，结果为是否交换
     * @param one
     * @param two
     * @return
     */
    public boolean strag(T one, T two);
    
}
