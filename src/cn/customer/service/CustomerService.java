package cn.customer.service;

import java.util.List;

import cn.customer.domain.Customer;
import cn.customer.domain.PageBean;
import cn.customer.domain.PageInfo;

public interface CustomerService {

    void addCustomer(Customer c);

    void updateCustomer(Customer c);
    
    Customer findCustomer(String id);
    
    void deleteCustomer(String id);

    List<Customer> findAllCustomer();

    PageBean getPageBean(PageInfo info);

}