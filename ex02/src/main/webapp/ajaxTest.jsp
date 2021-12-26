<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxTest.jsp</title>
<!-- jQuery -->
<script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
<script>
$(function(){	//page ready 이벤트
	/* $("#btn1").click(function(){
});
	btn1.click = function() {}		//펑션이 많아도 하나만 실행 */
	
	$("#btn1").on("click", function(){
		$.ajax({
			url : "ajax1",
			method : "get",
			//BoardVO로 데이터 들어감
			data : {writer : $('#writer').val()},
			//async : false,	//동기식으로 호출
			dataType : "json",	//plain(string)=text, json, xml
			//return 된 vo 값이 들어옴(data)
			success : function(data) {
				$('#result').append(data.content + "<br>");
				$('#result').append(data.writer + "<br>");
			}
		});
		$('#result').append("클릭됨<br>");
	});	//btn1 click end
	/* btn1.addEventListener("click", function() {})	//여러개의 펑션이 다 실행됨  */
	
	$('#btn2').on("click", function() {
		$.ajax({
			url : "ajax2",
			method : "post",
			//controller에 @requestBody를 넣으면 JSON~어쩌구, contentType 세트로 넣어줘야함
			data : JSON.stringify({writer : $('#writer').val()}),
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				$('#result').append($("<p>").append(data.content)
											.append("<br>")
											.append(data.writer))
				/* 같은것 $('#result').append($(`<p>\${data.content}<br>\${data.writer}</p>`)) // \표시가 있으면 ${}를 EL식이 아닌 백틱 문자식으로 인식함
				같은것 $('#result').append($("<p>" + data.content + "<br>" + data.writer + "</p>")) */
			}	//success end
		});		//ajax end
	})			//btn2 click
	
	//group event : 위임	-> 동적으로 추가될 태그에도 미리 이벤트를 지정
	//부모태그에 이벤트 지정
	$("#result").on("click", "p", function() {
		$(this).remove();
	})
})	//end of $(function(){})
</script>

</head>
<body>
<input name="writer" id="writer">
<button type="button" id="btn1">문자열</button>
<button type="button" id="btn2">파라미터(json)</button>
<div id="result"></div>
</body>
</html>