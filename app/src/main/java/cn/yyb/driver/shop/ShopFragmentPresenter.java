package cn.yyb.driver.shop;


import cn.yyb.driver.framework.mvp.MVPPresenter;

public class ShopFragmentPresenter extends MVPPresenter<ShopFragmentContract.IView, ShopFragmentModel>
        implements ShopFragmentContract.IPresenter {


    @Override
    protected ShopFragmentModel createModel() {
        return new ShopFragmentModel();
    }

    @Override
    protected void initData() {

    }

}