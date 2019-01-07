package cn.yyb.driver.net.interceptor;

import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 */
public class LoggingInterceptor implements Interceptor {

    private String TAG = getClass().getSimpleName();

    private final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody requestBody = request.body();

        String body = null;

        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }
            body = buffer.readString(charset);
        }

        Log.e(TAG, "发送请求");
        Log.e(TAG, "method:  " + request.method());
        Log.e(TAG, "url:     " + request.url());
        Log.e(TAG, "headers: " + request.headers());
        Log.e(TAG, "body:    " + request.body());
        Log.e(TAG, "请求body: " + body);
        Log.e(TAG, "----------------------------------");
        Log.e(TAG, "请求线程ID: " + android.os.Process.myTid());

        //开始时间
        long startNs = System.nanoTime();
        Response response = chain.proceed(request);
        //请求耗时
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        ResponseBody responseBody = response.body();
        String rBody = null;

        if (response != null) {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                try {
                    charset = contentType.charset(UTF8);
                } catch (UnsupportedCharsetException e) {
                    e.printStackTrace();
                }
            }
            rBody = buffer.clone().readString(charset);
        }
        Log.e(TAG, "收到响应");
        Log.e(TAG, "code:    " + response.code());
        Log.e(TAG, "message: " + response.message());
        Log.e(TAG, "响应时间: " + tookMs);
        Log.e(TAG, "响应body: " + rBody);
        return response;
    }


}
