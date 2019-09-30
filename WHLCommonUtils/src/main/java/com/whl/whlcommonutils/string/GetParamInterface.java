package com.whl.whlcommonutils.string;

/**
 * 抽象策略角色——获取属性值
 * @author wuhailong
 * @param <T>
 */
public interface GetParamInterface<T> {
    String GetParam(T t);
}
