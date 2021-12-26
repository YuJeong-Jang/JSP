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
			<h1>한명 조회</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="150">아 이 디</th>
					<th width="150">이 름</th>
					<th width="150">휴면여부</th>
				</tr>
				<tr>
					<td align="center">${member.id}</td>
					<td align="center">${member.name}</td>
					<td align="center">${member.state}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>