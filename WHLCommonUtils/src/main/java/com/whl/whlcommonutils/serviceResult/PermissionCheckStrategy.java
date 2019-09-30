package com.whl.whlcommonutils.serviceResult;

/**
 * 抽象策略角色——Controller层校验用户权限的策略
 * @author wuhailong
 */
public interface PermissionCheckStrategy{

    /**
     * 校验用户权限
     * @return 具备权限/不具备权限
     */
    Boolean verification();
}
