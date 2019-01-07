package cn.yyb.driver.shop;

import cn.yyb.driver.R;
import cn.yyb.driver.framework.mvp.MVPFragment;

/**
 * 首页fragment
 */
public class ShopFragment extends MVPFragment<ShopFragmentContract.IView,ShopFragmentPresenter>{

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected ShopFragmentPresenter createPresenter() {
        return new ShopFragmentPresenter();
    }
}
