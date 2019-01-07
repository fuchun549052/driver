package cn.yyb.driver.net.apiservice;

import cn.yyb.driver.net.UrlEnum;
import cn.yyb.driver.net.YUrl;
import cn.yyb.driver.postBean.ProductDetailsBean;
import cn.yyb.driver.postBean.ProductListBean;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 积分商城相关网络请求服务接口
 */
@YUrl(UrlEnum.URL)
public interface MillApiService {

    /**
     * 获取商品分类
     */
    @POST("Mall/ProductCategory")
    Observable<String> productCategory();

    /**
     * 商品列表
     */
    @POST("Mall/ProductList")
    Observable<String> productList(@Body ProductListBean bean);

    /**
     * 获取商品详情
     */
    @POST("Mall/ProductDetails")
    Observable<String> productDetails(@Body ProductDetailsBean bean);

}
