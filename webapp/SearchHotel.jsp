<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>五反田トラベル: 宿・ホテル予約 国内旅行・海外旅行 予約サイト</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="header">
			<div id="logo">
				<h1>
					<a href="#">五反田トラベル</a>
				</h1>
			</div>
			<br>
			<div>
				<jsp:include page="/index.jsp" />
				<hr>
			</div>
		</div>
<form action="" method="post">
	<table border="1">
		<tr>
			<td>No.</td>
			<td>宿ID</td>
			<td>宿名</td>
			<td>都道府県</td>
		</tr>
		<c:forEach items="${hotel}" var="hotel">
			<tr>
				<td>${hotel.no}</td>
				<td>${hotel.id}</td>
				<td>${hotel.name}</td>
				<td>${hotel.region}</td>
			</tr>
		</c:forEach>

	</table>
</form>
</body>
</html>
