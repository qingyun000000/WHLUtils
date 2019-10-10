package cn.whl.commonutils.verificate;

import cn.whl.commonutils.Result;
import java.util.Map;

/**
 * 校验结果封装
 * @author wuhailong
 */
public class VerificationResult extends Result{
        
    private Map<String, Object> map;
    
    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    
}
