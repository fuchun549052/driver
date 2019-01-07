package cn.yyb.driver.framework.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.yyb.driver.framework.transformer.SwitchSchedulers;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by chengwen on 2017-11-28.
 */
public abstract class MVPFragment<V, P extends MVPPresenter> extends Fragment {

    protected P presenter;
    protected Context mContext;
    private Unbinder unbinder;
    //Rx事件链处理器
    private CompositeSubscription mCompositeSubscription;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }
    /*
      跳转到支付页面进行主动的拦截 判断后台是否配置了副机可以进行结账
     */
    public void startActivity(Context cone,Class<?> clz){
            Intent intent = new Intent(cone,clz);
            cone.startActivity(intent);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = createPresenter();
        if (presenter!=null) presenter.attachView((V)this);
        initView2(view);
        initView();
        return view;
    }


    /**
     * 初始化布局
     */
    protected abstract int setLayoutId();

    /**
     * 初始化界面
     */
    protected abstract void initView();



    /**
     * 实例化Presenter
     */
    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unSubscribe();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
        if (null != unbinder) {
            unbinder.unbind();
        }
    }

    protected void initView2(View view){}

    //事件处理器
    protected <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .compose(new SwitchSchedulers<T>())
                .subscribe(subscriber));
    }

    //解除订阅
    protected void unSubscribe(){
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.clear();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser && isVisible()) {
            //控制切换Fragment时候延时加载数据
            lazyLoadData();
        }
    }

    //延时加载数据，需要重写此方法
    protected void lazyLoadData(){}


    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        Fragment fragment = getParentFragment();
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else {
            super.startActivityForResult(intent, requestCode);
        }
    }

}
