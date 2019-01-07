package cn.yyb.driver.login.model;

import cn.yyb.driver.login.contract.RegisterContract;
import cn.yyb.driver.net.apiservice.CommonApiService;
import cn.yyb.driver.net.ServiceFactory;
import cn.yyb.driver.postBean.GetSmsVerifyCodeBean;
import cn.yyb.driver.postBean.LoginBean;
import rx.Observable;

public class RegisterModel implements RegisterContract.IModel {

    @Override
    public Observable<String> smsVerifyCodeLogin(LoginBean params) {
        return ServiceFactory.findApiService(CommonApiService.class,"").register(params);
    }

    @Override
    public Observable<String> getSmsVerifyCode(GetSmsVerifyCodeBean bean) {
        return ServiceFactory.findApiService(CommonApiService.class,"").getSmsVerifyCode(bean);
    }
}
