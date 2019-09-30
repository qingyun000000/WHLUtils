package cn.whl.commonutils.log.system;

import cn.whl.commonutils.log.LoggerWrite;
import java.util.Date;

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
        System.out.println(new Date() + " 错误信息：" + e.getMessage());
    }

    @Override
    public void error(Class clazz, Exception e) {
        System.out.println(new Date() + " 类" + clazz.getName() + " 错误信息：" + e.getMessage());
    }

}
