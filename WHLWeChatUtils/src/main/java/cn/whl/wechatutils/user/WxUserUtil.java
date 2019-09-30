package cn.whl.wechatutils.user;

import com.alibaba.fastjson.JSONObject;
import cn.whl.wechatutils.domain.WxUser;
import cn.whl.wechatutils.utils.AES;
import cn.whl.wechatutils.utils.HttpClinetSend;
import cn.whl.wechatutils.utils.WxPKCS7Encoder;
import org.apache.commons.codec.binary.Base64;

/**
 * 微信用户信息相关工具
 * @author Administrator
 */
public class WxUserUtil {
    
    /**
     * Jscode2session方法获取用户信息
     * @param appId
     * @param appSecret
     * @param jsCode
     * @return
     * @throws Exception
     */
    public String getJscode2session(String appId, String appSecret, String jsCode) throws Exception{
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + appId +
                "&secret=" + appSecret +
                "&js_code=" + jsCode +
                "&grant_type=authorization_code";

        String rStr = HttpClinetSend.getInstance().doAccessHTTPGet(url);
        return rStr;
    }
    
    /**
     * Jscode2session方法获取用户信息并转换为对象（至少有openId和session_key, 可能有UniondId，也可能没有）
     * @param appId
     * @param appSecret
     * @param jsCode
     * @return
     * @throws Exception
     */
    public WxUser getUserByJscode2session(String appId, String appSecret, String jsCode) throws Exception{

        String rStr = getJscode2session(appId, appSecret, jsCode);
        
        WxUser user = JSONObject.parseObject(rStr, WxUser.class);
        
        return user;
    }
    
    /**
     * 解密encryptedData获取UnionId
     * @param appId
     * @param appSecret
     * @param jsCode
     * @param encryptedData
     * @param iv
     * @return
     * @throws Exception
     */
    public WxUser getUnionIdByncryptedData(String appId, String appSecret, String jsCode, String encryptedData, String iv) throws Exception{
        WxUser user = getUserByJscode2session(appId, appSecret, jsCode);
        AES aes = new AES();
        byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(user.getSession_key()), Base64.decodeBase64(iv));
        if(null != resultByte && resultByte.length > 0){
            String userInfo = new String(WxPKCS7Encoder.decode(resultByte));
            user.setUnionid(JSONObject.parseObject(userInfo, WxUser.class).getUnionid());
            return user;
        }else{
            throw new Exception("解密失败");
        }
    }
    
    /**
     * 先通过Jscode2session方法获取UnionId，如果没有则解密encryptedData获取UnionId
     * @param appId
     * @param appSecret
     * @param jsCode
     * @param encryptedData
     * @param iv
     * @return
     * @throws Exception
     */
    public WxUser getUnionId(String appId, String appSecret, String jsCode, String encryptedData, String iv) throws Exception{
        WxUser user = getUserByJscode2session(appId, appSecret, jsCode);
        if(user.getUnionid() != null && "".equals(user.getUnionid())){
            return user;
        }else{
            AES aes = new AES();
            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(user.getSession_key()), Base64.decodeBase64(iv));
            if(null != resultByte && resultByte.length > 0){
                String userInfo = new String(WxPKCS7Encoder.decode(resultByte));
                user.setUnionid(JSONObject.parseObject(userInfo, WxUser.class).getUnionid());
                return user;
            }else{
                throw new Exception("解密失败");
            }
        }
        
    }
    
}
