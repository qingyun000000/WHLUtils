package com.whl.whlcommonutils.serviceResult;

/**
 * 抽象策略角色——Controller层校验用户权限的策略
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-5-1
 * @updateTime 2019-5-1
 */
public interface PermissionCheckStrategy{

    /**
     * 校验用户权限
     * @return 具备权限/不具备权限
     */
    Boolean verification();
}
