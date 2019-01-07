package cn.yyb.driver.login.contract;

import cn.yyb.driver.postBean.GetSmsVerifyCodeBean;
import cn.yyb.driver.postBean.PassLoginBean;
import rx.Observable;

public interface PassLoginContract {

    interface IView {
    }

    interface IPresenter {
        void passwordLogin(String phone,String pass);
    }

    interface IModel {

        Observable<String> passwordLogin(PassLoginBean params);
    }

}
