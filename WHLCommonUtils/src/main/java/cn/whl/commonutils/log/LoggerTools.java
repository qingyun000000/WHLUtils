package cn.whl.commonutils.log;

import cn.whl.commonutils.log.log4j.Log4JWriter;
import cn.whl.commonutils.log.system.SystemOutWriter;

/**
 * 工具类：日志
 * @author wuhailong
 */
public class LoggerTools {
    
    public static LoggerWrite log4j_write = new Log4JWriter();
    
    public static LoggerWrite sys_write = new SystemOutWriter();
    
}

