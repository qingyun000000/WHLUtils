package cn.whl.commonutils.log.log4j;

import cn.whl.commonutils.log.LoggerWrite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Log4j日志
 * @author wuhailong
 */
public class Log4JWriter implements LoggerWrite{
    
    private final Logger LOGGER = LoggerFactory.getLogger(Log4JWriter.class);

    @Override
    public void info(String info) {
        LOGGER.info(info);
    }

    @Override
    public void info(Class clazz, String info) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(info);
    }

    @Override
    public void error(Exception e) {
        LOGGER.error(e.getMessage());
    }

    @Override
    public void error(Class clazz, Exception e) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(e.getMessage());
    }

    @Override
    public void error(String message) {
        LOGGER.error(message);
    }

    @Override
    public void error(Class clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message);
    }
    
}
