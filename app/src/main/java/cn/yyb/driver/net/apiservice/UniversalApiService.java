package cn.yyb.driver.net.apiservice;

import cn.yyb.driver.net.UrlEnum;
import cn.yyb.driver.net.YUrl;
import cn.yyb.driver.postBean.ConfigDataBean;
import cn.yyb.driver.postBean.DeviceTokenBean;
import cn.yyb.driver.postBean.FeedbackBean;
import cn.yyb.driver.postBean.GetUploadPolicyBean;
import cn.yyb.driver.postBean.ProductDetailsBean;
import cn.yyb.driver.postBean.ProductListBean;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 通用相关网络请求服务接口
 */
@YUrl(UrlEnum.URL)
public interface UniversalApiService {

    /**
     * 获取上传策略
     */
    @POST("Upload/GetUploadPolicy")
    Observable<String> getUploadPolicy(@Body GetUploadPolicyBean bean);

    /**
     * 添加意见反馈
     */
    @POST("Feedback/Add")
    Observable<String> feedbackAdd(@Body FeedbackBean bean);

    /**
     * 获取配置信息列表
     */
    @POST("ConfigData/List")
    Observable<String> configData(@Body ConfigDataBean bean);

    /**
     * 绑定友盟推送信息
     */
    @POST("Push/BindDeviceToken")
    Observable<String> bindDeviceToken(@Body DeviceTokenBean bean);

}
