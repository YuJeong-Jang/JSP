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
	<div align="center">
		<div>
			<h1>글 수정 후</h1>
		</div>
		<div>번호 : ${update.SNo}. 제목 : ${update.STitle} 내용 :
			${update.SContents}</div>
		<div>
			<c:forEach var="comments" items="${sns}">
		${comments.CNo} ${comments.CName} ${comments.CSubject}<br />
			</c:forEach>
		</div>
	</div>
</body>
</html>