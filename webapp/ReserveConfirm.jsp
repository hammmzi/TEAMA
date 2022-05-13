<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿予約確認</title>
</head>

<body>
<form action="/DevelopExercise/ReserveServlet?action=confirm" method="post">
<h3>宿予約確認</h3>
<jsp:include page="/menu.jsp" />
<p>宿名</p>
<p>電話番号</p>
<p>チェックイン：${reservation.check_in}</p>
<p>チェックアウト：${reservation.check_out}</p>
<p>プラン名</p>
<p>部屋数</p>
<p>値段</p>
<input type="submit" value="利用規約に同意して予約する">
</form>


</body>
</html>