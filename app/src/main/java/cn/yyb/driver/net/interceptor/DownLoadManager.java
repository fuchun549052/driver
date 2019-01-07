package cn.yyb.driver.net.interceptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

/**
 * 文件下载管理器
 */
public class DownLoadManager {


    /**
     * 将下载的文件保存到对应的路径
     * @param body
     * @return
     */
    public static boolean writeResponseBodyToDisk(ResponseBody body, String path) {

        InputStream in = null;
        OutputStream out = null;
        try {
            File file = new File(path);

            byte[] fileReader = new byte[4096];

            in = body.byteStream();
            out = new FileOutputStream(file);

            while (true) {
                int read = in.read(fileReader);
                if (read == -1) {
                    break;
                }
                out.write(fileReader, 0, read);
            }
            out.flush();
            return true;
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
