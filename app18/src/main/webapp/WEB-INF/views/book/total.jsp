<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<%@include file="/WEB-INF/views/include/menu.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<div>
		<h3>도서별 대여매출현황</h3>
	</div>
	<div>
		<table border="1">
			<tr>
				<th>도서번호</th>
				<th>도서명</th>
				<th>대여총계</th>
				<th>대여횟수</th>
			</tr>
			<c:forEach items="${total}" var="all">
				<tr>
					<td>${all.bookNo}</td>
					<td>${all.bookName}</td>
					<td>${all.rentPrice}</td>
					<td>${all.rentStatus}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<%@include file="/WEB-INF/views/include/footer.jsp"%>