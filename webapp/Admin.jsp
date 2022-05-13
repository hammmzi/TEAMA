<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用メニュー</title>
</head>

<body>
<h3>管理者用メニュー</h3>
<jsp:include page="/menu.jsp" />
<p>会員管理</p>
<p>会員情報検索、変更、退会</p>
<a href="/MemberManage.jsp">移動する</a> <!-- リンクを挿入 -->

<p>宿管理</p>
<p>宿情報登録、検索、変更、退会</p>
<a href="/HotelManage.jsp">移動する</a> <!-- リンクを挿入 -->
</body>
</html>