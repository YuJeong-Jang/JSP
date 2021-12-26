<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>한명 검색</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberSelect.do" method="post">
				<table border="1">
					<tr>
						<th width="150">검색할 이름</th>
						<td width="200"><input type="text" id="id" name="id"
							placeholder="아이디입력"></td>
						<td><input type="submit" value="검색"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>