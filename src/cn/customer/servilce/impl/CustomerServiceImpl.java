package cn.customer.servilce.impl;

import java.util.List;

import cn.customer.dao.CustomerDao;
import cn.customer.dao.impl.CustomerDaoImpl;
import cn.customer.domain.Customer;
import cn.customer.domain.PageBean;
import cn.customer.domain.PageInfo;
import cn.customer.domain.PageResult;
import cn.customer.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    
    private CustomerDao dao = new CustomerDaoImpl();
    
    @Override
    public void addCustomer(Customer c) {
        dao.add(c);
    }
    @Override
    public void updateCustomer(Customer c) {
        dao.update(c);
    }
    @Override
    public Customer findCustomer(String id) {
        return dao.find(id);
    }
    @Override
    public void deleteCustomer(String id) {
        dao.delete(id);
    }
    @Override
    public List<Customer> findAllCustomer() {
        return dao.findAll();
    }
    
    @Override
    public PageBean getPageBean(PageInfo info) {
        PageResult pr = dao.getPageResult(info.getStartIndex(), info.getPageSize());
        PageBean bean = new PageBean();
        bean.setTotalRecord(pr.getTotalRecord());
        bean.setCurrentPage(info.getCurrentPage());
        bean.setPageSize(info.getPageSize());
        bean.setList(pr.getList());
        return bean;
    }
}
