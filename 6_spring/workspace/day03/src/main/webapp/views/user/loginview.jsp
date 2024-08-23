<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>loginview</title>
	</head>
	
	<body>
		<form name="loginForm" action="/user/loginOk" method="post">
			<input name="userid" placeholder="아이디를 입력하세요!">
			<input type="password" name="userpw" placeholder="비밀번호를 입력하세요!">
			<input type="submit" value="로그인">
		</form>
		
		<c:choose>
	        <c:when test="${not empty joinId}">
	            <script>
	                window.onload = function() {
	                    var joinId = '${joinId}';
	                    alert(joinId + '님 가입을 환영합니다!');
	                    document.loginForm.userid.value = joinId;
	                    document.loginForm.userpw.focus();
	                }
	            </script>
	        </c:when>
	        <c:otherwise>
	            <script>
	                window.onload = function() {
	                    document.loginForm.userid.focus();
	                }
	            </script>
	        </c:otherwise>
	    </c:choose>
	</body>
</html>