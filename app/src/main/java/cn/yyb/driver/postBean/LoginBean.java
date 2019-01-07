package cn.yyb.driver.postBean;

/**
 * 手机号注册自动登录请求bean
 */
public class LoginBean {
    private String Mobile;//手机号
    private String Password;//密码
    private String VerifyCode;//验证码

    public LoginBean(String mobile, String password, String verifyCode) {
        Mobile = mobile;
        Password = password;
        VerifyCode = verifyCode;
    }

    public String getVerifyCode() {
        return VerifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        VerifyCode = verifyCode;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
