package cn.yyb.driver.postBean;

/**
 * 获取商品列表请求bean
 */
public class ProductListBean {
    private int  CurrentPage;//当前分页
    private int  PageSize;//每页数量
    private int  CategoryId;//分类ID

    public ProductListBean(int currentPage, int pageSize, int categoryId) {
        CurrentPage = currentPage;
        PageSize = pageSize;
        CategoryId = categoryId;
    }

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

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }
}
