<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리 결과</title>
</head>
<body>
<!-- el표현식으로 쓰니까 자바 코드식을 다 뺄 수 있다. 서블릿에 자바코드를 넣어버림. 서블릿에는 html을 안 넣게 됨. jsp와 el표현식만 넣은게 현대적 jsp-->
	넘어온 아이디 : ${param.id }
	넘어온 패스워드 : ${param.password }
	<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = null;
	String msg = null;

	if (id.equals("hong") && password.equals("1234")) {
		name = "홍길동";
		msg = name + "님 환영합니다.";
	} else {
		msg = "아이디 또는 패스워드가 잘못되었습니다.";
	}
	%>
	<div align="center">
		<h1><%=msg%></h1>
		<a href="../index.jsp">홈 가기</a>
	</div>
</body>
</html>