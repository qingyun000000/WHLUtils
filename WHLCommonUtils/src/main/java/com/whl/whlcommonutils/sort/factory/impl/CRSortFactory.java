package com.whl.whlcommonutils.sort.factory.impl;

import com.whl.whlcommonutils.sort.factory.SortFactory;
import com.whl.whlcommonutils.sort.method.SortMethod;
import com.whl.whlcommonutils.sort.method.impl.CRSortMethod;

/**
 * 插入排序工厂
 * @author wuhailong
 */
public class CRSortFactory implements SortFactory{

    @Override
    public SortMethod createSortMethod() {
        return new CRSortMethod();
    }
    
}
