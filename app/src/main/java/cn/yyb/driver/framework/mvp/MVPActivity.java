package cn.yyb.driver.framework.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import butterknife.ButterKnife;
import cn.yyb.driver.R;
import cn.yyb.driver.framework.transformer.SwitchSchedulers;
import cn.yyb.driver.utils.AppManager;
import cn.yyb.driver.utils.Util;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by chengwen on 2017-11-18.
 */
public abstract class MVPActivity<V, P extends MVPPresenter> extends AppCompatActivity {

    protected P presenter;

    //Rx事件链处理器
    private CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        hideBar();
        super.onCreate(savedInstanceState);
        int layoutId = setLayoutId();
        QMUIStatusBarHelper.translucent(this);
        if (0 != layoutId) {
            View root = LayoutInflater.from(this).inflate(layoutId, null);
            ButterKnife.bind(this,root);
            setContentView(root);
        }
        initView();
        setTolBar();
        presenter = createPresenter();
        if (presenter!=null) presenter.attachView((V)this);
        AppManager.getAppManager().addActivity(this);
    }

    public void startActivity(Context cone, Class<?> clz){
            Intent in = new Intent(cone,clz);
            startActivity(in);
    }

    private void setTolBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this); // 激活状态栏
            tintManager.setNavigationBarTintEnabled(true); //设置系统栏设置颜色
            tintManager.setNavigationBarTintResource(R.color.color_333333);
            tintManager.setNavigationBarTintColor(R.color.color_15D075);
        }
    }

    protected void hideBar() {
        View decorView = getWindow().getDecorView();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setWindowFlags();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //设置第一个view距离状态栏的高度；
        LinearLayout linearLayout=setFistLayoutId();
        if (null==linearLayout){
            return;
        }
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();//rlLinearLayout为遮挡住的页面布局LinearLayout
        int top = Util.getStatusBarHeight(this);//获取状态栏高度
        lp.topMargin = top;
        linearLayout.setLayoutParams(lp);
    }

    protected void setWindowFlags() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 设置布局
     */
    protected abstract int setLayoutId();

    /**
     * 设置布局第一个view
     */
    protected abstract LinearLayout setFistLayoutId();

    /**
     * 初始化界面
     */
    protected abstract void initView();

    /**
     * 实例化Presenter
     */
    protected abstract P createPresenter();

    //事件处理器
    protected <T> void addSubscription(Observable<T> observable, Action1<T> action1) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .compose(new SwitchSchedulers<T>())
                .subscribe(action1));
    }

    //事件处理器
    protected <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .compose(new SwitchSchedulers<T>())
                .subscribe(subscriber));
    }

    @Override
    protected void onDestroy() {
        unSubscribe();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
        AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }

    //解除订阅
    protected void unSubscribe(){
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.clear();
        }
    }
}
