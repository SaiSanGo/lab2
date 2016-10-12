<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style type="text/css">    
 body{    
      background-image: url(views/book.jpg);    
      background-repeat: repeat-x;    
 }    
 </style>    
</head>
<body>
      <table align="center"  >
      <tr>
        <th>ISBN</th>
        <th>title</th>
        <th>AuthorID</th>
        <th>Publisher</th>
        <th>PublishDate</th>
        <th>Price</th>
    	</tr>
      <c:forEach items="${Categorylist}" var="Category">
      <c:choose>
	  <c:when test="${Category.getIsbn()==param.Isbn}">
      <tr>
        <td>${Category.getIsbn()}</td>
        <td>${Category.getTitle()}</td>
        <td>${Category.getAuthorID()}</td>
        <td>${Category.getPublisher()}</td>
        <td>${Category.getPublishDate()}</td>
        <td>${Category.getPrice()}</td>
      </tr>
      </c:when>
      </c:choose>
      </c:forEach>
  	</table>
  	<table align="center">
		<tr>
			<th>AuthorID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Country</th>
		</tr>
		<tr>
			<th>${Author.getAuthorID()}</th>
			<th>${Author.getName()}</th>
			<th>${Author.getAge()}</th>
			<th>${Author.getCountry()}</th>
		</tr>	  	
  	</table>
</body>
</html>