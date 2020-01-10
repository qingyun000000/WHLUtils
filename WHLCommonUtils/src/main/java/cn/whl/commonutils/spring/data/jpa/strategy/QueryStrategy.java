package cn.whl.commonutils.spring.data.jpa.strategy;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 查询策略
 * @author wuhailong
 */
public interface QueryStrategy<T> {
    
    public Page<T> query(Pageable pageable);
}
