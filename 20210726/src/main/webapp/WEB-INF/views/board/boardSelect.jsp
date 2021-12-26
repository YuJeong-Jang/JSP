<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 상세보기</title>
<script type="text/javascript">
	function getRecord(n) {
		frm.bId.value = n;
		frm.submit();
	}

	function getRecord(n) {
		del.bId.value = n;
		del.submit();
	}

</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>상세보기</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="100">Number</th>
					<td width="70" align="center">${board.bId }</td>
					<th width="100">Authour</th>
					<td width="150" align="center">${board.bWriter }</td>
					<th width="100">Date</th>
					<td width="150" align="center">${board.bDate }</td>
					<th width="100">Hit</th>
					<td width="70" align="center">${board.bHit }</td>
				</tr>
				<tr>
					<th width="100">Title</th>
					<td colspan="7">${board.bTitle }</td>
				</tr>
				<tr>
					<th width="100">Content</th>
					<td colspan="7"><textarea rows="7" cols="110">${board.bContent }</textarea>
					</td>
				</tr>
			</table>
		</div>
		<br>
		<div>
			<button type="button" onclick="location.href='boardList.do'">목록return
				to the list</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="getRecord(${board.bId})">수정edit
				the article</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="getRecord(${board.bId})">삭제delete</button>
			<form id="frm" name="frm" action="updateForm.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
			<form id="del" name="del" action="deleteForm.do" method="post">
				<input type="hidden" id="bdel" name="bdel">
			</form>
		</div>
	</div>
</body>
</html>