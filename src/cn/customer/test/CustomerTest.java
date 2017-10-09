package cn.customer.test;

import java.util.Date;

import org.junit.Test;

import cn.customer.dao.CustomerDao;
import cn.customer.dao.impl.CustomerDaoImpl;
import cn.customer.domain.Customer;

public class CustomerTest {
    @Test
    public void test() {
        CustomerDao dao = new CustomerDaoImpl();
        for(int i=1; i<60; i++) {
            Customer c = new Customer();
            c.setId(i+"");
            c.setBirthday(new Date(60000));
            c.setCustomerName("张三" + i);
            c.setEmail(i + "aaa@163.com");
            c.setHobbies("唱歌，跳舞");
            c.setSex("男");
            c.setType("VIP");
            c.setRemark("我是中国人");
            dao.add(c);
        }
    }
    @Test
    public void test1(){
        
    }
}
