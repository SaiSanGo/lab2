<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" +
		request.getServerPort() +path;
%>
<jsp:directive.page import="library.db.categoryDao" />
<jsp:directive.page import="java.util.List" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath %>"/>
<title></title>    
 <style type="text/css">   
  body{    
      background-image: url(views/timg.jpg);    
      background-repeat: repeat-x;    
 }   

 </style>    
</head>
<body>
   <%
   List Categorylist=categoryDao.getCategory();
   request.setAttribute("Categorylist",Categorylist);
    %>
 <form action="Categorylist" method="post">
    <table align="center">
        <td><input  name=name></td>
        <td><input type="submit" value="作者查询"></td>
    </table>
    <a href='../addCategory.jsp'>添加图书类别</a>
    <table align="center" style="border:1px solid black">
      <tr>
        <th>图书列表</th>
      </tr>
      <c:forEach items="${Categorylist}" var="Category">
      <tr>
        <td><a href="showBook?Isbn=${Category.getIsbn()}">${Category.getTitle()}</a></td>
     	<td><a href="delCategory?Isbn=${ Category.getIsbn()}"> 删除</a></td>
    	</tr>
    	</c:forEach>
  	</table>
  </form>
</body>
</html>