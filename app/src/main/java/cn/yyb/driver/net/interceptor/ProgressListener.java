package cn.yyb.driver.net.interceptor;

/**
 */
public interface ProgressListener {
    /**
     * 下载进度回调接口
     * @param currentBytes 当前下载的字节
     * @param contentLength 总字节长度
     * @param done
     */
    void onProgress(long currentBytes, long contentLength, boolean done);

}
