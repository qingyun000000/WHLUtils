
package cn.whl.commonutils.thread;

import cn.whl.commonutils.log.LoggerUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程公共数据区
 * @author wuhailong
 */
public class ThreadCommonArea {
    
    //全局流水号
    private static ThreadLocal<String> globalFlowId = new InheritableThreadLocal<>();
    
    //请求来源
    private static ThreadLocal<String> requestSource = new ThreadLocal<>();
    
    //日志对象
    private static ThreadLocal<Logger> logger = new ThreadLocal<>();
    
    //通用公共区
    private static ThreadLocal<Map<Object, Object>> commonArea = new InheritableThreadLocal<>();

    public static String getGlobalFlowId() {
        return globalFlowId.get();
    }

    public static void setGlobalFlowId(String globalFlowId) {
        ThreadCommonArea.globalFlowId.set(globalFlowId);
    }

    public static String getRequestSource() {
        return requestSource.get();
    }

    public static void setRequestSource(String requestSource) {
        ThreadCommonArea.requestSource.set(requestSource);
    }
    
    public static Object get(Object object) {
        return commonArea.get().get(object);
    }

    public static void set(Object key, Object value) {
        commonArea.get().put(key, value);
    }
    
    public static void setLogger(Logger logger){
        ThreadCommonArea.logger.set(logger);
    }
    
    public static void setLogger(Class clazz){
        ThreadCommonArea.logger.set(LoggerFactory.getLogger(clazz));
    }
    
    public static void info(String info){
        LoggerUtils.log4j_write.info(ThreadCommonArea.logger.get(), globalFlowId.get() + " || " + requestSource.get() + " || " + info);
    }
    
    public static void debug(String info){
        LoggerUtils.log4j_write.debug(ThreadCommonArea.logger.get(), globalFlowId.get() + " || " + requestSource.get() + " || " + info);
    }
    
    public static void warn(String info){
        LoggerUtils.log4j_write.warn(ThreadCommonArea.logger.get(), globalFlowId.get() + " || " + requestSource.get() + " || " + info);
    }
    
    public static void error(String info){
        LoggerUtils.log4j_write.error(ThreadCommonArea.logger.get(), globalFlowId.get() + " || " + requestSource.get() + " || " + info);
    }
    
    public static void info(Class clazz, String info){
        LoggerUtils.log4j_write.info(clazz, globalFlowId.get() + " || " + requestSource.get() + " || " + info);
    }
    
    public static void debug(Class clazz, String info){
        LoggerUtils.log4j_write.debug(clazz, globalFlowId.get() + " || " + requestSource.get() + " || " + info);
    }
    
    public static void warn(Class clazz, String info){
        LoggerUtils.log4j_write.warn(clazz, globalFlowId.get() + " || " + requestSource.get() + " || " + info);
    }
    
    public static void error(Class clazz, String info){
        LoggerUtils.log4j_write.error(clazz, globalFlowId.get() + " || " + requestSource.get() + " || " + info);
    }
}
