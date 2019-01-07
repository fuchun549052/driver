package cn.yyb.driver.framework.rx;

import android.app.Dialog;


import cn.yyb.driver.framework.exception.ApiException;
import cn.yyb.driver.framework.exception.ExceptionEngine;
import rx.Subscriber;

public abstract class RxSubscriber<T> extends Subscriber<T> {

    private Dialog dialog;

    public RxSubscriber(){}


    public RxSubscriber(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (dialog != null && !dialog.isShowing()){
            dialog.show();
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        ApiException ex = ExceptionEngine.handleException(e);
        onFailure(ex.getMsg());
        onCompleted();
    }

    @Override
    public void onCompleted() {
        hideDialog();
    }

    private void hideDialog(){
        if (dialog != null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    protected abstract void onSuccess(T result);

    protected abstract void onFailure(String errorMsg);
}
