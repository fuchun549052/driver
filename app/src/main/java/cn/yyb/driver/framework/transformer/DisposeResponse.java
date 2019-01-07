package cn.yyb.driver.framework.transformer;

import cn.yyb.driver.framework.exception.ApiException;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by chengwen on 2017-11-18.
 * 用于预处理网络请求
 */
public class DisposeResponse<T> implements Observable.Transformer<T, T> {

    @Override
    public Observable<T> call(Observable<T> observable) {
        return observable.map(new Func1<T, T>() {
            @Override
            public T call(T t) {
                if (t != null) {
                    return t;
                }else{
                    throw new ApiException("数据请求失败！");
                }
            }
        });
    }
}
