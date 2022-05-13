<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ</title>
</head>

<body>
<h3>マイページ</h3>
<jsp:include page="/menu.jsp" />
<p>会員修正</p>
<p>会員情報を修正します</p>
<a href="/DevelopExcercise/Change.jsp">移動する</a> <!-- リンクを挿入 -->

<p>会員退会</p>
<p>退会します</p>
<a href="/DevelopExcercise/LeaveFinish.jsp">移動する</a> <!-- リンクを挿入 -->
</body>
</html>