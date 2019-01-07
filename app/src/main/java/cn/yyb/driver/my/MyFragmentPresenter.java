package cn.yyb.driver.my;


import cn.yyb.driver.framework.mvp.MVPPresenter;

public class MyFragmentPresenter extends MVPPresenter<MyFragmentContract.IView, MyFragmentModel>
        implements MyFragmentContract.IPresenter {


    @Override
    protected MyFragmentModel createModel() {
        return new MyFragmentModel();
    }

    @Override
    protected void initData() {

    }

}