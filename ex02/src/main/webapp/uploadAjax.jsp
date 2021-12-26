<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
</head>
<body>
	<div>
		<form name="frm">
			<input type="text" name="writer"> <!-- -> input이 많으면 서버 태우기 힘들어짐. 한번에 태울수 있는 방법이 있다. -->
			<input type="text" name="content">
		</form>
			<input type="file" name="uploadFile" multiple="multiple">
	</div>
	<button type="button" id="uploadBtn">upload</button>
	<script type="text/javascript">
		$(function() {
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz|pdf)$");
			var maxSize = 5242880; //5MB

			function checkExtension(fileName, fileSize) {
				if (fileSize >= maxSize) {
					alert("파일 사이즈 초과");
					return false;
				}
				if (regex.test(fileName)) {
					alert("해당 종류의 파일은 업로드할 수 없습니다.");
					return false;
				}
				return true;
			}
			
			$("#uploadBtn").on("click", function() {
				var formData = new FormData(document.frm);
				var inputFile = $("[name='uploadFile']");
				var files = inputFile[0].files;
				for(i=0; i<files.length; i++) {
					if(!checkExtension(files[i].name, files[i].size))
						return;
					formData.append("uploadFile", files[i]);
				} 
				
				//formData
				$.ajax({
					processData : false,
					contentType : false,
					url : "uploadAjaxAction",
					method : "post",
					data : formData,
					success : function(result) {
						console.log(result);
						alert("upload succeed");
					}
				});
			});
		});
	</script>
</body>
</html>