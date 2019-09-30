package cn.whl.commonutils.sort.method.impl;

import cn.whl.commonutils.sort.method.SortMethod;
import cn.whl.commonutils.sort.strag.ISortStrag;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序
 * @author wuhailong
 */
public class CRSortMethod implements SortMethod {

    @Override
    public <T> void sort(T[] array, ISortStrag<T> strag) {
        for(int i = 0; i < array.length; i++){
            //数组需要逐位右移
            for(int j = i - 1; j >= 0; j--){
                if(strag.strag(array[j], array[j + 1])){
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }else{
                    break;
                }
            }
        }
        
    }

    @Override
    public <T> void sort(List<T> list, ISortStrag<T> strag) {
        for(int i = 0; i < list.size(); i++){
            //逐位右移
            for(int j = i - 1; j >= 0; j--){
                if(strag.strag(list.get(j), list.get(j + 1))){
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }else{
                    break;
                }
            }
        }
    }
    
}
