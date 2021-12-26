<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
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
			<h1>공지사항 수정</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="boardUpdate.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="200">수정할 제목</th>
							<td colspan="7"><textarea cols="110">${board.bTitle}</textarea></td>
						</tr>
						<tr>
							<th width="100">Content</th>
							<td colspan="7"><textarea rows="7" cols="110">${board.bContent}</textarea>
							</td>
						</tr>

					</table>
					<button type="submit" onclick="getRecord(${board.bId})">수정</button>
				</div>
			</form>
			<form id="frm" name="frm" action="boardList.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
		</div>
	</div>
</body>
</html>