package cn.yyb.driver.login.presenter;


import cn.yyb.driver.login.contract.LoginContract;
import cn.yyb.driver.login.model.LoginModel;
import cn.yyb.driver.postBean.CodeLoginBean;
import cn.yyb.driver.postBean.GetSmsVerifyCodeBean;
import cn.yyb.driver.framework.mvp.MVPPresenter;
import cn.yyb.driver.framework.rx.RxSubscriber;
import cn.yyb.driver.utils.ToastUtil;

public class LoginPresenter extends MVPPresenter<LoginContract.IView, LoginModel>
        implements LoginContract.IPresenter {


    @Override
    protected LoginModel createModel() {
        return new LoginModel();
    }

    @Override
    protected void initData() {

    }

    //获取验证码
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
     * 验证码登录
     * @param phone 电话
     * @param code 验证码
     */
    @Override
    public void codeLogin(String phone, String code) {
        addSubscription(model.codeLogin(getCodeLoginBean(phone,code)), new RxSubscriber<String>() {
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
    private CodeLoginBean getCodeLoginBean(String phone,String code){
        CodeLoginBean bean=new CodeLoginBean();
        bean.setMobile(phone);
        bean.setVerifyCode(code);
        return bean;
    }
}