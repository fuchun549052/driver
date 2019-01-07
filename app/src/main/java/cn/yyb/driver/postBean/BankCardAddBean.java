package cn.yyb.driver.postBean;

/**
 * 添加银行卡请求bean
 */
public class BankCardAddBean {
    private String  bankcode;//银行类型
    private String  bankcardnumber;//银行账号

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getBankcardnumber() {
        return bankcardnumber;
    }

    public void setBankcardnumber(String bankcardnumber) {
        this.bankcardnumber = bankcardnumber;
    }
}
