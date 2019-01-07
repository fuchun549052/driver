package cn.yyb.driver.main;

import cn.yyb.driver.R;
import cn.yyb.driver.framework.mvp.MVPFragment;

/**
 * 首页fragment
 */
public class MainFragment extends MVPFragment<MainFragmentContract.IView,MainFragmentPresenter>{

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected MainFragmentPresenter createPresenter() {
        return new MainFragmentPresenter();
    }
}
