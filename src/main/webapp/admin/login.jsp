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
	<form action="${pageContext.request.contextPath}/adminAction" method="post">
		<s:fielderror fieldName="username"></s:fielderror>
		用户名:<input type="text" name="username"/>
		<s:fielderror fieldName="password"></s:fielderror>
		<br>密码:<input type="password" name="password"/>
		<br><input type="submit" value="登录">&nbsp;&nbsp;
		<input type="reset" value="重置">
	</form>
</body>
</html>