<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">커 뮤 니 티</h1>
	<p class="mb-4">작성글</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3"><i class="fas fa-caret-square-right"></i>작성글</div>
		<div class="card-body">
			<h6 class="m-0 font-weight-bold text-primary">작성자 :
				${list[0].sWriter} / 제목 : ${list[0].sTitle} / 작성일자 :
				${list[0].sDate}</h6>
			<br />
			<p>${list[0].sContents}</p>
		</div>
		<div class="card-header py-3"><i class="far fa-caret-square-right"></i>댓글</div>
		<div class="card-body">
			<c:forEach var="sns" items="${list}">
				<h6 class="m-0 font-weight-bold text-primary">작성자 :
					${sns.cName} / 작성일자 : ${sns.cDate}</h6>
				<br />
				<p>${sns.cSubject}</p>
				<br />
			</c:forEach>
		</div>
	</div>
</div>
<!-- /.container-fluid -->
