package cn.whl.commonutils.spring.data.jpa.strategy;

import cn.whl.commonutils.page.Page;
import java.util.List;

/**
 * 返回封装策略
 * @author wuhailong
 */
public interface ResultStrategy<S, K> {
    
    public K getResult(Page page, List<S> list);
}
