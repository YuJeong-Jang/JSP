<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>친구 삭제 폼</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>친구 삭제</h1>

			<div>
				<form id="frm" name="frm" action="friendDelete.do" method="post">
					<table border="1">
						<tr>
							<th width="250">삭제할 친구 입력</th>
							<td width="150"><input type="text" id="id" name="id"></td>
							<td width="100"><input type="submit" value="삭제"></td>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>