package cn.yyb.driver.login.presenter;


import cn.yyb.driver.framework.mvp.MVPPresenter;
import cn.yyb.driver.framework.rx.RxSubscriber;
import cn.yyb.driver.login.contract.PassLoginContract;
import cn.yyb.driver.login.contract.RegisterContract;
import cn.yyb.driver.login.model.PassLoginModel;
import cn.yyb.driver.login.model.RegisterModel;
import cn.yyb.driver.postBean.GetSmsVerifyCodeBean;
import cn.yyb.driver.postBean.LoginBean;
import cn.yyb.driver.utils.ToastUtil;

public class RegisterPresenter extends MVPPresenter<RegisterContract.IView, RegisterModel>
        implements RegisterContract.IPresenter {


    @Override
    protected RegisterModel createModel() {
        return new RegisterModel();
    }

    @Override
    protected void initData() {

    }


    /**
     * 获取验证码
     * @param phone 电话
     */
    @Override
    public void getSmsVerifyCode(String phone) {
        addSubscription(model.getSmsVerifyCode(getMap(phone)), new RxSubscriber<String>() {
            @Override
            protected void onSuccess(String result) {
                view.startTimer();
            }

            @Override
            protected void onFailure(String errorMsg) {
                ToastUtil.showShortToast(errorMsg);
            }
        });
    }

    /**
     * 注册登录
     * @param phone 电话
     * @param code  验证码
     * @param pass  密码
     * @param invite 邀请码
     */
    @Override
    public void smsVerifyCodeLogin(String phone, String code, String pass, String invite) {
        addSubscription(model.smsVerifyCodeLogin(new LoginBean(phone,pass,code)), new RxSubscriber<String>() {
            @Override
            protected void onSuccess(String result) {
            }

            @Override
            protected void onFailure(String errorMsg) {
                ToastUtil.showShortToast(errorMsg);
            }
        });
    }

    private GetSmsVerifyCodeBean getMap(String phone){
        GetSmsVerifyCodeBean bean=new GetSmsVerifyCodeBean();
        bean.setMobile(phone);
        bean.setBusinessCode("FastLogin");
        return bean;
    }
}