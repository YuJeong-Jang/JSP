<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원목록</h1>
		</div>
		<div>
			<c:forEach var="member" items="${members}">
				아이디 : ${member.id} 이름 : ${member.name}<br />
			</c:forEach>
			
			<button type="button" id="id" name="name" action="memberSelectForm.do" value="${members}">한건 조회</button>
		</div>
	</div>
</body>
</html>