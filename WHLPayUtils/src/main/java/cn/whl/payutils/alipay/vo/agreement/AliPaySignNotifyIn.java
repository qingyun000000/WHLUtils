package cn.whl.payutils.alipay.vo.agreement;

import cn.whl.payutils.alipay.vo.AliPayNotifyIn;
import cn.whl.payutils.common.agreement.SignNotifyIn;


/**
 * 阿里支付订单关闭回调参数封装
 * @author wuhailong
 */
public class AliPaySignNotifyIn extends AliPayNotifyIn implements SignNotifyIn{
    
    private String invalid_time;                //用户代扣协议的失效时间，格式为yyyy-MM-dd HH:mm:ss。（只有签约成功才会返回）
    
    private String sign_scene;                  //当前签约的协议场景。
    
    private String sign_time;                   //支付宝代扣协议的实际签约时间，格式为yyyy-MM-dd HH:mm:ss。(只有签约成功才会返回)
    
    private String alipay_user_id;              //用户签约的支付宝账号对应的支付宝唯一用户号。以2088开头的16位纯数字组成。(只有签约成功时才会返回)
    
    private String status;                      //协议的当前状态。1. TEMP：暂存，协议未生效过；2. NORMAL：正常；3. STOP：暂停。（只有签约成功才会返回）
    
    private String forex_eligible;              //是否海外购汇身份。值：T/F（只有在签约成功时才会返回）
    
    private String external_logon_id;           //用户在商户网站的登录账号，如果商户接口中未传，则不会返回
    
    private String auth_app_id;                 //
    
    private String external_agreement_no;       //代扣协议中标示用户的唯一签约号（确保在商户系统中唯一）。
    
    private String personal_product_code;       //协议产品码，商户和支付宝签约时确定，不同业务场景对应不同的签约产品码。
    
    private String valid_time;                  //用户代扣协议的实际生效时间，格式为yyyy-MM-dd HH:mm:ss。（只有签约成功才会返回）
    
    private String agreement_no;                //支付宝系统中用以唯一标识用户签约记录的编号。（只有签约成功时才会返回）
    
    private String zm_open_id;                  //用户的芝麻信用openId，供商户查询用户芝麻信用使用。（只有签约成功时才返回）
    
    private String alipay_logon_id;             //返回脱敏的支付宝账号。
    
    private String zm_score;                    //
    
    private String login_token;                 //
    
    private String device_id;                   //
    
    private String credit_auth_mode;            //授信模式，取值：DEDUCT_HUAZHI-花芝GO。	
    
    private String specified_sort_assets;       //
    
    private String modify_type;                 //

    public String getInvalid_time() {
        return invalid_time;
    }

    public void setInvalid_time(String invalid_time) {
        this.invalid_time = invalid_time;
    }

    public String getSign_scene() {
        return sign_scene;
    }

    public void setSign_scene(String sign_scene) {
        this.sign_scene = sign_scene;
    }

    public String getSign_time() {
        return sign_time;
    }

    public void setSign_time(String sign_time) {
        this.sign_time = sign_time;
    }

    public String getAlipay_user_id() {
        return alipay_user_id;
    }

    public void setAlipay_user_id(String alipay_user_id) {
        this.alipay_user_id = alipay_user_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getForex_eligible() {
        return forex_eligible;
    }

    public void setForex_eligible(String forex_eligible) {
        this.forex_eligible = forex_eligible;
    }

    public String getExternal_logon_id() {
        return external_logon_id;
    }

    public void setExternal_logon_id(String external_logon_id) {
        this.external_logon_id = external_logon_id;
    }

    public String getAuth_app_id() {
        return auth_app_id;
    }

    public void setAuth_app_id(String auth_app_id) {
        this.auth_app_id = auth_app_id;
    }

    public String getExternal_agreement_no() {
        return external_agreement_no;
    }

    public void setExternal_agreement_no(String external_agreement_no) {
        this.external_agreement_no = external_agreement_no;
    }

    public String getPersonal_product_code() {
        return personal_product_code;
    }

    public void setPersonal_product_code(String personal_product_code) {
        this.personal_product_code = personal_product_code;
    }

    public String getValid_time() {
        return valid_time;
    }

    public void setValid_time(String valid_time) {
        this.valid_time = valid_time;
    }

    public String getAgreement_no() {
        return agreement_no;
    }

    public void setAgreement_no(String agreement_no) {
        this.agreement_no = agreement_no;
    }

    public String getZm_open_id() {
        return zm_open_id;
    }

    public void setZm_open_id(String zm_open_id) {
        this.zm_open_id = zm_open_id;
    }

    public String getAlipay_logon_id() {
        return alipay_logon_id;
    }

    public void setAlipay_logon_id(String alipay_logon_id) {
        this.alipay_logon_id = alipay_logon_id;
    }

    public String getZm_score() {
        return zm_score;
    }

    public void setZm_score(String zm_score) {
        this.zm_score = zm_score;
    }

    public String getLogin_token() {
        return login_token;
    }

    public void setLogin_token(String login_token) {
        this.login_token = login_token;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getCredit_auth_mode() {
        return credit_auth_mode;
    }

    public void setCredit_auth_mode(String credit_auth_mode) {
        this.credit_auth_mode = credit_auth_mode;
    }

    public String getSpecified_sort_assets() {
        return specified_sort_assets;
    }

    public void setSpecified_sort_assets(String specified_sort_assets) {
        this.specified_sort_assets = specified_sort_assets;
    }

    public String getModify_type() {
        return modify_type;
    }

    public void setModify_type(String modify_type) {
        this.modify_type = modify_type;
    }
    
    
}
