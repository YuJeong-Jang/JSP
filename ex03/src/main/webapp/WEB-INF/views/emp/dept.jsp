<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
<style>
	.require {
		color : red;
	}
	.dept:hover {
		color: blue;
	}
	.row {
		margin : auto;
	}
	h1 {
		margin : auto;
	}
</style>
<body>
<h3>부서관리</h3>
	<div id="list">
	<div>부서번호 : <input id="departmentId" value="${dept.departmentId}"></div>
	<div> 부서명  : <input id="name"></div>
	<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" id="btnDeptSearch">검색</button>
		<div class="modal" tabindex="-1" id="deptModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">헤더</h5>
						<button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p>바디</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-primary">저장</button>
					</div>
				</div>
			</div>
		</div>
	</div>
<script>
$(function() {
	//deptList();
	//등록
	
	//수정
	
	//목록조회
/* 	function deptList() {
		$.ajax({
			url : "deptList",
			dataType : "json",
			success : function(datas) {
				$.each(datas, function(i, data) {
					$("<div>").append($("<span>").html(data.departmentId))
							.append($("<span>").html(data.departmentName))
							.appendTo($("#list"));
				});	
			}
		});
	};
	 */
	//매니저 검색
	$("#btnDeptSearch").on("click", function() {
		$.ajax({
			url : "deptSearch",
			success : function(data) {
				$("#deptModal .modal-body").html(data);
				$('#deptModal').modal('show');
			}
		})
	
	});
	
	//매니저 단건검색
	$("#departmentId").on("keydown", function(e) {
		$('#name').val("");
		if($("#departmentId").val() == "")
			return;
		if(e.keyCode == 13) {
			e.preventDefault();
			$.ajax({
				url : "ajaxDept",
				data : {departmentId : $('#departmentId').val()},
				success : function(data) {
					if(data) {
						$("#name").val(data.departmentName);
					} else {
						$("#btnDeptSearch").click();
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
});
</script>
</body>