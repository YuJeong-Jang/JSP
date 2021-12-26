<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 목록 리스트</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>친 구 목 록</h1>
		</div>
		<table border="1">
			<tr>
				<th width="150">아이디</th>
				<th width="150">패스워드</th>
				<th width="150">이름</th>
				<th width="100">나이</th>
				<th width="300">취미</th>
			</tr>
			<c:forEach var="friend" items="${list}">
				<tr>
					<td align="center">${friend.id}</td>
					<td align="center">${friend.password}</td>
					<td align="center">${friend.name}</td>
					<td align="center">${friend.age}</td>
					<td align="center">${friend.hobby}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<div>
			<button type="button" onclick="location.href='main.do'">홈 가기</button>
		</div>
	</div>

</body>
</html>