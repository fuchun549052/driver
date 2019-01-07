package greendao.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * 用户信息表
 */
@Entity(nameInDb = "cn.yyb.driver.user")
public class UserBean {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "trueName")
    private String trueName;
    @Property(nameInDb = "score")
    private int score;//积分
    @Property(nameInDb = "money")
    private String money;//余额
    @Property(nameInDb = "headImageUrl")
    private String headImageUrl;//头像图片地址
    @Property(nameInDb = "authStatus")
    private int authStatus;
    @Property(nameInDb = "mobile")
    private String mobile;//电话号码
    @Property(nameInDb = "credit")
    private int credit;//信用分
    @Property(nameInDb = "isNewUser")
    private boolean isNewUser;//是否新用户
    @Property(nameInDb = "accessToken")
    private String accessToken;//token

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public void setAuthStatus(int authStatus) {
        this.authStatus = authStatus;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setIsNewUser(boolean isNewUser) {
        this.isNewUser = isNewUser;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTrueName() {
        return trueName;
    }

    public int getScore() {
        return score;
    }

    public String getMoney() {
        return money;
    }

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public int getAuthStatus() {
        return authStatus;
    }

    public String getMobile() {
        return mobile;
    }

    public int getCredit() {
        return credit;
    }

    public boolean isIsNewUser() {
        return isNewUser;
    }

    public String getAccessToken() {
        return accessToken;
    }
}