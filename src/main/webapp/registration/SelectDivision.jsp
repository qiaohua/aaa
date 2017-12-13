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
	<h1>选择联赛和分组</h1>
	
	<form action="/ssh_3/select" method="post">
		<s:fielderror fieldName="year"></s:fielderror>
		<br>年份:<input type="text" name="lyear" value="${param.lyear}">
		<br>季节:
		<s:fielderror fieldName="season"></s:fielderror>
		<c:set var="seasons" value="Spring,Summer,Fall,Winter"></c:set>
		<select name="season">
			<option value="UNKNOWN">select...</option>
			<c:forEach items="${seasons}" var="sea">
				<option value="${sea}" 
					<c:if test="${sea == param.season}">
						selected
					</c:if>
				>${sea}</option>
			</c:forEach>
		</select><br>
		
		<s:fielderror fieldName="division"></s:fielderror>
		<br>分组:<c:set var="divisions" value="Professional,Semi-pro,Amateur"></c:set>
		<select name="division">
			<option value="UNKNOWN">select...</option>
			<c:forEach items="${divisions}" var="dis">
				<option value="${dis}" 
					<c:if test="${dis == param.disvision}">
					selected
					</c:if>
				>${dis}</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>