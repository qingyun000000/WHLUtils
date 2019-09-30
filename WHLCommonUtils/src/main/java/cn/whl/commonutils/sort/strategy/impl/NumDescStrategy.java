package cn.whl.commonutils.sort.strategy.impl;

import cn.whl.commonutils.sort.strategy.ISortStrategy;

/**
 * 升序策略
 * @author wuhailong
 * @param <T>
 */
public class NumDescStrategy<T extends Number> implements ISortStrategy<T>{

    @Override
    public boolean strag(T one, T two) {
        return one.doubleValue() < two.doubleValue();
    }
    
}
