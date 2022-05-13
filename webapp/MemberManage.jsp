<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員管理</title>
</head>

<body>
<h3>会員管理</h3>
<jsp:include page="/menu.jsp" />

<h4>会員検索</h4>
<form action="/DevelopExercise/MemberSearchServlet?action=search" method="post">
<label for="name"><strong>*</strong>名前</label><input type="text"
				id="name" name="name" required="required" placeholder="名前を入力してください。"><br>
<label for="tel"><strong>*</strong>電話番号</label><input type="text"
				id="tel" name="tel" required="required" placeholder="電話番号を入力してください。"><br>
<label for="address">住所</label><input type="text"
				id="address" name="address" placeholder="住所を入力してください。"><br>
<label for="mail">メール</label><input type="text"
				id="mail" name="mail"  placeholder="メールアドレスを入力してください。"><br>
<label for="birthday">生年月日</label><input type="date"
				id="birthday" name="birthday"> <br>
<input type="submit" value="検索"> <!-- リンクを挿入 -->
</form>
<p>(*)は必須項目です。</p>

<table border="1"> 
<tr><td>CN</td><td>Name</td><td>TEL</td><td>Address</td><td>Mail</td><td>Birthday</td></tr>
<c:forEach items="${MemberList}" var="member"> <!--MemberListはサーブレットで作成  -->
<tr>
<td>${member.cn}</td><td>${member.name}</td><td>${member.tel}</td>
<td>${member.address}</td><td>${member.mail}</td><td>${member.birthday}</td>
</tr>
</c:forEach>
</table>

<hr>

<p>${MemberList}</p>
<h4>会員情報変更</h4>
<form action="/DevelopExercise/MemberChangeServlet?action=update" method="post">

<label for="CN"><strong>*</strong>CN</label><input type="text"
				id="CN" name="naCN" required="required" placeholder="CNを入力してください。"><br>
<label for="name"><strong>*</strong>名前</label><input type="text"
				id="name" name="name" required="required" placeholder="名前を入力してください。"><br>
<label for="address"><strong>*</strong>住所</label><input type="text"
				id="address" name="address" required="required" placeholder="住所を入力してください。"><br>				
<label for="tel"><strong>*</strong>電話番号</label><input type="text"
				id="tel" name="tel" required="required" placeholder="電話番号を入力してください。"><br>
<label for="mail"><strong>*</strong>メールアドレス</label><input type="text"
				id="mail" name="mail" required="required" placeholder="メールアドレスを入力してください。"><br>
<label for="password"><strong>*</strong>パスワード</label><input type="password"
				id="password" name="password" required="required" placeholder="パスワードを入力してください。"><br>
<label for="birthday"><strong>*</strong>生年月日</label><input type="date"
				id="birthday" name="birthday" > <br>

<input type="submit" value="更新"> <!-- リンクを挿入 -->
</form>
<p>(*)は必須項目です。</p>

<hr>

<p>${leaveMessage}</p>
<h4>会員退会</h4>
<form action="/DevelopExercise/MemberLeaveServlet?action=memberLeave" method="post"> <!-- リンクを挿入 -->

<label for="name"><strong>*</strong>CN</label><input type="text"
				id="CN" name="name" required="required" placeholder="CNを入力してください。"><br>
<input type="submit" value="退会">
</form>
<p>(*)は必須項目です。</p>

</body>
</html>