<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST</title>
</head>
<body>
	<div>list</div>
	<hr />
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="article" items="${articles }">
				<tr>
					<td>${article.id}</td>
					<td>
						<a href="../article/detail?id=${article.id}">${article.title}</a>
					</td>
					<td>${article.memberId}</td>
					<td>${article.regDate.substring(0,10)}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>