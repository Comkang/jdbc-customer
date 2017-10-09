<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table border="1" width="50%">
        <tr>
            <td>客户名称</td>
            <td>性别</td>
            <td>生日</td>
            <td>邮件</td>
            <td>爱好</td>
            <td>类型</td>
            <td>备注</td>
            <td>操作</td>
        </tr>
        <c:forEach var="customer" items="${bean.list}">
            <tr>
                <td>${customer.customerName}</td>
                <td>${customer.sex}</td>
                <td>${customer.birthday}</td>
                <td>${customer.email}</td>
                <td>${customer.hobbies}</td>
                <td>${customer.type}</td>
                <td>${customer.remark}</td>
                <td>
                    <a href="#">修改</a>
                    <a href="${pageContext.request.contextPath}/DeleteCustomerServlet?id=${customer.id}">删除</a>
                </td>
            </tr>
        
        </c:forEach>
    </table>
    <br>
    共${bean.totalRecord}条数据，每页显示<input type="text" id="pageSize" value="${bean.pageSize}" style="width: 25px">条，&nbsp;共${bean.totalPages}页,
    <a href="javascript:void(0)" onclick="gotoPage(${bean.previousPage})">上一页</a>
        <c:forEach items="${bean.pageBar}" var="page">
            <c:if test="${page == bean.currentPage}">
                <font color="red">${page}</font>
            </c:if>
            <c:if test="${page != bean.currentPage}">
	            <a href="javascript:void(0)" onclick="gotoPage(${page})">${page}</a>
            </c:if>
        </c:forEach>
    <a href="javascript:void(0)" onclick="gotoPage(${bean.nextPage})">下一页</a>
<script type="text/javascript">
    function gotoPage(currentPage) {
    	var pageSize = document.getElementById("pageSize").value;
    	window.location.href = "${pageContext.request.contextPath}/ListCustomerServlet?currentPage=" + currentPage + "&pageSize=" +pageSize;
    }
</script>
</body>
</html>