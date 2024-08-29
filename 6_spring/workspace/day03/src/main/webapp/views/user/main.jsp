<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<html>
<head>
	<title>main</title>
</head>
<body>
	${sessionScope.loginUser}님 환영합니다
	<input type="button" value="로그아웃" onclick="location.replace('/user/logout')">
	<hr>
	<div>
		<input type="button" value="글쓰기" onclick="location.replace('/board/writeview')">
		<hr>
		<table border="">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
</body>
</html>