package cn.yyb.driver.net;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/**
 * 网络请求工厂
 */
public class ServiceFactory {
    private final static ServiceManager manager = new ServiceManagerImpl();

    public static ServiceManager getServiceManager() {
        // TODO: 2018/4/18 暂时这样实现
        return manager;
    }

    public static void addOkHttpInterceptor(Interceptor interceptor){
        ((ServiceManagerImpl)manager).setmInterceptor(interceptor);
    }


    /**
     * 发现服务<br>
     * {@link ServiceManager#findApiService(Class,String)}
     */
    public static <T> T findApiService(Class<T> cla,String bearer) {
        return getServiceManager().findApiService(cla,bearer);
    }

    /**
     * 发现服务<br>
     * {@link ServiceManager#findApiService(Class, UrlEnum)}
     */
    public static <T> T findApiService(Class<T> cla, UrlEnum inMethod) {
        return getServiceManager().findApiService(cla, inMethod);
    }

    /**
     * 发现服务<br>
     * {@link ServiceManager#findApiService(Class, UrlEnum, String, OkHttpClient, Converter.Factory, CallAdapter.Factory,String)}
     */
    public static <T> T findApiService(Class<T> cla, UrlEnum inMethod, String tag, OkHttpClient client, Converter.Factory converFactory, CallAdapter.Factory callFactor,String bearer) {
        return getServiceManager().findApiService(cla, inMethod, tag, client, converFactory, callFactor,bearer);
    }

    /**
     * 移除缓存<br>
     * {@link ServiceManager#removeApiService(Class, String, UrlEnum)}
     */
    public static void removeApiService(Class<?> cla, String tag, UrlEnum inMethod) {
        getServiceManager().removeApiService(cla, tag, inMethod);
    }

}
