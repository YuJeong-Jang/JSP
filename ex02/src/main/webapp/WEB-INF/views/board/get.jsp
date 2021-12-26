<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">수정하기</h1>
	</div>
	<!-- /.col-lg-12 -->

	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">잘 수정해봐</div>
				<!-- /.panel-heading -->
				<form id="frm" action="modify" method="post">
					<div class="form-group">
						<label>글번호</label> ${board.bno }&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<label>작성자</label>
						${board.writer }
					</div>
					<div class="form-group">
						<label>제목</label>
						<input class="form-control" placeholder="제목을 입력하세요" name="title" value="${board.title }">
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="3" placeholder="내용을 입력하세요" name="content">${board.content }</textarea>
					</div>
					<%-- <input type="hidden" name="pageNum" value="${cri.pageNum}">
					<input type="hidden" name="amount" value="${cri.amount}"> --%>
					<input type="hidden" name="bno" value="${board.bno}">
					<button class="btn btn-success">수정</button>
					<button type="button" class="btn btn-success delete">삭제</button>
					<a class="btn btn-success" href="list?pageNum=${cri.pageNum}&amount=${cri.amount}">목록으로</a>
					<!-- /.table-responsive -->
				</form>
				<!-- 첨부파일 -->
				<div>
					<c:forEach items="${board.attachList}" var="attach">
						<a href="download?uuid=${attach.uuid}">${attach.fileName }</a></c:forEach>
				</div>
			</div>
		<!-- 댓글등록 -->
		<div class="panel-heading"></div>
		<form id="replyForm">
		<input type="hidden" name="bno" value="${board.bno}">
		<input name="replyer" value="짱짱맨">
		<input name="reply">
		<button type="button" id="saveReply">댓글등록</button>${pageMaker.startPage }
		</form>
		<!-- 댓글목록 -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">댓글</h1>
						<form id="replyDel" action="/{rno}">
							<ul class="chat">
								<!-- 스트립트로 목록 삽입 -->
							</ul>
						</form>
					<div class="panel-footer">
						<!-- 스크립트로 댓글 페이징 -->
					</div>
				</div>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
</div>
<script src="../resources/js/reply.js"></script>
<script>
	$(function() {
		$(".delete").on("click", function() {
			$('#frm').attr("action", "delete");
			$('#frm').submit();
		})
	});
	
	let bno = "${board.bno}";
	$(function() {
	//등록처리(post)
	$("#saveReply").on("click", function() {
		replyService.add(function (data) {	 	
			$(".chat").append(makeLi(data));
		});
	});

	//목록조회(get)
	replyService.getList({bno:bno}, function (datas){
		str = "";
		for(i=0; i<datas.list.length; i++) {
			str += makeLi(datas.list[i]);
		}
		$(".chat").html(str);
	})
	
	function makeLi(data) {
		return '<li class="left clearfix">'
				+ '	<div>'	
				+ '		<div class="header">'
				+ '			<strong class="primary-font">' + data.replyer + '</strong>'
				+ '			<small class="pull-right text-muted">'+ data.replyDate +'</small>'
				+ '		</div>'
				+ '		<p>'+ data.reply +'<button class="pull-right text-muted delete">삭제</button></p>'
				+ '	</div>'
				+ '</li>'
	}
	
	
					
					
	//삭제 해볼것
	/* $(function() {
		$(".delete").on("click", function() {
			$('.replyDel').attr("action", "/{rno}");
			$('.replyDel').submit();
		})
	}); */
});
	
	//댓글 페이징
	var pageNum = 1;
	var replyPageFooter = $(".panel-footer");
	function showReplyPage(replyCnt) {
		var endNum = Math.ceil(pageNum / 10.0) * 10;
		var startNum = endNum - 9;
		
		var prev = startNum != 1;
		var next = false;
		
		if(endNum * 10 >= replyCnt) {
			endNum = Math.ceil(replyCnt/10.0);
		}
		
		if(endNum * 10 < replyCnt) {
			next = true;
		}
		
		var str = "<ul class='pagination pull-right'>";
		
		if(prev) {
			str += "<li class = 'page-item'><a class = 'page-link' href='" + (startNum -1) + "'>Previous</a></li>";
		}
		
		for(var i = startNum; i<=endNum; i++) {
			var active = pageNum ++ i? "active":"";
			str += "<li class='page-item " + active + " '><a class='page-link' href='" + i + "'</a></li>";
		}
		
		if(next) {
			str += "<li class='page-item'><a class='page-link' href='" + (endNum + 1) + "'>Next</a></li>";
		}
		
		str += "</ul></div>";
		replyPageFooter.html(str);
	}
</script>
<!-- /.col-lg-12 -->
<%@include file="/WEB-INF/views/includes/footer.jsp"%>