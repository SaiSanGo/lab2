<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>图书列表</h1>
<table>
 <c:forEach items="${Categorylist}" var="Category">
    <tr>
        <td><a href="book.jsp?Isbn=${Category.getIsbn()}">${Category.getTitle()}</a></td>
    </tr>
 </c:forEach>
</table>
</body>
</html>