<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> 사원리스트
	</div>
	<div class="card-body">
		<table align="center" class="table table-striped table-bordered table-hover">
			<tr>
				<th>사원번호</th>
				<th>성</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직무번호</th>
				<th>급여</th>
				<th>인센티브</th>
				<th>매니저번호</th>
				<th>부서번호</th>
			</tr>
			<c:forEach items="${list}" var="emp">
				<tr id="empClick" onclick="getRecord(${emp.employeeId})">
					<td>${emp.employeeId}</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td>${emp.phoneNumber}</td>
					<td>${emp.hireDate}</td>
					<td>${emp.jobId}</td>
					<td>${emp.salary}</td>
					<td>${emp.commissionPct}</td>
					<td>${emp.managerId}</td>
					<td>${emp.departmentId}</td>
				</tr>
			</c:forEach>
		</table>
		<form id="frm" name="frm" action="empSearch" method="get">
			<input type="hidden" id="employeeId">
		</form>
		<div id="registerBtn"><button class="btn btn-primary" onclick="location.href='empInsert'">글 등록</button></div>
	</div>
	<div class="modal" tabindex="-1" id="empModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title"></h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <p></p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
	        <button type="button" class="btn btn-primary">저장</button>
	      </div>
	    </div>
	  </div>
	</div>
</div>
<script>
function getRecord(n) {
    frm.employeeId.value = n;
    frm.submit();
 };
 
$(function() {
	//등록
	$("#registerBtn button").on("click", function(e) {
		e.preventDefault();
		var location = "location.href='empInsert'";
		var insert = $(this).attr("onclick").attr(location);
		insert.submit();
	});
	
	//수정모달
	$("#empClick").on("click", function() {
		$.ajax({
			url : "empSearch",
			seccess : function(data) {
				$('#empModal .modal-body').html(data);
				$('#empModal').modal('show');
			}
		})
	});
	
	document.addEventListener('keydown', function(e) {
		if(e.keyCode == 13) {
			e.preventDefault();
		};
		return;
	});
});
</script>
<%@include file="/WEB-INF/views/include/footer.jsp"%>