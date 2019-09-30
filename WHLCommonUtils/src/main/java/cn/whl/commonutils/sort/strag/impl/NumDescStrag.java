package cn.whl.commonutils.sort.strag.impl;

import cn.whl.commonutils.sort.strag.ISortStrag;

/**
 * 升序策略
 * @author wuhailong
 * @param <T>
 */
public class NumDescStrag<T extends Number> implements ISortStrag<T>{

    @Override
    public boolean strag(T one, T two) {
        return one.doubleValue() < two.doubleValue();
    }
    
}
