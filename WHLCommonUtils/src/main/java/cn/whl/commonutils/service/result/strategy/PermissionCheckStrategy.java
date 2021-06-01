package cn.whl.commonutils.service.result.strategy;

import cn.whl.commonutils.exception.CommonException;

/**
 * 抽象策略角色——Controller层校验用户权限的策略
 * @author wuhailong
 */
public interface PermissionCheckStrategy{

    /**
     * 校验用户权限
     * @return 具备权限/不具备权限
     * @throws cn.whl.commonutils.exception.CommonException
     */
    Boolean verification() throws CommonException;
}
