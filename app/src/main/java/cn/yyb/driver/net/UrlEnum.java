package cn.yyb.driver.net;


/**
 * url枚举
 * Created by fuchun on 2019/1/3.
 */

public enum UrlEnum {

    URL("http://118.25.63.165:5003/", "http://118.25.63.165:5003/", "http://yyb.jzreach.com/");


    private String dev;
    private String test;
    private String cloud;

    /**
     * @param dev   开发环境
     * @param test  测试
     * @param cloud 云端
     */

    UrlEnum(String dev, String test,  String cloud) {
        this.dev = dev;
        this.test = test;
        this.cloud = cloud;
    }

    public void setUrl(String dev, String test, String cloud) {
        this.dev = dev;
        this.test = test;
        this.cloud = cloud;
    }

    public final static int TYPE_DEV = 0;
    public final static int TYPE_TEST = 1;
    public final static int TYPE_CLOUD = 2;

    private int environment=TYPE_TEST;
    /**
     * @return 相应环境的url
     */
    public String getUrl() {
        switch (environment) {
            case TYPE_DEV:
                return dev;
            case TYPE_TEST:
                return test;
            case TYPE_CLOUD:
                return cloud;
            default:
                return cloud;
        }
    }
}
