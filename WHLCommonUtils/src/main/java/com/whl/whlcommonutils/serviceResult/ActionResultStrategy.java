package com.whl.whlcommonutils.serviceResult;

/**
 * 抽象策略角色——Controller层调用Service层的动作策略，带返回值
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-5-1
 * @updateTime 2019-5-1
 */
public interface ActionResultStrategy<T> {

    /**
     * 带返回值的动作
     * @return 返回值【泛型】
     * @throws Exception
     */
    T actionAndGetResult() throws Exception;
}
