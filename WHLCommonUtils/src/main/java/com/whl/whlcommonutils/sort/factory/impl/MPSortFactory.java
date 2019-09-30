package com.whl.whlcommonutils.sort.factory.impl;

import com.whl.whlcommonutils.sort.factory.SortFactory;
import com.whl.whlcommonutils.sort.method.SortMethod;
import com.whl.whlcommonutils.sort.method.impl.MPSortMethod;

/**
 * 冒泡排序工厂
 * @author wuhailong
 */
public class MPSortFactory implements SortFactory{

    @Override
    public SortMethod createSortMethod() {
        return new MPSortMethod();
    }
    
}
