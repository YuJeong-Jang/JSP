<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
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
			<h1>공지사항 목록</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="70">Number</th>
					<th width="300">Title</th>
					<th width="150">Authour</th>
					<th width="150">Date</th>
					<th width="70">Hit</th>
				</tr>
				<c:forEach var="board" items="${boards }">
					<tr onmouseover="this.style.background='lightpink'"
						onmouseout="this.style.background='white'"
						onclick="getRecord(${board.bId})">
						<td align="center">${board.bId}</td>
						<td align="center">${board.bTitle}</td>
						<td align="center">${board.bWriter}</td>
						<td align="center">${board.bDate}</td>
						<td align="center">${board.bHit}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<br>
		<div>
			<button type="button" onclick="location.href='home.do'">To
				main page</button>
			&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='insertForm.do'">Write
				a new article</button>
		</div>
		<div>
			<form id="frm" name="frm" action="boardSelect.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
		</div>
	</div>
</body>
</html>