package com.whl.whlcommonutils.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工具类：日志
 * @author wuhailong
 */
public class LoggerTools {
    
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerTools.class);
    public static LoggerWrite write = (String info) -> {
        LOGGER.info(info);
    };
    
}

