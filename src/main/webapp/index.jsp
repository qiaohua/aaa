<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Contsent-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>足球联赛</h1>
	<ul>
		<li><a href="listAction">列出所有联赛</a></li>
		<br><li><a href="${pageContext.request.contextPath}/registration/enterplayer.jsp">注册联赛</a></li>
		<br><li><a href="leagueAction">添加联赛</a></li>
	</ul>
</body>
</html>