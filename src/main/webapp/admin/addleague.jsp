<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/leagueAction" method="post">
		<s:fielderror fieldName="year"/>
		<br>年份:<input type="text" name="lyear" value="${param.lyear}"><br>
		<c:set var="seasons" value="Spring,Summer,Fall,Winter"></c:set>
		<s:fielderror fieldName="season"/>
		<br>季节:<select name="season">
			<option value="UNKNOWN">select...</option>
			<c:forEach items="${seasons}" var="s">
				<option value="s" 
					<c:if test="${s==param.season}">
						selected
					</c:if>
				>${s}</option>
			</c:forEach>
		</select>
		<s:fielderror fieldName="title"/>
		<br>标题:<input type="text" name="title" value="${param.title}"><br>
		<br><input type="submit" value="添加联赛">
	</form>
</body>
</html>