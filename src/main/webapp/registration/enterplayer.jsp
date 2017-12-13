<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>输入球员信息</h1>
	<form action="/ssh_3/playerAction" method="post">
		<s:fielderror fieldName="name"></s:fielderror>
		姓名:<input type="text" name="name" value="${param.name}">
		<br>
		<s:fielderror fieldName="address"></s:fielderror>
		地址:<input typr="text" name="address" value="${param.address}">
		<br>
		<s:fielderror fieldName="city"></s:fielderror>
		城市:<input type="text" name="city" value="${param.city}">
		<br>
		<s:fielderror fieldName="email"></s:fielderror>
		邮箱:<input type="text" name="email" value="${param.email}">
		<br><input type="submit" value="继续">
	</form>
</body>
</html>