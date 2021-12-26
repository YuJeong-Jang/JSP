<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 등록</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>친구 등록</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="friendInsert.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="150">아이디</th>
							<td width="400"><input type="text" id="id" name="id"
								placeholder="아이디 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td width="400"><input type="text" id="password"
								name="password" placeholder="패스워드 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">패스워드 확인</th>
							<td width="400"><input type="text" id="passcheck"
								name="passcheck" placeholder="패스워드 확인 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">이름</th>
							<td width="400"><input type="text" id="name" name="name"
								placeholder="이름 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">나이</th>
							<td width="400"><input type="text" id="age" name="age"
								placeholder="나이 입력" required="required"></td>
						</tr>
						<tr>
							<th width="150">취미</th>
							<td width="400"><input type="checkbox" id="hobby"
								name="hobby" value="시체놀이">시체놀이 <input type="checkbox"
								id="hobby" name="hobby" value="침대사랑">침대사랑 <input
								type="checkbox" id="hobby" name="hobby" value="먹방">먹방 <input
								type="checkbox" id="hobby" name="hobby" value="한량">한량 <input
								type="checkbox" id="hobby" name="hobby" value="신선놀음">신선놀음</td>
						</tr>
					</table>
				</div>
				<br />
				<div>
					<input type="submit" value="친구등록">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>