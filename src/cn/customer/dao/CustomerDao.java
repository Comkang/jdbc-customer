package cn.customer.dao;

import java.util.List;

import cn.customer.domain.Customer;
import cn.customer.domain.PageResult;

public interface CustomerDao {

    //1.新增一个客户
    void add(Customer c);

    //2.修改一个客户
    void update(Customer c);

    //3.删除一个客户
    void delete(String id);

    //4.查询一个客户
    Customer find(String id);

    //5.查询所有的客户
    List<Customer> findAll();
    
    //6.查询分页信息
    PageResult getPageResult(int startIndex, int pageSize);

}