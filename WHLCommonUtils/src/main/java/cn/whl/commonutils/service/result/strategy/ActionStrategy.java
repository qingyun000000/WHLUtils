package cn.whl.commonutils.service.result.strategy;

/**
 * 抽象策略角色——Controller层调用Service层的动作策略，不带返回值
 * @author wuhailong
 * @param <T>
 */
public interface ActionStrategy<T>{

    /**
     * 不带返回值的动作
     * @throws Exception
     */
    void action() throws Exception;
}
