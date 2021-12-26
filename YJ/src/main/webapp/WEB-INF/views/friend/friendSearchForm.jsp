<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 조회 폼</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>친구 조회</h1>
			<div>
				<form id="frm" name="frm" action="friendSearch.do" method="post">
					<table border="1">
						<tr>
							<th width="250">조회할 친구 아이디 입력</th>
							<td width="150"><input type="text" id="id" name="id"></td>
							<td width="100"><input type="submit" value="검 색"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>