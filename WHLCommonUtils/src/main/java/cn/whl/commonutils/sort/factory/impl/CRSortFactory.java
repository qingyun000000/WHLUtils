package cn.whl.commonutils.sort.factory.impl;

import cn.whl.commonutils.sort.factory.SortFactory;
import cn.whl.commonutils.sort.method.SortMethod;
import cn.whl.commonutils.sort.method.impl.CRSortMethod;

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
