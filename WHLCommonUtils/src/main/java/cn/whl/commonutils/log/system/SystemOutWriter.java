package cn.whl.commonutils.log.system;

import cn.whl.commonutils.log.LoggerWrite;
import java.util.Date;
import org.slf4j.Logger;

/**
 * 系统标准输出日志
 * @author wuhailong
 */
public class SystemOutWriter implements LoggerWrite {

    @Override
    public void info(String info) {
        System.out.println(new Date() + " 提示信息：" + info);
    }

    @Override
    public void info(Class clazz, String info) {
        System.out.println(new Date() + " 类" + clazz.getName() + " 提示信息：" + info);
    }

    @Override
    public void error(Exception e) {
        System.out.println(new Date() + " [*]错误信息：" + e.getMessage());
    }

    @Override
    public void error(Class clazz, Exception e) {
        System.out.println(new Date() + " 类" + clazz.getName() + " [*]错误信息：" + e.getMessage());
    }

    @Override
    public void error(String message) {
        System.out.println(new Date() + " [*]错误信息：" + message);
    }

    @Override
    public void error(Class clazz, String message) {
        System.out.println(new Date() + " 类" + clazz.getName() + " [*]错误信息：" + message);
    }

    @Override
    public void info(Logger logger, String info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debug(String info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debug(Logger logger, String info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debug(Class clazz, String info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void warn(String info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void warn(Logger logger, String info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void warn(Class clazz, String info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(Logger logger, Exception e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(Logger logger, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
