package cn.customer.domain;

import java.util.Arrays;
import java.util.List;

public class PageBean {
    private int totalRecord; //总记录数
    private int pageSize; //每页显示数
    private int currentPage; //当前浏览的页数
    private int previousPage; //上一页
    private int nextPage; //下一页
    private int totalPages; //总页数
    private List list;
    private int[] pageBar;
    
    public int getTotalRecord() {
        return totalRecord;
    }
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
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
    public int getPreviousPage() {
        
        if(this.currentPage - 1 < 1) {
            this.previousPage = 1;
        } else {
            this.previousPage = this.currentPage - 1;
        }
        return previousPage;
    }
    public int getNextPage() {
        if(this.currentPage + 1 > this.totalPages) {
            this.nextPage = this.totalPages;
        } else {
            this.nextPage = this.currentPage + 1;
        }
        return nextPage;
    }
    public int getTotalPages() {
        if(this.totalRecord % this.pageSize == 0) {
            this.totalPages = this.totalRecord/this.pageSize;
        } else {
            this.totalPages = this.totalRecord/this.pageSize + 1; 
        }
        return totalPages;
    }
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
    public int[] getPageBar() {
        /*int[] pageBar = new int[this.totalPages];
        for(int i=1; i<=this.totalPages; i++) {
            pageBar[i-1] = i;
        }
        this.pageBar = pageBar;
        return pageBar;*/
        int startPage;
        int endPage;
        int[] pageBar = null;
        if(this.totalPages<=10) {
            pageBar = new int[this.totalPages];
            startPage = 1;
            endPage = this.totalPages;
        }else{
            pageBar = new int[10];
            startPage = this.currentPage - 4;
            endPage = this.currentPage + 5;
            
            //总页数=30      3    -1
            //总页数=30      29   34   21   30
            if(startPage<1){
                startPage = 1;
                endPage = 10;
            }
            
            if(endPage>this.totalPages){
                endPage = this.totalPages;
                startPage = this.totalPages - 9;
            }
        }
        
        int index = 0;
        for(int i=startPage;i<=endPage;i++){
            pageBar[index++] = i;
        }
        
        this.pageBar = pageBar;
        return this.pageBar;
        
    }
    @Override
    public String toString() {
        return "PageBean [totalRecord=" + totalRecord + ", pageSize=" + pageSize + ", currentPage=" + currentPage
                + ", previousPage=" + previousPage + ", nextPage=" + nextPage + ", totalPages=" + totalPages + ", list="
                + list + ", pageBar=" + Arrays.toString(pageBar) + "]";
    }
    
    
    
    
}
