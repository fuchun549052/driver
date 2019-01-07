package cn.yyb.driver.my.message;


import cn.yyb.driver.net.apiservice.CommonApiService;
import cn.yyb.driver.net.ServiceFactory;
import cn.yyb.driver.postBean.SetReadBean;
import rx.Observable;

public class MessageModel implements MessageContract.IModel {

    @Override
    public Observable<String> setRead(SetReadBean bean) {
        return ServiceFactory.findApiService(CommonApiService.class,"").setRead(bean);
    }
}
