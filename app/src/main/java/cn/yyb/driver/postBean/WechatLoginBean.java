package cn.yyb.driver.postBean;

/**
 * 微信登录请求bean
 */
public class WechatLoginBean {
    private String  UnionId;//
    private String  OpenId;//
    private String  Country;//
    private String  Province;//
    private String  City;//
    private String  District;//
    private String  Sex;//
    private String  NickName;//
    private String  HeadImageUrl;//
    private String  SubscribeTime;//
    private String  SubscribeScene;//

    public WechatLoginBean(String unionId, String openId, String country, String province, String city, String district, String sex, String nickName, String headImageUrl, String subscribeTime, String subscribeScene) {
        UnionId = unionId;
        OpenId = openId;
        Country = country;
        Province = province;
        City = city;
        District = district;
        Sex = sex;
        NickName = nickName;
        HeadImageUrl = headImageUrl;
        SubscribeTime = subscribeTime;
        SubscribeScene = subscribeScene;
    }

    public String getUnionId() {
        return UnionId;
    }

    public void setUnionId(String unionId) {
        UnionId = unionId;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getHeadImageUrl() {
        return HeadImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        HeadImageUrl = headImageUrl;
    }

    public String getSubscribeTime() {
        return SubscribeTime;
    }

    public void setSubscribeTime(String subscribeTime) {
        SubscribeTime = subscribeTime;
    }

    public String getSubscribeScene() {
        return SubscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        SubscribeScene = subscribeScene;
    }
}
