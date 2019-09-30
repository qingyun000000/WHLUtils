package cn.whl.commonutils.sort.factory.impl;

import cn.whl.commonutils.sort.factory.SortFactory;
import cn.whl.commonutils.sort.method.SortMethod;
import cn.whl.commonutils.sort.method.impl.MPSortMethod;

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
