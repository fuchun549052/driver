package cn.yyb.driver.postBean;

/**
 * 我的银行卡列表请求bean、
 */
public class BankCardListBean {
    private int  CurrentPage;//当前页码，从1开始
    private int  PageSize;//每页条数

    public int getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        CurrentPage = currentPage;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }
}
