package cn.yyb.driver;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;

import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.yyb.driver.adapter.BaseFragmentPagerAdapter;
import cn.yyb.driver.framework.mvp.MVPActivity;
import cn.yyb.driver.framework.mvp.MVPPresenter;
import cn.yyb.driver.main.MainFragment;
import cn.yyb.driver.my.MyFragment;
import cn.yyb.driver.shop.ShopFragment;
import cn.yyb.driver.waybill.WaybillFragment;

public class MainActivity extends MVPActivity {


    @BindView(R.id.qmui_vp)
    QMUIViewPager qmuiVp;
    @BindView(R.id.qmui_tab)
    QMUITabSegment qmuiTab;
    @BindView(R.id.fist)
    LinearLayout fist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected LinearLayout setFistLayoutId() {
        return fist;
    }

    @Override
    protected void initView() {
        initPager();
        initTab();
    }

    //初始化pager
    private void initPager() {
        List<Fragment> fragments = new ArrayList<>();
        MainFragment mainFragment = new MainFragment();
        WaybillFragment waybillFragment = new WaybillFragment();
        ShopFragment shopFragment = new ShopFragment();
        MyFragment myFragment = new MyFragment();
        fragments.add(mainFragment);
        fragments.add(waybillFragment);
        fragments.add(shopFragment);
        fragments.add(myFragment);
        BaseFragmentPagerAdapter adapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        qmuiVp.setAdapter(adapter);
        qmuiTab.setupWithViewPager(qmuiVp);
    }

    //初始化底部tab
    private void initTab() {
        qmuiTab.setHasIndicator(false);
        QMUITabSegment.Tab main_tab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.mipmap.main),
                null, getResources().getString(R.string.main), true);
        QMUITabSegment.Tab waybill_tab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.mipmap.waybill),
                null, getResources().getString(R.string.waybill), true);
        QMUITabSegment.Tab shop_tab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.mipmap.shop),
                null, getResources().getString(R.string.shop), true);
        QMUITabSegment.Tab my_tab = new QMUITabSegment.Tab(
                ContextCompat.getDrawable(this, R.mipmap.my),
                null, getResources().getString(R.string.my), true);
        qmuiTab.replaceTab(0, main_tab);
        qmuiTab.replaceTab(1, waybill_tab);
        qmuiTab.replaceTab(2, shop_tab);
        qmuiTab.replaceTab(3, my_tab);
        qmuiTab.notifyDataChanged();
    }

    @Override
    protected MVPPresenter createPresenter() {
        return null;
    }

}
