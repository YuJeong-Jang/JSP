<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<!-- jQuery -->
<script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시글 등록</h1>
	</div>

	<!-- /.col-lg-12 -->
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">등록을 해보자</div>

				<!-- /.panel-heading -->
				<div class="panel-body">
					<form method="post" action="register" id="frm">
						<table width="100%" class="table table-striped table-bordered table-hover" id="register">
							<tr>
								<th>작성자</th><td><input name="writer" value="${board.writer}"></td>
							</tr>
							<tr>
								<th>제목</th><td><input name="title" value="${board.title}"></td>
							</tr>
							<tr>
								<th>내용</th><td><input name="content" value="${board.content}"></td>
							</tr>
							<tr>	
								<td colspan="2"><button type="button" id="btnRegister">등록</button></td>
							</tr>
						</table>
					</form>
					<input type="file" name="uploadFile" multiple="multiple">
					<button type="button" id="uploadBtn">첨부파일등록</button>
				<ul id="uploaded"></ul>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
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
			url : "../uploadAjaxAction",
			method : "post",
			data : formData,
			success : function(datas) {
				var str = "";
				for(i=0; i<datas.length; i++) {
					var obj = datas[i];
					var fileCallPath = encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);			      
				    var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
				      
					str += "<li "
					str += "data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"' ><div>";
					str += "<span> "+ obj.fileName+"</span>";
					str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' " 
					str += "class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
					str += "<img src='../resources/img/attach.png'></a>";
					str += "</div>";
					str +"</li>";
					
					/* $("<div>").append($("<p>").html(datas[i].fileName)).appendTo($("#uploaded")) */
				}
				$("#uploaded").html(str);
				alert("upload succeed");
			}
		});
	});
	
	//등록버튼 이벤트
	$("#btnRegister").on("click", function() {
		var str = "";
		$("#uploaded li").each(function(i, obj) {
			var jobj = $(obj);
			str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
		    str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
		    str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
		    str += "<input type='hidden' name='attachList["+i+"].fileType' value='1'>";
		});
		$("#frm").append(str).submit();
	})
});
</script>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>