package cn.whl.commonutils.log.log4j;

import cn.whl.commonutils.log.LoggerWrite;
import java.util.Date;
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
        LOGGER.info(new Date() + " || INFO || " + info);
    }

    @Override
    public void info(Logger logger, String info) {
        logger.info(new Date() + " || INFO || " + info);
    }

    @Override
    public void info(Class clazz, String info) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(new Date() + " || INFO || " + info);
    }

    @Override
    public void debug(String info) {
        LOGGER.debug(new Date() + " || DEBUG || " + info);
    }

    @Override
    public void debug(Logger logger, String info) {
        logger.debug(new Date() + " || DEBUG || " + info);
    }

    @Override
    public void debug(Class clazz, String info) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.debug(new Date() + " || DEBUG || " + info);
    }

    @Override
    public void warn(String info) {
        LOGGER.warn(new Date() + " || WARN || " + info);
    }

    @Override
    public void warn(Logger logger, String info) {
        logger.warn(new Date() + " || WARN || " + info);
    }

    @Override
    public void warn(Class clazz, String info) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.warn(new Date() + " || WARN || " + info);
    }

    @Override
    public void error(Exception e) {
        LOGGER.error(new Date() + " || ERROR || " + e.getMessage());
    }

    @Override
    public void error(Logger logger, Exception e) {
        logger.error(new Date() + " || ERROR || " + e.getMessage());
    }

    @Override
    public void error(Class clazz, Exception e) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(new Date() + " || ERROR || " + e.getMessage());
    }

    @Override
    public void error(String message) {
        LOGGER.error(new Date() + " || ERROR || " + message);
    }

    @Override
    public void error(Logger logger, String message) {
        logger.error(new Date() + " || ERROR || " + message);
    }

    @Override
    public void error(Class clazz, String message) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(new Date() + " || ERROR || " + message);
    }
}
