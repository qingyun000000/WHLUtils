package cn.whl.commonutils.log;

/**
 * 接口：写入日志
 * @author wuhailong
 */
public interface LoggerWrite{
    
    /**
     * 基本日志输出
     * @param info 输出信息
     */
    public void info(String info);
    
    public void info(Class clazz, String info);
    
    public void error(Exception e);
    
    public void error(String message);
    
    public void error(Class clazz, Exception e);
    
    public void error(Class clazz, String message);
    
}