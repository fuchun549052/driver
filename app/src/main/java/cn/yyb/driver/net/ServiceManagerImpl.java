package cn.yyb.driver.net;

import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;


import com.qmuiteam.qmui.util.QMUIPackageHelper;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.yyb.driver.application.BaseApplication;
import cn.yyb.driver.framework.exception.ApiException;
import cn.yyb.driver.net.converter.FastJsonConverterFactory;
import cn.yyb.driver.net.interceptor.LoggingInterceptor;
import cn.yyb.driver.utils.StringUtils;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


/**
 * 服务管理类
 */
public class ServiceManagerImpl implements ServiceManager {
    /**
     * 缓存接口
     */
    private final Map<String, Object> cacheMap = new LinkedHashMap<>();
    private Interceptor mInterceptor;
    public void setmInterceptor(Interceptor mInterceptor) {
        this.mInterceptor = mInterceptor;
    }


    @Override
    public <T> T findApiService(Class<T> cla,String bearer) {
        return findApiService(cla, null, null, null, null, null,bearer);
    }

    @Override
    public <T> T findApiService(Class<T> cla, UrlEnum inMethod) {
        return findApiService(cla, inMethod, null, null, null, null,null);
    }

    @Override
    public <T> T findApiService(Class<T> cla, UrlEnum inMethod, String tag, OkHttpClient client, Converter.Factory converFactory, CallAdapter.Factory callFactor,String bearer) {

        String key = getKey(cla, tag, inMethod);
        T t = (T) cacheMap.get(key);
        if (null != t) {
            return t;
        }

        if (null == inMethod) {//调用的是接口上的注解url
            //Type 注解
            Annotation[] annotation = cla.getAnnotations();
            if (null != annotation && annotation.length > 0) {
                for (Annotation sub : annotation) {
                    if (sub instanceof YUrl) {
                        YUrl yUrl = (YUrl) sub;
                        t = addCache(cla, client, converFactory, callFactor, key, yUrl.value().getUrl(),bearer);
                        return t;
                    }
                }

            }
        } else {
            t = addCache(cla, client, converFactory, callFactor, key, inMethod.getUrl(),bearer);
            return t;

        }

        throw new ApiException("请在接口中加入注解 YUrl");
    }



    @Override
    public void removeApiService(Class<?> cla, String tag, UrlEnum inMethod) {
        String key = getKey(cla, tag, inMethod);
        cacheMap.remove(key);
    }


    @NonNull
    private String getKey(Class<?> cla, String tag, UrlEnum inMethod) {
        return cla.getSimpleName() + (null == tag ? "" : tag) + (null == inMethod ? "" : inMethod.name());
    }

    private <T> T addCache(Class<T> cla, OkHttpClient client, Converter.Factory converFactory, CallAdapter.Factory callFactor, String key, String baseUrl,String bearer) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(null == client ? getClient(bearer) : client)
                .baseUrl(baseUrl)
                .addConverterFactory(null == converFactory ? FastJsonConverterFactory.create() : converFactory)
                .addCallAdapterFactory(null == callFactor ? RxJavaCallAdapterFactory.create() : callFactor)
                .build();
        T t = retrofit.create(cla);
        cacheMap.put(key, t);
        return t;
    }

    //构造client
    public static OkHttpClient getClient(final String  bearer) {
        // 指定缓存路径,缓存大小10Mb
        Cache cache = new Cache(getSDKRootDir(BaseApplication.application, "driver/HttpCache"),
                1024 * 1024 * 10);
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .cache(cache)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                ;
            client.addInterceptor(new LoggingInterceptor());
        if (StringUtils.isBlank(bearer)){
            client.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            .addHeader("AppVersion", QMUIPackageHelper.getAppVersion(BaseApplication.getAppContext()))
                            .addHeader("Content-Type", "application/json")
                            .addHeader("AppId", "driver_android_app")
                            .addHeader("ApiVersion", "1")
                            .addHeader("ClientOS", "Android")
                            .addHeader("DeviceName", android.os.Build.MANUFACTURER)
                            .addHeader("DeviceType", android.os.Build.MODEL)
                            .addHeader("DeviceId", android.os.Build.SERIAL)
                            .addHeader("AppChannel", "")
                            .addHeader("Timestamp", String.valueOf(System.currentTimeMillis()))
                            .addHeader("ClientOSVersion", "")
                            .addHeader("Signature", "")
                            .build();
                    return chain.proceed(request);
                }
            });
        }else {
            client.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            .addHeader("AppVersion", QMUIPackageHelper.getAppVersion(BaseApplication.getAppContext()))
                            .addHeader("Content-Type", "application/json")
                            .addHeader("AppId", "driver_android_app")
                            .addHeader("ApiVersion", "1")
                            .addHeader("ClientOS", "Android")
                            .addHeader("DeviceName", android.os.Build.MANUFACTURER)
                            .addHeader("DeviceType", android.os.Build.MODEL)
                            .addHeader("DeviceId", android.os.Build.SERIAL)
                            .addHeader("AppChannel", "")
                            .addHeader("Timestamp", String.valueOf(System.currentTimeMillis()))
                            .addHeader("ClientOSVersion", "")
                            .addHeader("Signature", "")
                            .addHeader("Authorization", "Bearer "+bearer)
                            .build();
                    return chain.proceed(request);
                }
            });
        }
        return client.build();
    }

    /**
     * 创建sdCard跟目录下的文件或者应用内文件
     *
     * @param context    context
     * @param uniqueName 文件夹名称
     * @return 根路径下的文件夹
     * @author xuhaijiang
     * @since 2015年9月28日下午3:04:55
     */
    public static File getSDKRootDir(Context context, String uniqueName) {
        String cachePath = Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable() ? Environment
                .getExternalStorageDirectory().getPath() : context.getCacheDir().getPath();
        File file = new File(cachePath + File.separator + uniqueName);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;

    }

}
