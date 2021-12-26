<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp" %>
<%@include file="/WEB-INF/views/include/menu.jsp" %>
<script>
$(function() {
	function validation() {
		if(frm.bookName.value == "") {
			alert("도서명이 입력되지 않았습니다.");
			frm.bookName.focus();
			return false;
		}
		return true;
	};
	
//등록버튼 이벤트
$("#btnRegister").on("click", function(e) {
	e.preventDefault();
	if( validation()) {
		$('#frm').submit();
		alert("도서등록이 완료되었습니다.");
	}
});

});
</script>
	<div align="center">
		<h3>도서 등록</h3>
	</div>
	<div>
		<form method="post" id="frm">
			<table border="1">
				<tr>
					<th>도서번호</th>
					<td><input type="text" name="bookNo" value="${book.bookNo }" placeholder="비워두면 자동부여"></td>
				</tr>
				<tr>
					<th>도서명</th>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<th>도서표지</th>
					<td><input type="text" name="bookCoverImg"></td>
				</tr>
				<tr>
					<th>출판일자</th>
					<td><input type="text" name="bookDate" placeholder="0000/00/00 형식"></td>
				</tr>
				<tr>
					<th>금액</th>
					<td><input type="text" name="bookPrice"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" name="bookPublisher"></td>
				</tr>
				<tr>
					<th>도서소개</th>
					<td><textarea name="bookInfo"></textarea></td>
				</tr>
			</table>
			<button id="btnRegister">등록</button><br><br>
		</form>
			<button id="getList" onclick="location.href='list'">조회</button>
	</div>
<%@include file="/WEB-INF/views/include/footer.jsp" %>