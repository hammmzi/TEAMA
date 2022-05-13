<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>五反田トラベル</title>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300'
	rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=Abel|Satisfy'
	rel='stylesheet' type='text/css' />
<link href="showHotel.css" rel="stylesheet" type="text/css" media="all" />
<!--[if IE 6]>
<link href="default_ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body>
	<div id="header-wrapper">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">五反田トラベル</a>
				</h1>
			</div>

			<br>
			<div>
				<jsp:include page="/menu.jsp" />
				<hr>
			</div>
		</div>
	</div>
	<div id="wrapper">
		<div id="page-wrapper">
			<div id="page">
				<div id="wide-content">
					<div>
						<c:if test="${not empty hotel.items}">
							<c:forEach items="${hotel.items }" var="item">
								<h2>${item.name }</h2>
								<p>
									<img src="hotelMain.jpg" alt="" width="300" height="186"
										class="alignleft" />
									<h3>
										<strong>住所 </strong> ${item.address }
									</h3>
									<h3>
										<strong>電話番号 </strong> ${item.tel }
									</h3>
									<h3>
										<strong>地域 </strong> ${item.region }
									</h3>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<!--　部屋詳細  -->
		<div id="page" class="container">
			<form action="/ReserveServlet.java" method="get">
				<div id="content">
					<div>
						<ul class="style1">
							<c:if test="${not empty hotel.items}">
								<c:forEach items="${hotel.items }" var="item">
									<li class="first">
										<h3>${item.plan1 }</h3>
										<p>1泊 ${item.price1 }</p>
										<p>部屋数 ${item.room1 }</p> チェックイン<input type="date"
										name="check_in" />
										<p>${item.in1}</p> チェックアウト<input type="date" name="check_out" />
										<p>${item.out1}</p> <input class="button-style" type="submit">予約</input>
									</li>
									<li>
										<h3>${item.plan2 }</h3>
										<p>1泊 ${item.price2 }</p>
										<p>部屋数 ${item.room2 }</p> チェックイン<input type="date"
										name="check_in" />
										<p>${item.in2}</p> チェックアウト<input type="date" name="check_out" />
										<p>${item.out2}</p> <input class="button-style" type="submit">予約</input>
									</li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
			</form>
			<!-- 部屋写真 -->
			<div id="sidebar">
				<h2>詳細写真</h2>
				<ul class="style3">
					<li class="first">
						<p class="date">ローヤルルーム</p>
						<p>
							<img src="" alt="" width="300" height="186"
										class="alignleft" />
						</p>
					</li>
					<li>
						<p class="date">ノーマルルーム</p>
						<p>
							<img src="" alt="" width="300" height="186"
										class="alignleft" />
						</p>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div id="footer" class="container">
		<p>
			&copy; Untitled. All rights reserved. Design by <a
				href="http://templated.co" rel="nofollow">HAMZI</a>. Photos by <a
				href="http://fotogrph.com/">Fotogrph</a>.
		</p>
	</div>
</body>
</html>


