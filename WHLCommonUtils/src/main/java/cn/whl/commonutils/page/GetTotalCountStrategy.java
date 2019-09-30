package cn.whl.commonutils.page;

/**
 * 抽象策略角色——获取总条数的策略
 * @author wuhailong
 */
public interface GetTotalCountStrategy {
    
    /**
     * 查询分页信息总条数的接口方法
     * @return 总条数
     */
    int queryTotalCount();
}
