package cn.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.customer.service.CustomerService;
import cn.customer.servilce.impl.CustomerServiceImpl;

public class DeleteCustomerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String id = request.getParameter("id");
	    CustomerService service = new CustomerServiceImpl();
	    service.deleteCustomer(id);
	    request.getRequestDispatcher("/WEB-INF/jsp/listCustomer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
