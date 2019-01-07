package cn.yyb.driver.login.presenter;


import cn.yyb.driver.framework.mvp.MVPPresenter;
import cn.yyb.driver.login.contract.PassLoginContract;
import cn.yyb.driver.login.model.PassLoginModel;

public class PassLoginPresenter extends MVPPresenter<PassLoginContract.IView, PassLoginModel>
        implements PassLoginContract.IPresenter {


    @Override
    protected PassLoginModel createModel() {
        return new PassLoginModel();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void passwordLogin(String phone, String pass) {

    }
}