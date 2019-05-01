package com.whl.whlcommonutils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具类：日志
 * @author wuhailong
 * @version 1.0.0
 * @createTime 2019-4-12
 * @updateTime 2019-5-1
 */
public class LoggerTools {
    
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerTools.class);
    public static LoggerWrite write = (String info) -> {
        LOGGER.info(info);
    };
    
}

