package cn.yyb.driver.login.model;

import cn.yyb.driver.login.contract.PassLoginContract;
import cn.yyb.driver.net.apiservice.CommonApiService;
import cn.yyb.driver.net.ServiceFactory;
import cn.yyb.driver.postBean.PassLoginBean;
import rx.Observable;

public class PassLoginModel implements PassLoginContract.IModel {

    @Override
    public Observable<String> passwordLogin(PassLoginBean bean) {
        return ServiceFactory.findApiService(CommonApiService.class,"").passwordLogin(bean);
    }
}
