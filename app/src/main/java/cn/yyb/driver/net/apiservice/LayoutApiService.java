package cn.yyb.driver.net.apiservice;

import cn.yyb.driver.net.UrlEnum;
import cn.yyb.driver.net.YUrl;
import cn.yyb.driver.postBean.BankCardDeleteBean;
import cn.yyb.driver.postBean.BankCardListBean;
import cn.yyb.driver.postBean.LayoutListBean;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 布局相关网络请求服务接口
 */
@YUrl(UrlEnum.URL)
public interface LayoutApiService {

    /**
     * 广告位数据
     */
    @POST("Layout/Adv")
    Observable<String> adv(@Body LayoutListBean bean);

    /**
     * 菜单信息
     */
    @POST("Layout/Menu")
    Observable<String> menu(@Body LayoutListBean bean);

}
