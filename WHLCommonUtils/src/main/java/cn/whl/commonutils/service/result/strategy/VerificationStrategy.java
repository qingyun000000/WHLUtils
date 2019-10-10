package cn.whl.commonutils.service.result.strategy;

/**
 * 抽象策略角色——Controller层校验用户输入的策略
 * @author wuhailong
 */
public interface VerificationStrategy{

    /**
     * 校验输入
     * @throws java.lang.Exception
     */
    void verification() throws Exception;
}
