package cn.yyb.driver.postBean;

/**
 * 获取配置信息列表请求bean
 */
public class ConfigDataBean {
    private String  code;//类型编码:银行：BANK_CONFIG，意见反馈：FEEDBACKTYPE

    public String getCode() {
        return  code;
    }

    public void setCode(String deviceToken) {
        code = deviceToken;
    }
}
