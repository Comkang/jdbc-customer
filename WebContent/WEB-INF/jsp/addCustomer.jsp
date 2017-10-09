<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
<script type="text/javascript">
laydate.render({
	  elem: '#birthday' //指定元素
	});
	
function prepareHobby() {
	var hobbys = document.getElementsByName("hob");
	var str = "";
	for(var i=0; i<hobbys.length; i++) {
		if(hobbys[i].checked == true) {
			var value= hobbys[i].value;
			str = str + value + ",";
		}
	}
	str = str.substr(0, str.length-1);
	var form = document.getElementById("formId");
	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "hobbies";
	input.value = str;
	form.appendChild(input);
	return true;
}	
	
</script>
</head>
<body>
    <form id="formId" action="${pageContext.request.contextPath}/AddCustomerServlet " method="post" onsubmit="return prepareHobby()">
        <table frame="border" border="1">
            <tr>
                <td>客户名称：</td>
                <td>
                    <input type="text" name="customerName">
                </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>
                    <c:forEach var="item" items="${sex}">
	                    <input type="radio" name="sex" value="${item}">${item}
                    </c:forEach>
                 </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td><input type="text" name="birthday" id="birthday"  onclick="change()"></td>
            </tr>
            <tr>
                <td>邮箱：</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>爱好：</td>
                <td>
                    <c:forEach var="hobbie" items="${hobbies}">
	                    <input type="checkbox" name="hob" value="${hobbie}" id="hobby">${hobbie}
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>客户类型：</td>
                <td> 
                    <c:forEach var="item" items="${type}">
                        <input type="radio" name="type" value="${item}">${item}
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                    备注：
                </td>
                <td><input type="text" name="remark"></td>
            </tr>
            <tr><td><input type="submit"></td><td></td></tr>
        </table>
    </form>
</body>
</html>