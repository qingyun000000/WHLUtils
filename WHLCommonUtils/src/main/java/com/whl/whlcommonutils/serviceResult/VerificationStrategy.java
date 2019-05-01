package com.whl.whlcommonutils.serviceResult;

/**
 * 抽象策略角色——Controller层校验用户输入的策略
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-5-1
 * @updateTime 2019-5-1
 */
public interface VerificationStrategy{

    /**
     * 校验输入
     * @throws java.lang.Exception
     */
    void verification() throws Exception;
}
