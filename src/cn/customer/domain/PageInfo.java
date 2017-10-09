package cn.customer.domain;

public class PageInfo {
    private int currentPage = 1; //当前浏览的页数
    private int pageSize = 5; //每页显示的条数
    private int startIndex; //开始查询数
    
    public int getStartIndex() {
        this.startIndex = (this.currentPage - 1)*this.pageSize;
        return startIndex;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    
}
