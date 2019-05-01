package com.whl.whlcommonutils.serviceResult;

/**
 * 抽象策略角色——Controller层调用Service层的动作策略，不带返回值
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-5-1
 * @updateTime 2019-5-1
 */
public interface ActionStrategy<T>{

    /**
     * 不带返回值的动作
     * @throws Exception
     */
    void action() throws Exception;
}
