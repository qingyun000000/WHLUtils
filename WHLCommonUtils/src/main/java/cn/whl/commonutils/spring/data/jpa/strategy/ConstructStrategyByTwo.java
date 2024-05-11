package cn.whl.commonutils.spring.data.jpa.strategy;

/**
 * 双参数构造策略
 * @author wuhailong
 * @param <T>
 * @param <K>
 * @param <L>
 */
public interface ConstructStrategyByTwo <T, K, L> {
    
    public L construct(T t, K k);
}