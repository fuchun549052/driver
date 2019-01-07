package cn.yyb.driver.login.contract;

import cn.yyb.driver.postBean.GetSmsVerifyCodeBean;
import cn.yyb.driver.postBean.LoginBean;
import rx.Observable;

public interface RegisterContract {

    interface IView {
        void startTimer();
    }

    interface IPresenter {
        void getSmsVerifyCode(String phone);
        void smsVerifyCodeLogin(String phone,String code,String pass,String invite);
    }

    interface IModel {

        Observable<String> smsVerifyCodeLogin(LoginBean params);
        Observable<String> getSmsVerifyCode(GetSmsVerifyCodeBean params);
    }

}
