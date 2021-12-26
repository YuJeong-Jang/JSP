<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS 목록</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 목록</h1>
		</div>
		<div>
			<c:forEach var="sns" items="${list}">
${sns.SNo}. ${sns.STitle}<br />
			</c:forEach>
		</div>
		<form id="id" name="id" method="post" action="snsSelect.do">
			<input type="text" id="sno" name="sno">
			<button type="submit">조회</button>
		</form>
		
	</div>
</body>
</html>