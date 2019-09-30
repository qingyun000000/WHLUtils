package cn.whl.commonutils.sort;

import cn.whl.commonutils.sort.factory.SortFactory;
import cn.whl.commonutils.sort.method.SortMethod;
import java.util.List;
import cn.whl.commonutils.sort.strategy.ISortStrategy;
import cn.whl.commonutils.sort.strategy.impl.NumAscStrategy;
import cn.whl.commonutils.sort.strategy.impl.NumDescStrategy;

/**
 * 排序工具
 *
 * @author wuhailong
 */
public class SortUtil {

    public static void sort(int[] array, SortFactory factory) {
        sort(array, factory, false);
    }

    public static void sort(int[] array, SortFactory factory, boolean desc) {
        Number[] array1 = new Number[array.length];
        for (int i = 0; i < array.length; i++) {
            array1[i] = array[i];
        }
        if (desc == true) {
            sort(array1, new NumDescStrategy<>(), factory);
        }else{
            sort(array1, new NumAscStrategy<>(), factory);
        }
    }

    public static void sort(long[] array, SortFactory factory) {
        sort(array, factory, false);
    }

    public static void sort(long[] array, SortFactory factory, boolean desc) {
        Number[] array1 = new Number[array.length];
        for (int i = 0; i < array.length; i++) {
            array1[i] = array[i];
        }
        if (desc == true) {
            sort(array1, new NumDescStrategy<>(), factory);
        }else{
            sort(array1, new NumAscStrategy<>(), factory);
        }
    }

    public static void sort(double[] array, SortFactory factory) {
        sort(array, factory, false);
    }

    public static void sort(double[] array, SortFactory factory, boolean desc) {
        Number[] array1 = new Number[array.length];
        for (int i = 0; i < array.length; i++) {
            array1[i] = array[i];
        }
        if (desc == true) {
            sort(array1, new NumDescStrategy<>(), factory);
        }else{
            sort(array1, new NumAscStrategy<>(), factory);
        }
    }

    public static <T> void sort(T[] array, ISortStrategy<T> strag, SortFactory factory) {
        SortMethod method = factory.createSortMethod();
        method.sort(array, strag);
    }

    public static <T> void sort(List<T> list, ISortStrategy<T> strag, SortFactory factory) {
        SortMethod method = factory.createSortMethod();
        method.sort(list, strag);
    }

}
