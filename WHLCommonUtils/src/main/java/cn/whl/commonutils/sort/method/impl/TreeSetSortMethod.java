package cn.whl.commonutils.sort.method.impl;

import cn.whl.commonutils.sort.method.SortMethod;
import cn.whl.commonutils.sort.strategy.ISortStrategy;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet排序
 * @author wuhailong
 */
public class TreeSetSortMethod implements SortMethod {

    @Override
    public <T> void sort(T[] array, ISortStrategy<T> strag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> void sort(List<T> list, ISortStrategy<T> strag) {
        Set<T> set = new TreeSet(new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if(strag.strag(o1, o2)){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        for(T t : list){
            set.add(t);
        }
        list.clear();
        for(T t : set){
            list.add(t);
        }
    }
    
}
