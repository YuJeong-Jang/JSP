<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
	</div>
	
	<!-- /.col-lg-12 -->
<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
				<div class="panel panel-default">	
					<a href="register">글 등록</a>
					<div class="panel-heading">하이헬로우안녕?</div>
					
					<!-- /.panel-heading -->
					<div class="panel-body">
						<table width="100%"
							class="table table-striped table-bordered table-hover" id="board">
							<thead>
								<tr>
									<th width="100">번호</th>
									<th width="100">제목</th>
									<th width="100">내용</th>
									<th width="100">작성자</th>
									<th width="100">regDate</th>
								</tr>
							</thead>
							<c:forEach var="board" items="${list}">
								<tbody>
									<tr class="odd gradeX">
										<td>${board.bno}</td>
										<td><a class="move" href="${board.bno}">${board.title}[${board.replycnt}]</a></td>
										<td>${board.content}</td>
										<td>${board.writer}</td>
										<td><fmt:formatDate value="${board.regDate}"
												pattern="yy-MM-dd" /></td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
						<!-- /.table-responsive -->
						<form id="actionForm" action="list" method="get">
						<select name="type">
						<option value="" <c:out value="${pageMaker.cri.type ? 'selected':''}"/>>선택</option>
						<option value="T" <c:out value="${pageMaker.cri.type eq 'T' ? 'selected':''}"/>>제목</option>
						<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected':''}"/>>내용</option>
						<option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected':''}"/>>작성자</option>
						<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected':''}"/>>제목 or 내용</option>
						<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected':''}"/>>제목 or 작성자</option>
						<option value="TWC" <c:out value="${pageMaker.cri.type eq 'TWC' ? 'selected':''}"/>>제목 or 내용 or 작성자</option>
						</select>
							<input name="keyword" value="${pageMaker.cri.keyword}">
							<input type="hidden" name="pageNum" value="1">
							<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
							<button class="btn btn-default">Search</button>
						</form>
						
						<div id="pageButton">
							<c:if test="${pageMaker.prev}"><a href="${pageMaker.startPage-1}">이전</a></c:if>
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num"><a href="${num}">${num}</a></c:forEach>
							<c:if test="${pageMaker.next}"><a href="${pageMaker.endPage+1}">다음</a></c:if>
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
</div>

<!-- /.row -->
<script type="text/javascript">
	$(function() {
		var actionForm = $("#actionForm")

		$(".move").on("click", function(e) {
			e.preventDefault();
			var bno = $(this).attr("href")
			actionForm.append('<input type="hidden" name="bno" value="'+ bno +'">')
			actionForm.attr("action", "get")
			actionForm.submit();
		});
		
		$("#pageButton a").on("click", function(e) {
			e.preventDefault();		//a, submit
			var p = $(this).attr("href")
			$('[name="pageNum"]').val(p)
			actionForm.submit();
		});
	//	$("#board").DataTable();
	})
</script>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>