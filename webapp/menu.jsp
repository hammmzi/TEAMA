<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="right">
<a href="/DevelopExercise/SearchHotelServlet?action=top">トップ</a>/

<a href="/DevelopExercise/MemberEntryServlet?action=mypage">マイページ</a>/

<c:if test="${empty loginMember}">
<a href="/DevelopExercise/LoginServlet?action=login">ログイン</a>/
</c:if>
<c:if test="${not empty loginMember}">
<a href="/DevelopExercise/LoginServlet?action=login">ログアウト</a>/
</c:if>
<a href="/DevelopExercise/MemberEntryServlet?action=show">会員登録</a>
</div>


