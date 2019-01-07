package cn.yyb.driver.net.apiservice;

import cn.yyb.driver.net.UrlEnum;
import cn.yyb.driver.net.YUrl;
import cn.yyb.driver.postBean.BankCardAddBean;
import cn.yyb.driver.postBean.BankCardDeleteBean;
import cn.yyb.driver.postBean.BankCardListBean;
import cn.yyb.driver.postBean.DriverAddBean;
import cn.yyb.driver.postBean.SetReadBean;
import cn.yyb.driver.postBean.UsualLineAddBean;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 个人中心相关网络请求服务接口
 */
@YUrl(UrlEnum.URL)
public interface PersonalApiService {

    /**
     * 添加银行卡
     */
    @POST("BankCard/Add")
    Observable<String> add(@Body BankCardAddBean bean);

    /**
     * 删除银行卡
     */
    @POST("BankCard/Delete")
    Observable<String> delete(@Body BankCardDeleteBean bean);

    /**
     * 我的银行卡列表
     */
    @POST("BankCard/List")
    Observable<String> list(@Body BankCardListBean bean);

    /**
     * 添加司机常用路线
     */
    @POST("UsualLine/Add")
    Observable<String> usualLineAdd(@Body UsualLineAddBean bean);

    /**
     * 修改常用路线
     */
    @POST("UsualLine/Edit")
    Observable<String> usualLineEdit(@Body UsualLineAddBean bean);

    /**
     * 删除常用路线
     */
    @POST("UsualLine/Delete")
    Observable<String> usualLineDelete(@Body BankCardDeleteBean bean);

    /**
     * 设为已读
     */
    @POST("Message/SetRead")
    Observable<String> setRead(@Body SetReadBean bean);

    /**
     * 提交认证信息（司机）
     */
    @POST("UserAuth/Driver/Add")
    Observable<String> driverAdd(@Body DriverAddBean bean);

    /**
     * 用户基本信息
     */
    @POST("UserIndex/BaseInfo")
    Observable<String> baseInfo();

}
