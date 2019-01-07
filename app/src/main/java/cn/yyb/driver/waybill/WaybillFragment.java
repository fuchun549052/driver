package cn.yyb.driver.waybill;

import cn.yyb.driver.R;
import cn.yyb.driver.framework.mvp.MVPFragment;

/**
 * 首页fragment
 */
public class WaybillFragment extends MVPFragment<WaybillFragmentContract.IView,WaybillFragmentPresenter>{

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected WaybillFragmentPresenter createPresenter() {
        return new WaybillFragmentPresenter();
    }
}
