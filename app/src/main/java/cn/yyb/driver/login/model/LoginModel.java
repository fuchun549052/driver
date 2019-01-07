package cn.yyb.driver.login.model;

import cn.yyb.driver.login.contract.LoginContract;
import cn.yyb.driver.postBean.CodeLoginBean;
import cn.yyb.driver.postBean.GetSmsVerifyCodeBean;
import cn.yyb.driver.net.apiservice.CommonApiService;
import cn.yyb.driver.net.ServiceFactory;
import rx.Observable;

public class LoginModel implements LoginContract.IModel {

    @Override
    public Observable<String> getSmsVerifyCode(GetSmsVerifyCodeBean bean) {
        return ServiceFactory.findApiService(CommonApiService.class,"").getSmsVerifyCode(bean);
    }

    @Override
    public Observable<String> codeLogin(CodeLoginBean params) {
        return ServiceFactory.findApiService(CommonApiService.class,"").codeLogin(params);
    }
}
