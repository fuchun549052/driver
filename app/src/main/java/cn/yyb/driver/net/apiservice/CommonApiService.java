package cn.yyb.driver.net.apiservice;

import cn.yyb.driver.net.UrlEnum;
import cn.yyb.driver.net.YUrl;
import cn.yyb.driver.postBean.CodeLoginBean;
import cn.yyb.driver.postBean.GetSmsVerifyCodeBean;
import cn.yyb.driver.postBean.InviteCodeBindBean;
import cn.yyb.driver.postBean.LoginBean;
import cn.yyb.driver.postBean.PassLoginBean;
import cn.yyb.driver.postBean.SetReadBean;
import cn.yyb.driver.postBean.WechatLoginBean;
import cn.yyb.driver.postBean.WechatLoginBindBean;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 账号相关网络请求服务接口
 */
@YUrl(UrlEnum.URL)
public interface CommonApiService {

    /**
     * 获取验证码
     */
    @POST("Common/GetSmsVerifyCode")
    Observable<String> getSmsVerifyCode(@Body GetSmsVerifyCodeBean bean);

    /**
     * 密码登录
     */
    @POST("Account/PasswordLogin")
    Observable<String> passwordLogin(@Body PassLoginBean bean);


    /**
     * 验证码登录
     */
    @POST("Account/FastLogin")
    Observable<String> codeLogin(@Body CodeLoginBean bean);

    /**
     * token校验（是否有效）
     */
    @POST("AccessToken/Check")
    Observable<String> Check();

    /**
     * 注销登录
     */
    @POST("Account/Logout")
    Observable<String> logout();

    /**
     * 找回密码（修改密码）
     */
    @POST("Account/FindPassword")
    Observable<String> findPassword(@Body LoginBean bean);

    /**
     * 手机号，验证码注册并登录
     */
    @POST("Account/Register")
    Observable<String> register(@Body LoginBean bean);

    /**
     * 微信号授权成功后登录
     */
    @POST("Account/WechatLogin")
    Observable<String> wechatLogin(@Body WechatLoginBean bean);

    /**
     * 微信登录成功后绑定手机号
     */
    @POST("Account/WechatLoginBind")
    Observable<String> wechatLoginBind(@Body WechatLoginBindBean bean);

    /**
     * 微信登录成功后绑定手机号
     */
    @POST("Account/InviteCodeBind")
    Observable<String> inviteCodeBind(@Body InviteCodeBindBean bean);
}
