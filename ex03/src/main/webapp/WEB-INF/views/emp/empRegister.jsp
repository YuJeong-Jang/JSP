<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<style>
	.require {
		color : red;
	}
	.emp:hover {
		color: blue;
	}
	.row {
		margin : auto;
	}
	h1 {
		margin : auto;
	}
</style>
<script>
$(function() {	 
	//매니저 검색
	$("#btnEmpSearch").on("click", function() {
		//검색페이지를 ajax로 가져와서 모달 바디에 넣고 ->모달
		$.ajax({
			url : "empSearch",
			success : function(data) {
				$("#empModal .modal-body").html(data);
				$('#empModal').modal('show');
			}
		})
	});
	
	//매니저 단건검색
	$("#managerId").on("keydown", function(e) {
		$('#name').val("");
		if($("#managerId").val() == "")
			return;
		if(e.keyCode == 13) {
			e.preventDefault();
			$.ajax({
				url : "ajaxEmp",
				data : {employeeId : $('#managerId').val()},
				success : function(data) {
					if(data) {
						$("#name").val(data.firstName);
					} else {
						$("#btnEmpSearch").click();
					}
				}
			}) 
		}
	});
	document.addEventListener('keydown', function(e){
	      if(e.keyCode ===13){
	         e.preventDefault();
	      };
	      return;
	   })

	   function validation() {
		if(frm.lastName.value == "") {
			alert("이름입력");
			frm.lastName.focus();
			return false;
		}
		return true;
	} 
	//등록버튼 이벤트
	$("#btnRegister").on("click", function() {
		if( validation()) {
			frm.submit();
		}
	});
})
</script>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">사원 등록</h1>
		</div>

		<!-- /.col-lg-12 -->
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<!-- /.panel-heading -->
					<div class="panel-body">
						<form method="post" action="empRegister" name="frm" action="${ not empty emp ?  'empRegister' : 'updateEmp'}">
						<c:if test="${not empty emp }">
						<input name="employeeId" value="${emp.employeeId}">
						</c:if>
							<table width="100%" class="table table-striped table-bordered table-hover" id="register">
								<tr>
									<th>사원번호<span class="require">*</span></th>
									<td><input name="employeeId" value="${emp.employeeId}"></td>
								</tr>
								<tr>
									<th>성</th>
									<td><input name="firstName" value="${emp.firstName}"></td>
								</tr>
								<tr>
									<th>이름<span class="require">*</span></th>
									<td><input name="lastName" value="${emp.lastName}"></td>
								</tr>
								<tr>
									<th>이메일<span class="require">*</span></th>
									<td><input name="email" value="${emp.email}"></td>
								</tr>
								<tr>
									<th>전화번호</th>
									<td><input name="phoneNumber" value="${emp.phoneNumber}"></td>
								</tr>
								<tr>
									<th>입사일<span class="require">*</span></th>
									<td><input name="hireDate" value="${emp.hireDate}"></td>
								</tr>
								<tr>
									<th>직무번호<span class="require">*</span></th>
									<td><select name="jobId">
									<option value="">선택</option>
									<c:forEach items="${opt.jobs}" var="job">
									<option  value="${job.jobId}">${job.jobTitle}</option>
									</c:forEach>
									</select></td>
								</tr>
								<tr>
									<th>급여</th>
									<td><input name="salary" value="${emp.salary}"></td>
								</tr>
								<tr>
									<th>커미션</th>
									<td><input name="commissionPct" value="${emp.commissionPct}"></td>
								</tr>
								<tr>
									<th>매니저번호</th>
									<td><input id="managerId" value="${emp.managerId}">
										<input id="name">
										<!-- Button trigger modal -->
										<button type="button" class="btn btn-primary" id="btnEmpSearch">검색</button>
									</td>
								</tr>
								<tr>
									<th>부서번호</th>
									<td><input name="departmentId" value="${emp.departmentId}"></td>
								</tr>
								<tr>
									<td colspan="2"><button type="button" id="btnRegister">등록</button></td>
								</tr>
							</table>
						</form>
						<div class="modal" tabindex="-1" id="empModal">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title">헤더</h5>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						        <p>바디</p>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
						        <button type="button" class="btn btn-primary">저장</button>
						      </div>
						    </div>
						  </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
