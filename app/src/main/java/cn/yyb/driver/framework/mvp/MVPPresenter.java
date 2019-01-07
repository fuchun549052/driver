package cn.yyb.driver.framework.mvp;


import android.content.Context;
import android.content.Intent;

import cn.yyb.driver.framework.transformer.SwitchSchedulers;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by chengwen on 2017-11-18.
 */
public abstract class MVPPresenter<V, M> implements MVP.Presenter<V> {

    protected V view;
    protected M model;

    //网络请求处理器
    private CompositeSubscription mCompositeSubscription;

    protected MVPPresenter() {
    }

    @Override
    public void attachView(V view) {
        this.view = view;
        this.model = createModel();
        initData();
    }

    /*
      跳转
     */
    public void startActivity(Context cone, Class<?> clz) {
            Intent in = new Intent(cone, clz);
            cone.startActivity(in);
    }

    @Override
    public void detachView() {
        this.view = null;
        this.model = null;
        unSubscribe();
    }

    protected abstract M createModel();

    protected abstract void initData();

    //事件处理器
    protected <T> void addSubscription(Observable<T> observable, Subscriber<T> subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .compose(new SwitchSchedulers<T>())
                .subscribe(subscriber));
    }

    protected <T, R> void addSubscription(Observable<T> observable, Observable.Transformer<T, R> transformer, Subscriber<R> subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .compose(new SwitchSchedulers<T>())
                .compose(transformer)
                .subscribe(subscriber));
    }

    //注销当前事件
    protected void unSubscribe(){
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.clear();
        }
    }
}
