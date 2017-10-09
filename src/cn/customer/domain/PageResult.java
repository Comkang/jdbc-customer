package cn.customer.domain;

import java.util.List;

public class PageResult {
    private int totalRecord; //总条数
    private List list; //结果集
    public int getTotalRecord() {
        return totalRecord;
    }
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
    public List getList() {
        return list;
    }
    public void setList(List list) {
        this.list = list;
    }
    
    
}
