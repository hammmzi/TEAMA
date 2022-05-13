<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録</title>
<style type="text/css">
.wrap {
	display: flex;
	align-items: center;
	justify-content: center;
	width: 100%;
}

.change{
	padding: 0 auto;
	background-color: #f8f8ff;
}

.leave{
	padding: 0 auto;
	background-color: #f08080;
}

</style>
</head>
<body>
	<h2>マイページ</h2>

	<form>

		<jsp:include page="/menu.jsp" />
		<hr>
		<div class="wrap">
			<div class="change">会員情報変更</div>
			<div class="leave">退会</div>
		</div>
	</form>

</body>
</html>