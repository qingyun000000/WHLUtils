package com.whl.whlcommonutils.string;

/**
 * 抽象策略角色——获取属性值
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-4-12
 * @updateTime 2019-5-1
 * @param <T>
 */
public interface GetParamInterface<T> {
    String GetParam(T t);
}
