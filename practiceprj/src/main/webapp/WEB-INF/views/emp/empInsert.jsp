<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> 사원등록
	</div>
	<div class="card-body">
		<form method="post" id="frm" action="empInsert">
			<table width="100%"
				class="table table-striped table-bordered table-hover" id="register">
				<tr>
					<th>사원번호<span class="require">*</span></th>
					<td><input name="employeeId"></td>
				</tr>
				<tr>
					<th>성</th>
					<td><input name="firstName"></td>
				</tr>
				<tr>
					<th>이름<span class="require">*</span></th>
					<td><input name="lastName"></td>
				</tr>
				<tr>
					<th>이메일<span class="require">*</span></th>
					<td><input name="email"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input name="phoneNumber"></td>
				</tr>
				<tr>
					<th>입사일<span class="require">*</span></th>
					<td><input name="hireDate"></td>
				</tr>
				<tr>
					<th>직무번호<span class="require">*</span></th>
					<td><input name="jobId"></td>
				</tr>
				<tr>
					<th>급여<span class="require">*</span></th>
					<td><input name="salary"></td>
				</tr>
				<tr>
					<th>커미션</th>
					<td><input name="commissionPct"></td>
				</tr>
				<tr>
					<th>매니저번호</th>
					<td><input id="managerId"></td>
				</tr>
				<tr>
					<th>부서번호</th>
					<td><input name="departmentId"></td>
				</tr>
				<tr>
					<td colspan="2"><button type="button" id="btnRegister">등록</button></td>
				</tr>
			</table>
		</form>
	</div>
</div>
<script>
$(function() {
	function required() {
		if(frm.employeeId.value == "") {
			alert("사원번호 입력");
			frm.employeeId.focus();
			return false;
		}else if (frm.lastName.value == "") {
			alert("이름 입력");
			frm.lastName.focus();
			return false;
		}else if(frm.email.value == "") {
			alert("이메일 입력");
			frm.email.focus();
			return false;
		}else if(frm.hireDate.value == "") {
			alert("입사일 입력");
			frm.hireDate.focus();
			return false;
		}else if(frm.jobId.value == "") {
			alert("직무번호 입력");
			frm.jobId.focus();
			return false;
		}else if(frm.salary.value == "") {
			alert("급여 입력");
			frm.salary.focus();
			return false;
		}
			return true;
		};
	
	$('#btnRegister').on("click", function(e) {
		e.preventDefault();
		if(required()) {
			$("#frm").submit();			
		}
	});
});
</script>
