<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン/新規登録</title>
</head>

<body>
<h3>ログイン</h3>

<jsp:include page="/menu.jsp" />
<hr>
<div align="left">
<h5>ログイン</h5>
<form action="/DevelopExercise/LoginServlet" method="post">
<p>メール<input type="text" name="mail"></p>
<p>PW<input type="password" name="password"></p>
<input type="hidden" name="actin" value="login">
<input type="submit" value="ログイン">
</form>
</div>
<p>${message}</p>

<div align="left">
<form action="/DevelopExercise/LoginServlet" method="post">
<p>新規会員登録はこちらをクリック</p>
<input type="submit" value="会員登録">
</form>
</div>

</body>
</html>