<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:forEach items="${list}" var="emp">
		<a href="updateEmp?employeeId=${emp.employeeId}">${emp.employeeId}</a>
		${emp.firstName}<br>
		${emp.lastName}<br>
		${emp.email}<br><br>
		</c:forEach>
	</div>
</body>
</html>