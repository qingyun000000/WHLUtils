
package cn.whl.commonutils.thread;

import cn.whl.commonutils.log.LoggerUtils;
import java.util.Map;
import org.slf4j.Logger;

/**
 * 线程公共数据区
 * @author wuhailong
 */
public class ThreadCommonArea {
    
    //全局流水号
    private static ThreadLocal<String> globalFlowId = new InheritableThreadLocal<>();
    
    //日志对象
    private static ThreadLocal<Logger> logger = new ThreadLocal<>();
    
    //全局流水号
    private static ThreadLocal<Map<Object, Object>> commonArea = new InheritableThreadLocal<>();

    public static String getGlobalFlowId() {
        return globalFlowId.get();
    }

    public static void setGlobalFlowId(String globalFlowId) {
        ThreadCommonArea.globalFlowId.set(globalFlowId);
    }
    
    public static Object get(Object object) {
        return commonArea.get().get(object);
    }

    public static void set(Object key, Object value) {
        commonArea.get().put(key, value);
    }
    
    public static void setLogClass(Logger logger){
        ThreadCommonArea.logger.set(logger);
    }
    
    public static void info(String info){
        LoggerUtils.log4j_write.info(ThreadCommonArea.logger.get(), globalFlowId.get() + " || " + info);
    }
    
    public static void debug(String info){
        LoggerUtils.log4j_write.debug(ThreadCommonArea.logger.get(), globalFlowId.get() + " || " + info);
    }
    
    public static void warn(String info){
        LoggerUtils.log4j_write.warn(ThreadCommonArea.logger.get(), globalFlowId.get() + " || " + info);
    }
    
    public static void error(String info){
        LoggerUtils.log4j_write.error(ThreadCommonArea.logger.get(), globalFlowId.get() + " || " + info);
    }
}
