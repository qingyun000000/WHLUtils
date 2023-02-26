package cn.whl.commonutils.security.strategy;

import cn.whl.commonutils.security.strategy.CypherStrategory;

/**
 * 缺省的加密器（不加密）
 * @author Administrator
 */
public class VacancyCypher implements CypherStrategory {

    public VacancyCypher() {
        
    }

    @Override
    public String encrypt(String input) {
        return input;
    }

    @Override
    public String decrypt(String input) {
        return input;
    }
    
}
