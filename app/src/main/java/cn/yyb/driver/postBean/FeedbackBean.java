package cn.yyb.driver.postBean;

/**
 * 添加意见反馈请求bean
 */
public class FeedbackBean {
    private String FeedbackTypeCode;//反馈类型编码
    private String Contact;//联系人
    private String Telephone;//联系方式
    private String Content;//反馈内容

    public FeedbackBean(String feedbackTypeCode, String contact, String telephone, String content) {
        FeedbackTypeCode = feedbackTypeCode;
        Contact = contact;
        Telephone = telephone;
        Content = content;
    }

    public String getFeedbackTypeCode() {
        return FeedbackTypeCode;
    }

    public void setFeedbackTypeCode(String feedbackTypeCode) {
        FeedbackTypeCode = feedbackTypeCode;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
