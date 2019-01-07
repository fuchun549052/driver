package cn.yyb.driver.postBean;

/**
 * 密码登录请求bean
 */
public class PassLoginBean {
    private String Mobile;//手机号
    private String Password;//密码

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
