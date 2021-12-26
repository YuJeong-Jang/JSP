<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 입력</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>공지사항 작성</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="insertBoard.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">Authour</th>
							<td width="150"><input type="text" id="bWriter"
								name="bWriter" required></td>
							<th width="100">Date</th>
							<td width="70"><input type="date" id="bDate" name="bDate"></td>
						</tr>
						<tr>
							<th width="100">Title</th>
							<td colspan="3"><input type="text" id="bTitle" name="bTitle"
								size="60" required></td>
						</tr>
						<tr>
							<th width="100">Content</th>
							<td colspan="3"><textarea rows="7" cols="65" id="bContent"
									name="bContent" required placeholder="이곳에다 내용을 써 주세용"></textarea>
							</td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<button type="submit">등록write</button>
					&nbsp;&nbsp;&nbsp;
					<button type="reset">cancel 취소</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='boardList.do'">목록가기return
						to list</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>