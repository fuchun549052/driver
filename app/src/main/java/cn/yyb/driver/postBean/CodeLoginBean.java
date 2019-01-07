package cn.yyb.driver.postBean;

/**
 * 验证码登录请求bean
 */
public class CodeLoginBean {
    private String Mobile;//手机号
    private String  VerifyCode;//短信验证码

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getVerifyCode() {
        return VerifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        VerifyCode = verifyCode;
    }
}
