<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${deptList}" var="dept">
		<div class="dept">
			<span>${dept.departmentId}</span>
			<span>${dept.departmentName}</span>
		</div>
	</c:forEach>
</body>
<script>
$(function() {
	$(".dept").on("click", function() {
		var span = $(this).find("span");
		$("#departmentId").val(span.eq(0).text());
		$("#name").val(span.eq(1).text());
		$("#deptModal").modal('hide');
	})
})
</script>
</html>