<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 삭제</title>
<script type="text/javascript">
	function getRecord(n) {
		frm.bId.value = n;
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>삭제하기</h1>
		</div>
		<div>
				<form id="frm" name="frm" action="friendDelete.do" method="post">
					<table border="1">
						<tr>
							<th width="250">삭제할 아이디 입력</th>
							<td width="150"><input type="text" id="id" name="id"></td>
							<td width="100"><input type="submit" value="삭제"></td>
					</table>
				</form>
			</div>
	</div>
</body>
</html>