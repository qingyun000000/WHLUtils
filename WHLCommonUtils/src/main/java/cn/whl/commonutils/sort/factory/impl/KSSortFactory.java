package cn.whl.commonutils.sort.factory.impl;

import cn.whl.commonutils.sort.factory.SortFactory;
import cn.whl.commonutils.sort.method.SortMethod;
import cn.whl.commonutils.sort.method.impl.KSSortMethod;

/**
 * 快速排序工厂
 * @author wuhailong
 */
public class KSSortFactory implements SortFactory{

    @Override
    public SortMethod createSortMethod() {
        return new KSSortMethod();
    }
    
}
