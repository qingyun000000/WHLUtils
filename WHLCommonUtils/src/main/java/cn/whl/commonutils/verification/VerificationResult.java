package cn.whl.commonutils.verification;

import java.util.Map;

/**
 * 封装类：校验结果
 * @author wuhailong
 */
public class VerificationResult {
    
    private boolean success;
    
    private String message;
    
    private Map<String, Object> map;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
    
}
