<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지업로드 테스트</title>
</head>
<body>
	<form method="post" action="fileupload.jsp"
		enctype="multipart/form-data">
		<input type="file" name="photo" /> <input type="submit" name="upload" />
	</form>
</body>
</html>