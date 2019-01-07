package cn.yyb.driver.main;


import cn.yyb.driver.framework.mvp.MVPPresenter;

public class MainFragmentPresenter extends MVPPresenter<MainFragmentContract.IView, MainFragmentModel>
        implements MainFragmentContract.IPresenter {


    @Override
    protected MainFragmentModel createModel() {
        return new MainFragmentModel();
    }

    @Override
    protected void initData() {

    }

}