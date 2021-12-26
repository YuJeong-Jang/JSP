<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@include file="/WEB-INF/views/include/header.jsp" %>
<%@include file="/WEB-INF/views/include/menu.jsp" %>
	<table border="1">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>표지</th>
			<th>출판일자</th>
			<th>금액</th>
			<th>출판사</th>
			<th>도서소개</th>
		</tr>
		<c:forEach items="${list}" var="book">
			<tr>
				<td>${book.bookNo}</td>
				<td>${book.bookName}</td>
				<td>${book.bookCoverImg}</td>
				<td><fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd" /></td>
				<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${book.bookPrice}" /></td>
				<td>${book.bookPublisher}</td>
				<td>${book.bookInfo}</td>
			</tr>
		</c:forEach>
	</table>
<%@include file="/WEB-INF/views/include/footer.jsp" %>