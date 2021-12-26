<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>
<script>
	/* 전체리스트 */
	$(document).ready(function() {
		$('#listAll').on('click', function(event){
			event.preventDefault();
			
			$.ajax({
				url : 'MemberServlet',
				dataType : 'json',
				success : listAllFnc,
				error : function() {
					alert("등록이 실패하였습니다."); // 실패 시 팝업창
				}
			});
		});
	});

	function listAllFnc(data) {
	if(data.length>0) {
		$('#list').children().remove();
	}

		for (let i = 0; i < data.length; i++) {
		let tr = $('<tr />').attr('id',data[i].email);
		$(tr).on('click', function() {
			// 날짜 변환
	    let months = {
        'Jan': '01', 'Feb': '02', 'Mar': '03',
        'Apr': '04', 'May': '05', 'Jun': '06',
        'Jul': '07', 'Aug': '08', 'Sep': '09',
        'Oct': '10', 'Nov': '11', 'Dec': '12'
   		 }
    	let date = $(this).children().eq(4).text();
   		let month = date.substring(0,date.indexOf(' '));
    	let MM = months[month];
    	let dd = date.substring(date.indexOf(' ')+1, date.indexOf(','));
    	if(dd.length == 1){
        	dd = '0' + dd;
   		 }
    	let yyyy = date.substring(8, 12);
  
    // 날짜 변환
			$('#email').val($(this).children().eq(0).text());
			$('#name').val($(this).children().eq(1).text());
			$('#tel').val($(this).children().eq(2).text());
			$('#addr').val($(this).children().eq(3).text());
			$('#birth').val(yyyy+'-'+MM+'-'+dd);
		})
		
		let td_email = $('<td />').text(data[i].email);
		let td_name = $('<td />').text(data[i].name);
		let td_tel = $('<td />').text(data[i].tel);
		let td_addr = $('<td />').text(data[i].addr);
		let td_birth = $('<td />').text(data[i].birth);
		$(tr).append(td_email, td_name, td_tel, td_addr, td_birth);

		$('#list').append(tr);
		
	}		
	}
</script>
<script>
   /* 등록 */
   $(document).ready(function() {
		$('#insert').on('click', function(event){
			
			$.ajax({
				url : 'InsertServlet',
				method : 'post',
				data : {
					email : $('#email').val(),
					name : $('#name').val(),
					tel : $('#tel').val(),
					addr : $('#addr').val(),
					birth : $('#birth').val()
				},
				success : insertFnc,
				error : function() {
					alert("등록이 실패하였습니다."); // 실패 시 팝업창
				}
			});
		});
	});
   
   function insertFnc(data) {
	   if(data.length>0) {
			$('#list').children().remove();
		}

		let tr = $('<tr />');
		let td_email = $('<td />').text(data.email);
		let td_name = $('<td />').text(data.name);
		let td_tel = $('<td />').text(data.tel);
		let td_addr = $('<td />').text(data.addr);
		let td_birth = $('<td />').text(data.birth);

		$('#list').append(tr, td_email, td_name, td_tel, td_addr, td_birth);
				
   }
</script>
<script>
   /* 수정 */
   $(document).ready(function() {
		$('#update').on('click', function(event){
			
			$.ajax({
				url : 'UpdateServlet',
				method : 'post',
				data : {
					email : $('#email').val(),
					tel : $('#tel').val(),
					addr : $('#addr').val()
				},
				success : updateFnc,
				error : function() {
					alert("수정이 실패하였습니다."); // 실패 시 팝업창
				}
			});
		});
	});
   function updateFnc(data) {
	   	let email = $('#email').val();
	   	let tel = $('#tel').val();
		let addr = $('#addr').val();
		$('#' + email).children().eq(2).text(tel);
		$('#' + email).children().eq(3).text(addr);
	
	console.log(addr);
	console.log(tel);
   }
</script>
<script>
   /* 삭제 */
   $(document).ready(function() {
		$('#delete').on('click', function(event){
			$.ajax({
				url : 'DeleteServlet',
				method : 'post',
				data : {
					email : $('#email').val()
				},
				success : deleteFnc(email),
				error : function() {
					alert("삭제가 실패하였습니다."); // 실패 시 팝업창
				}
			});
		});
	});
   function deleteFnc(email) {
	  let del = $('#email').val();
	  
	$('#' + del).remove();
   }
</script>
</head>
<body>
	<div align="center">
		<form id="frm" name="frm" action="MemberServlet" method="post">
			<table border="1">
				<tr>
					<th>아이디(이메일) :</th>
					<td><input type="text" id="email" name="email"></td>
				</tr>
				<tr>
					<th>회원이름 :</th>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<tr>
					<th>연락처 :</th>
					<td><input type="text" id="tel" name="tel"></td>
				</tr>
				<tr>
					<th>주소 :</th>
					<td><input type="text" id="addr" name="addr"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="date" id="birth" name="birth"></td>
				</tr>
			</table>
			<br>
			<input type="button" id="listAll" name="listAll" value="전체조회">
			<input type="button" id="insert" name="insert" value="등록">
			<input type="button" id="update" name="update" value="수정">
			<input type="button" id="delete" name="delete" value="삭제">
		</form>
		<br>
		<div align="center">
		<table border="1">
		<tr>
		<th>이메일</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>주소</th>
		<th>생일</th>
		</tr>
		<tbody id="list">
		
		</tbody>
		</table>
		</div>
	</div>
</body>
</html>