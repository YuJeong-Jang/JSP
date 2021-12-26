<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기가 시작이양!!</h1>
	<h1>
		<a href="HelloWorld?id=hong">서블릿 호출</a>
	</h1>
	<!-- 여기서는 앞에 /를 넣어주면 루트로 넘어가기때문에 빼줘야함 -->

	<form id="frm" name="frm" method="get" action="HelloWorld">
		<input type="submit" value="전송">
	</form>
	<!--포스트방식으로 던져도 겟방식으로 넘어감(메소드를 포스트로 넣어줬으니 포스트방식으로 넘어감 -->
</body>

</html> 