<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<div align="center">
	<!-- 이 부분이 자바임 -->
		<%
		for (int i = 2; i <= 9; i++) {
			out.println("===" + i + "단 ===<br/>");
			for (int j = 1; j <= 9; j++) {
				out.println(i + " * " + j + " = " + i * j + "<br/>");
			}

		}
		%>
	</div>
</body>
</html>