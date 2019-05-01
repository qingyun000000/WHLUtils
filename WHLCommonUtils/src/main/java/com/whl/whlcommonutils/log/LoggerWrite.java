package com.whl.whlcommonutils.log;

/**
 * 接口：写入日志
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-4-12
 * @updateTime 2019-5-1
 */
public interface LoggerWrite{
    
    /**
     * 基本日志输出
     * @param info 输出信息
     */
    public void simpleInfo(String info);
}
