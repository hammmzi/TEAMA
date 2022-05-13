<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更</title>
<style type="text/css">
strong {
	color: red;
}

p {
	color: red;
	align-self: unset;
}

.layout {
	width: 300px;
	margin: 0 auto;
	padding: 30px;
	background-color: #c1e4e9;
	border: 1px solid #000000;
}
</style>
</head>
<body>
	<h2>会員情報変更</h2>

	<form>

		<jsp:include page="/menu.jsp" />
		<hr>
		<div class="layout">
			<h3>お客様情報</h3>

			<label for="mail"><strong>*</strong>メール</label><input type="text"
				id="mail" required="required" placeholder="メールアドレスを入力してください。"><br>
			<label for="mail"><strong>*</strong>パスワード</label><input type="text"
				id="pw" required="required" placeholder="パスワードを入力してください。"><br>
			<label for="mail"><strong>*</strong>名前</label><input type="text"
				id="name" required="required" placeholder="名前を入力してください。"><br>
			<label for="mail"><strong>*</strong>住所</label><input type="text"
				id="address" required="required" placeholder="名前を入力してください。"><br>
			<label for="mail"><strong>*</strong>電話番号</label><input type="text"
				id="tel" required="required" placeholder="電話番号を入力してください。"><br>
			<label for="mail"><strong>*</strong>生年月日</label><input type="date"
				id="birthday" required="required"> <br>

			<input type="submit" value="変更">
			<p>(*)は必須項目です。</p>
		</div>

	</form>

</body>
</html>