package cn.yyb.driver.postBean;

/**
 * 获取验证码 bean
 */
public class GetSmsVerifyCodeBean {
    private String Mobile;//手机号
    //业务类型,FastLogin:验证码登录,FindPassword:找回密码,SetPassword:设置密码（未设置密码的用户个人中心通过手机号设置/修改密码）
    //WechatBind:微信绑定手机号时获取短信验证码
    private String BusinessCode;

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getBusinessCode() {
        return BusinessCode;
    }

    public void setBusinessCode(String businessCode) {
        BusinessCode = businessCode;
    }
}
