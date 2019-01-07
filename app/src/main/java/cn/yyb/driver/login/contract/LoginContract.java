package cn.yyb.driver.login.contract;

import cn.yyb.driver.postBean.CodeLoginBean;
import cn.yyb.driver.postBean.GetSmsVerifyCodeBean;
import rx.Observable;

public interface LoginContract {

    interface IView {
        void startTimer();
    }

    interface IPresenter {
        void getSmsVerifyCode(String phone);

        void codeLogin(String phone,String code);
    }

    interface IModel {

        Observable<String> getSmsVerifyCode(GetSmsVerifyCodeBean params);

        Observable<String> codeLogin(CodeLoginBean params);
    }

}
