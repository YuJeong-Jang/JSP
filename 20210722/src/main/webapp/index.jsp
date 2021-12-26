<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
</head>
<body>
	<!-- 지금 여기서 실행을 해도 Main.jsp파일이 시작페이지로 실행이 됨 (sendredirect)-->
	<%
	response.sendRedirect("jsp/Main.jsp");
	%>
	<!-- 최근 사용하는 방법 -->
	<%-- <jsp:forward page="jsp/Main.jsp" />
	 <!-- sendredirect는 디렉토리도 옮겨가는데 이 방식은 디렉토리를 옮겨가지 않는다 --> --%>
</body>
</html>