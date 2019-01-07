package cn.yyb.driver.postBean;

/**
 * 微信登录绑定手机号请求bean
 */
public class WechatLoginBindBean {
    private String  UnionId;//
    private String  Mobile;//手机号
    private String  VerifyCode;//验证码
    private String  Password;//密码
    private String  InviteCode;//邀请码

    public WechatLoginBindBean(String unionId, String mobile, String verifyCode, String password, String inviteCode) {
        UnionId = unionId;
        Mobile = mobile;
        VerifyCode = verifyCode;
        Password = password;
        InviteCode = inviteCode;
    }

    public WechatLoginBindBean(String unionId, String mobile, String verifyCode, String password) {
        UnionId = unionId;
        Mobile = mobile;
        VerifyCode = verifyCode;
        Password = password;
    }

    public String getUnionId() {
        return UnionId;
    }

    public void setUnionId(String unionId) {
        UnionId = unionId;
    }

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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getInviteCode() {
        return InviteCode;
    }

    public void setInviteCode(String inviteCode) {
        InviteCode = inviteCode;
    }
}
