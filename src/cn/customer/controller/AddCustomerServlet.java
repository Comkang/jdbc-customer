package cn.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.customer.domain.Customer;
import cn.customer.service.CustomerService;
import cn.customer.servilce.impl.CustomerServiceImpl;
import cn.customer.utils.WebUtils;

public class AddCustomerServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.setAttribute("sex", WebUtils.sex);
	    request.setAttribute("hobbies", WebUtils.hobbies);
	    request.setAttribute("type", WebUtils.type);
	    //请求转发到新增客户界面
	    request.getRequestDispatcher("/WEB-INF/jsp/addCustomer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    try {
	        Customer customer = WebUtils.request2Bean(request, Customer.class);
	        customer.setId(WebUtils.getUUID());
	        CustomerService service = new CustomerServiceImpl();
	        service.addCustomer(customer);
	        request.setAttribute("message", "添加成功");
	        request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            //如果发生异常
            request.setAttribute("message", "添加失败");
            request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
        }
	}

}
