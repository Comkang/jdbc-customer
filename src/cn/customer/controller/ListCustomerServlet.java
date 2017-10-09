package cn.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.customer.domain.PageBean;
import cn.customer.domain.PageInfo;
import cn.customer.service.CustomerService;
import cn.customer.servilce.impl.CustomerServiceImpl;
import cn.customer.utils.WebUtils;

public class ListCustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    /*CustomerService service = new CustomerServiceImpl();
	    List<Customer> list = service.findAllCustomer();
	    request.setAttribute("list", list);
	    request.getRequestDispatcher("/WEB-INF/jsp/listCustomer.jsp").forward(request, response);*/
	    try{
	    //封装分页请求数据到PageInfo对象中
	    PageInfo info = WebUtils.request2Bean(request, PageInfo.class);
	    CustomerService service = new CustomerServiceImpl();
	    PageBean bean = service.getPageBean(info);
	    request.setAttribute("bean", bean);
	    request.getRequestDispatcher("/WEB-INF/jsp/listCustomer.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
