<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<!-- 같은 내용 다른 형식 보통 아래쪽 방식을 많이 쓰는듯? 모습을 하나의 태그인양 보여준다 페이지 자체가 깔끔해진다-->
<%@ include file="Header.jsp"%>
<%-- <jsp:include page="Header.jsp" /> --%>
<body>
	<div align="center">
		<div>
			<h1>로그인</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="LoginCheck.jsp" method="post">
				<table border="1">
					<tr>
						<th width="200">아 이 디</th>
						<td width="300"><input type="text" id="id" name="id"></td>
					</tr>
					<tr>
						<th width="200">패스워드</th>
						<td width="300"><input type="password" id="password"
							name="password"></td>
					</tr>
				</table>
				<br> <input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</form>
			<!-- get일때와 post방식일때 주소창 확인해볼것 -->
		</div>
	</div>
</body>
<jsp:include page="Footer.jsp" />
</html>