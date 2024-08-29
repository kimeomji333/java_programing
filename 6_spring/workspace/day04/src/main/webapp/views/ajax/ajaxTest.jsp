<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<html>
<head>
	<title>ajaxTest</title>
</head>
<body>
	<p id="result"></p>
	<input type="button" value="통신하기" onclick="f()">
</body>
<script>
	function f(){
		// 1. AJAX 요청 생성
		const xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			//	응답이 되었을 때					4
			if(xhr.readyState == XMLHttpRequest.DONE){
				// 응답된 데이터 확인
				console.log(xhr.responseText);
				// 응답된 데이터로 페이지 변화시키기 위해 돔을 사용
				document.getElementById("result").innerHTML = xhr.responseText;
			}
		}
		
		// 2. 요청 설정 (GET 방식, URL)
		xhr.open("GET","/ajax/test");
		// 3. 요청 전송
		xhr.send();
	}
</script>
</html>
