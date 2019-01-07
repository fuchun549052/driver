package cn.yyb.driver.waybill;


import cn.yyb.driver.framework.mvp.MVPPresenter;

public class WaybillFragmentPresenter extends MVPPresenter<WaybillFragmentContract.IView, WaybillFragmentModel>
        implements WaybillFragmentContract.IPresenter {


    @Override
    protected WaybillFragmentModel createModel() {
        return new WaybillFragmentModel();
    }

    @Override
    protected void initData() {

    }

}