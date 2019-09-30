package cn.whl.commonutils.sort;

import cn.whl.commonutils.sort.factory.SortFactory;
import cn.whl.commonutils.sort.method.SortMethod;
import java.util.List;
import cn.whl.commonutils.sort.strategy.ISortStrategy;

/**
 * 排序工具
 * @author wuhailong
 */
public class SortUtil{
    
    public static <T> void sort(T[] array, ISortStrategy<T> strag, SortFactory factory){
        SortMethod method = factory.createSortMethod();
        method.sort(array, strag);
    }
    
    public static <T> void sort(List<T> list, ISortStrategy<T> strag, SortFactory factory){
        SortMethod method = factory.createSortMethod();
        method.sort(list, strag);
    }
    
}
