<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fileDown(orgFile, downFile) {
		frm.orgFile.value = orgFile;
		frm.downFile.value = downFile;
		frm.submit();
		alert("다운로드 되었습니다.")
	}
</script>
</head>
<body>
	<div align="center">
		<h3>파일 목록</h3>
	</div>
	<div>
		<table border="1" align="center">
			<c:forEach var="file" items="${files}">
				<tr>
					<th width="70">내용</th>
					<td width="300"><textarea rows="7" cols="100" id="subject"
							name="subject">
					${file.subject }</textarea></td>
				</tr>

				<tr>
					<th width="70">첨부 파일</th>
					<td width="300" style="cursor: pointer;"
						onclick="fileDown('${file.fileName}', '${file.downFile }')">${file.fileName }<input
						type="hidden" value="${file.downFile}"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<form id="frm" name="frm" action="fileDownLoad.do" method="post">
			<input type="hidden" id="orgFile" name="orgFile"> <input
				type="hidden" id="downFile" name="downFile">
		</form>
	</div>
</body>
</html>