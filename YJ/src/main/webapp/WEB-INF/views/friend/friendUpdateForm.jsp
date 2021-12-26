<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 수정 폼</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>친구 수정</h1>
			<div>
				<form id="frm" name="frm" action="friendUpdate.do" method="post">
					<table border="1">
						<tr>
							<th width="250">수정할 친구 입력</th>
							<td width="150"><input type="text" id="id" name="id"></td>
						</tr>
						<tr>
							<th>수정할 패스워드 입력</th>
							<td><input type="text" id="password" name="password"></td>
						</tr>
						<tr>
							<th width="150">수정할 취미 입력</th>
							<td width="400"><input type="checkbox" id="hobby"
								name="hobby" value="시체놀이">시체놀이 <input type="checkbox"
								id="hobby" name="hobby" value="침대사랑">침대사랑 <input
								type="checkbox" id="hobby" name="hobby" value="먹방">먹방 <input
								type="checkbox" id="hobby" name="hobby" value="한량">한량 <input
								type="checkbox" id="hobby" name="hobby" value="신선놀음">신선놀음</td>
						</tr>
					</table>
					<input type="submit" value="수정">
				</form>
			</div>
		</div>
	</div>
</body>
</html>