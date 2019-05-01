package com.whl.whlcommonutils.page;

/**
 * 抽象策略角色——获取总条数的策略
 * @author wuhailong
 * @version 0.0.1
 * @createTime：2019-4-13
 * @updateTime：2019-4-13
 */
public interface GetTotalCountStrategy {
    
    /**
     * 查询分页信息总条数的接口方法
     * @return 总条数
     */
    int queryTotalCount();
}
