<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회 원 가 입</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="MemberInsert.jsp" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="200">아이디</th>
							<td width="300"><input type="text" id="id" name="id"></td>
						</tr>
						<tr>
							<th width="200">패스워드</th>
							<td width="300"><input type="text" id="password"
								name="password"></td>
						</tr>
						<tr>
							<th width="200">이름</th>
							<td width="300"><input type="text" id="name" name="name"></td>
						</tr>
						<tr>
							<th width="200">나이</th>
							<td width="300"><input type="text" id="age" name="age"></td>
						</tr>
						<tr>
							<th width="200">취미</th>
							<td width="300"><input type="checkbox" id="hobby" name="hobby"
								value="등산">등산 <input type="checkbox" id="hobby" name="hobby"
								value="낚시">낚시 <input type="checkbox" id="hobby" name="hobby"
								value="볼링">볼링 <input type="checkbox" id="hobby" name="hobby"
								value="수영">수영 <input type="checkbox" id="hobby" name="hobby"
								value="여행">여행 <input type="checkbox" id="hobby" name="hobby"
								value="영화감상">영화감상</td>
						</tr>
					</table>
				</div>
				<br />
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취   소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>