package cn.yyb.driver.my.message;


import cn.yyb.driver.postBean.SetReadBean;
import rx.Observable;

public interface MessageContract {

    interface IView {
    }

    interface IPresenter {
        void setRead();
    }

    interface IModel {
        Observable<String> setRead(SetReadBean bean);
    }

}
