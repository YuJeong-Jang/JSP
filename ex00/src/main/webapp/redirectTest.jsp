<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirectTest.jsp</title>
</head>
<body>
<% response.sendRedirect("/main"); %>
<!-- 주소창에 http://localhost/redirectTest.jsp 라고 써도 main으로 주소가 표시됨
보안상의 이유 -->
</body>
</html>