<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="emp">
		<span>사원번호 : ${empList.employeeId}<br></span>
		<span>성 : ${empList.firstName}<br></span>
		<span>이름 : ${empList.lastName}<br></span>
		<span>이메일 : ${empList.email}<br></span>
		<span>전화번호 : ${empList.phoneNumber}<br></span>
		<span>입사일 : ${empList.hireDate}<br></span>
		<span>직무번호 : ${empList.jobId}<br></span>
		<span>급여 : ${empList.salary}<br></span>
		<span>인센티브 : ${empList.commissionPct}<br></span>
		<span>매니저번호 : ${empList.managerId}<br></span>
		<span>부서번호 : ${empList.departmentId}<br></span>
	</div>
</body>
<script>
$(function() {
	$(".emp").on("click". function() {
		var span = $(this).find("span");
		$('#empClick').val(span);
		$('#empModal').modal('hide');
	})
})
</script>
</html>