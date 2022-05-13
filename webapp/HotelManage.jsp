<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.Date, java.text.DateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>五反田トラベル: 宿・ホテル予約 国内旅行・海外旅行 予約サイト</title>
<link rel="stylesheet" href="css/style.css">
<!-- <script src="js/openclose.js"></script>
<script src="js/fixmenu_pagetop.js"></script> -->
</head>
<body>

<div id="domestic-search-box" class="inner">

<!--start of domestic hotel search-->
<!-- <input type="hidden" value="1" name="f_image">
<input type="hidden" value="30" name="f_hyoji">
<input type="hidden" value="tiku" name="f_ptn">
<input type="hidden" value="" name="f_setubi">
<input type="hidden" class="ignore-history" name="f_teikei" value="quick">
<input type="hidden" name="lid" value="topC_search_hotel"> -->
<!-- <div id="dh-search-history"></div>
<dl class="srcStructure srcSt01"> -->

<!-- function () {
<script>
    var today = new Date();
    today.setDate(today.getDate());
    var yyyy = today.getFullYear();
    var mm = ("0"+(today.getMonth()+1)).slice(-2);
    var dd = ("0"+today.getDate()).slice(-2);
    document.getElementById("today").value=yyyy+'-'+mm+'-'+dd;
</script>
} -->

<%!
  //メソッドの宣言
  private String GetDate() {
    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
    Date date = new Date();
    return df.format(date);
  }
%>

<h1 class="Subtitle">宿管理</h1>

<div class="side-menu">
	<jsp:include page="/menu.jsp" />
</div>

<hr>
<form action="/DevelopExercise/HotelSearchServlet?action=search" method="post">
<h2 class="dn">宿検索</h2>

<dt><label for="hotelid">宿ID</label></dt>
<dd><input type="text" name="hotelid">
</dd>

<dt><label for="pref">都道府県</label></dt>
<dd>
<select id="dh-middle" name="f_chu">
    <optgroup label="北海道">
        <option value="hokkaido">北海道</option>
    </optgroup>
    <optgroup label="東北">
        <option value="iwate">岩手県</option>
        <option value="miyagi">宮城県</option>
        <option value="aomori">青森県</option>
        <option value="akita">秋田県</option>
        <option value="hukushima">福島県</option>
        <option value="yamagata">山形県</option>
    </optgroup>
    <optgroup label="北関東">
        <option value="tochigi">栃木県</option>
        <option value="ibaragi">茨城県</option>
        <option value="gunma">群馬県</option>
    </optgroup>
    <optgroup label="首都圏">
        <option value="tiba">千葉県</option><option value="saitama">埼玉県</option><option value="tokyo" selected>東京都</option><option value="kanagawa">神奈川県</option></optgroup><optgroup label="甲信越"><option value="niigata">新潟県</option><option value="yamanasi">山梨県</option><option value="nagano">長野県</option></optgroup><optgroup label="北陸"><option value="toyama">富山県</option><option value="ishikawa">石川県</option><option value="hukui">福井県</option></optgroup><optgroup label="東海"><option value="aichi">愛知県</option><option value="mie">三重県</option><option value="gihu">岐阜県</option><option value="shizuoka">静岡県</option></optgroup><optgroup label="近畿"><option value="nara">奈良県</option><option value="hyogo">兵庫県</option><option value="osaka">大阪府</option><option value="kyoto">京都府</option><option value="wakayama">和歌山県</option><option value="shiga">滋賀県</option></optgroup><optgroup label="山陽・山陰"><option value="okayama">岡山県</option><option value="simane">島根県</option><option value="tottori">鳥取県</option><option value="hiroshima">広島県</option><option value="yamaguchi">山口県</option></optgroup><optgroup label="四国"><option value="tokushima">徳島県</option><option value="kagawa">香川県</option><option value="ehime">愛媛県</option><option value="kouchi">高知県</option></optgroup><optgroup label="九州"><option value="hukuoka">福岡県</option><option value="saga">佐賀県</option><option value="nagasaki">長崎県</option><option value="kumamoto">熊本県</option><option value="ooita">大分県</option><option value="miyazaki">宮崎県</option><option value="kagoshima">鹿児島県</option>
    </optgroup>
    <optgroup label="沖縄">
        <option value="okinawa">沖縄県</option>
    </optgroup>
</select>
</dd>

<dt><label for="address">住所(都道府県を除く)</label></dt>
<dd><input type="text" name="address">
</dd>

<dt><label for="name">宿名</label></dt>
<dd><input type="text" name="name">
</dd>

<p>
<dd><input type="submit" value="検索"></dd>

</p>

</form>

<hr>
<h3 class="add">宿ID:${hotel.id}番の登録処理を完了しました</h3>
<form action="/DevelopExercise/HotelEntryServlet?action=add" method="post">
<h2 class="dn">宿登録</h2>

<dt><label for="hotelid">宿ID</label></dt>
<dd><input type="text" name="hotelid">
</dd>

<dt><label for="pref">都道府県</label></dt>
<dd>
<select id="dh-middle" name="f_chu">
    <optgroup label="北海道">
        <option value="hokkaido">北海道</option>
    </optgroup>
    <optgroup label="東北">
        <option value="iwate">岩手県</option>
        <option value="miyagi">宮城県</option>
        <option value="aomori">青森県</option>
        <option value="akita">秋田県</option>
        <option value="hukushima">福島県</option>
        <option value="yamagata">山形県</option>
    </optgroup>
    <optgroup label="北関東">
        <option value="tochigi">栃木県</option>
        <option value="ibaragi">茨城県</option>
        <option value="gunma">群馬県</option>
    </optgroup>
    <optgroup label="首都圏">
        <option value="tiba">千葉県</option><option value="saitama">埼玉県</option><option value="tokyo" selected>東京都</option><option value="kanagawa">神奈川県</option></optgroup><optgroup label="甲信越"><option value="niigata">新潟県</option><option value="yamanasi">山梨県</option><option value="nagano">長野県</option></optgroup><optgroup label="北陸"><option value="toyama">富山県</option><option value="ishikawa">石川県</option><option value="hukui">福井県</option></optgroup><optgroup label="東海"><option value="aichi">愛知県</option><option value="mie">三重県</option><option value="gihu">岐阜県</option><option value="shizuoka">静岡県</option></optgroup><optgroup label="近畿"><option value="nara">奈良県</option><option value="hyogo">兵庫県</option><option value="osaka">大阪府</option><option value="kyoto">京都府</option><option value="wakayama">和歌山県</option><option value="shiga">滋賀県</option></optgroup><optgroup label="山陽・山陰"><option value="okayama">岡山県</option><option value="simane">島根県</option><option value="tottori">鳥取県</option><option value="hiroshima">広島県</option><option value="yamaguchi">山口県</option></optgroup><optgroup label="四国"><option value="tokushima">徳島県</option><option value="kagawa">香川県</option><option value="ehime">愛媛県</option><option value="kouchi">高知県</option></optgroup><optgroup label="九州"><option value="hukuoka">福岡県</option><option value="saga">佐賀県</option><option value="nagasaki">長崎県</option><option value="kumamoto">熊本県</option><option value="ooita">大分県</option><option value="miyazaki">宮崎県</option><option value="kagoshima">鹿児島県</option>
    </optgroup>
    <optgroup label="沖縄">
        <option value="okinawa">沖縄県</option>
    </optgroup>
</select>
</dd>

<dt><label for="address">住所(都道府県を除く)</label></dt>
<dd><input type="text" name="address">
</dd>

<dt><label for="tel">電話番号</label></dt>
<dd><input type="text" name="tel">
</dd>

<dt><label for="name">宿名</label></dt>
<dd><input type="text" name="name">
</dd>

<div class="layout">
			<label for="plan1"><strong>*</strong>プラン名1</label><input type="text"
				id="plan1" required="required" placeholder="プラン名を入力してください。"><br>
			<label for="room1"><strong>*</strong>プラン1の部屋数</label><input type="text"
				id="room1" required="required" placeholder="部屋数を入力してください。"><br>
			<label for="price1"><strong>*</strong>プラン1の値段</label><input type="text"
				id="price1" required="required" placeholder="名前を入力してください。"><br>
			<label for="in1"><strong>*</strong>プラン1のチェックイン時間</label>
			<select id="in1" name="in1">
				<option value="15:00">15:00</option>
				<option value="16:00">16:00</option>
				<option value="17:00">17:00</option>
				<option value="18:00">18:00</option>
				<option value="19:00">19:00</option>
				<option value="20:00">20:00</option>
				<option value="21:00">21:00</option>
				<option value="22:00">22:00</option>
				<option value="23:00">23:00</option>
				<option value="24:00">24:00</option>
			</select><br>
			<label for="out1"><strong>*</strong>プラン1のチェックアウト時間</label>
			<select id="out1" name="out1">
				<option value="9:00">9:00</option>
				<option value="10:00">10:00</option>
				<option value="11:00">11:00</option>
				<option value="12:00">12:00</option>
				<option value="13:00">13:00</option>
				<option value="14:00">14:00</option>
			</select><br>
			
			<label for="plan2"><strong>*</strong>プラン名2</label><input type="text"
				id="plan2" required="required" placeholder="プラン名を入力してください。"><br>
			<label for="room2"><strong>*</strong>プラン2の部屋数</label><input type="text"
				id="room2" required="required" placeholder="部屋数を入力してください。"><br>
			<label for="price2"><strong>*</strong>プラン2の値段</label><input type="text"
				id="price2" required="required" placeholder="名前を入力してください。"><br>
			<label for="in2"><strong>*</strong>プラン2のチェックイン時間</label>
			<select id="in2" name="in2">
				<option value="15:00">15:00</option>
				<option value="16:00">16:00</option>
				<option value="17:00">17:00</option>
				<option value="18:00">18:00</option>
				<option value="19:00">19:00</option>
				<option value="20:00">20:00</option>
				<option value="21:00">21:00</option>
				<option value="22:00">22:00</option>
				<option value="23:00">23:00</option>
				<option value="24:00">24:00</option>
			</select><br>
			<label for="out2"><strong>*</strong>プラン2のチェックアウト時間</label>
			<select id="out2" name="out2">
				<option value="9:00">9:00</option>
				<option value="10:00">10:00</option>
				<option value="11:00">11:00</option>
				<option value="12:00">12:00</option>
				<option value="13:00">13:00</option>
				<option value="14:00">14:00</option>
			</select><br>
			
			<input type="submit" value="登録"> <!-- リンクを挿入 -->
			<p>(*)は必須項目です。</p>
		</div>
</form>

<hr>
<h3 class="update">宿ID:${hotel.id}番の変更処理を完了しました</h3>

<form action="/DevelopExercise/src/main/java/hotel/HotelChangeServlet?action=update" method="post">
<h2 class="dn">宿変更</h2>

<dt><label for="hotelid">宿ID</label></dt>
<dd><input type="text" name="hotelid">
</dd>

<dt><label for="pref">都道府県</label></dt>
<dd>
<select id="dh-middle" name="f_chu">
    <optgroup label="北海道">
        <option value="hokkaido">北海道</option>
    </optgroup>
    <optgroup label="東北">
        <option value="iwate">岩手県</option>
        <option value="miyagi">宮城県</option>
        <option value="aomori">青森県</option>
        <option value="akita">秋田県</option>
        <option value="hukushima">福島県</option>
        <option value="yamagata">山形県</option>
    </optgroup>
    <optgroup label="北関東">
        <option value="tochigi">栃木県</option>
        <option value="ibaragi">茨城県</option>
        <option value="gunma">群馬県</option>
    </optgroup>
    <optgroup label="首都圏">
        <option value="tiba">千葉県</option><option value="saitama">埼玉県</option><option value="tokyo" selected>東京都</option><option value="kanagawa">神奈川県</option></optgroup><optgroup label="甲信越"><option value="niigata">新潟県</option><option value="yamanasi">山梨県</option><option value="nagano">長野県</option></optgroup><optgroup label="北陸"><option value="toyama">富山県</option><option value="ishikawa">石川県</option><option value="hukui">福井県</option></optgroup><optgroup label="東海"><option value="aichi">愛知県</option><option value="mie">三重県</option><option value="gihu">岐阜県</option><option value="shizuoka">静岡県</option></optgroup><optgroup label="近畿"><option value="nara">奈良県</option><option value="hyogo">兵庫県</option><option value="osaka">大阪府</option><option value="kyoto">京都府</option><option value="wakayama">和歌山県</option><option value="shiga">滋賀県</option></optgroup><optgroup label="山陽・山陰"><option value="okayama">岡山県</option><option value="simane">島根県</option><option value="tottori">鳥取県</option><option value="hiroshima">広島県</option><option value="yamaguchi">山口県</option></optgroup><optgroup label="四国"><option value="tokushima">徳島県</option><option value="kagawa">香川県</option><option value="ehime">愛媛県</option><option value="kouchi">高知県</option></optgroup><optgroup label="九州"><option value="hukuoka">福岡県</option><option value="saga">佐賀県</option><option value="nagasaki">長崎県</option><option value="kumamoto">熊本県</option><option value="ooita">大分県</option><option value="miyazaki">宮崎県</option><option value="kagoshima">鹿児島県</option>
    </optgroup>
    <optgroup label="沖縄">
        <option value="okinawa">沖縄県</option>
    </optgroup>
</select>
</dd>

<dt><label for="address">住所(都道府県を除く)</label></dt>
<dd><input type="text" name="address">
</dd>

<dt><label for="tel">電話番号</label></dt>
<dd><input type="text" name="tel">
</dd>

<dt><label for="name">宿名</label></dt>
<dd><input type="text" name="name">
</dd>

<div class="layout">
			<label for="plan1"><strong>*</strong>プラン名1</label><input type="text"
				id="plan1" required="required" placeholder="プラン名を入力してください。"><br>
			<label for="room1"><strong>*</strong>プラン1の部屋数</label><input type="text"
				id="room1" required="required" placeholder="部屋数を入力してください。"><br>
			<label for="price1"><strong>*</strong>プラン1の値段</label><input type="text"
				id="price1" required="required" placeholder="名前を入力してください。"><br>
			<label for="in1"><strong>*</strong>プラン1のチェックイン時間</label>
			<select id="in1" name="in1">
				<option value="15:00">15:00</option>
				<option value="16:00">16:00</option>
				<option value="17:00">17:00</option>
				<option value="18:00">18:00</option>
				<option value="19:00">19:00</option>
				<option value="20:00">20:00</option>
				<option value="21:00">21:00</option>
				<option value="22:00">22:00</option>
				<option value="23:00">23:00</option>
				<option value="24:00">24:00</option>
			</select><br>
			<label for="out1"><strong>*</strong>プラン1のチェックアウト時間</label>
			<select id="out1" name="out1">
				<option value="9:00">9:00</option>
				<option value="10:00">10:00</option>
				<option value="11:00">11:00</option>
				<option value="12:00">12:00</option>
				<option value="13:00">13:00</option>
				<option value="14:00">14:00</option>
			</select><br>
			
			<label for="plan2"><strong>*</strong>プラン名2</label><input type="text"
				id="plan2" required="required" placeholder="プラン名を入力してください。"><br>
			<label for="room2"><strong>*</strong>プラン2の部屋数</label><input type="text"
				id="room2" required="required" placeholder="部屋数を入力してください。"><br>
			<label for="price2"><strong>*</strong>プラン2の値段</label><input type="text"
				id="price2" required="required" placeholder="名前を入力してください。"><br>
			<label for="in2"><strong>*</strong>プラン2のチェックイン時間</label>
			<select id="in2" name="in2">
				<option value="15:00">15:00</option>
				<option value="16:00">16:00</option>
				<option value="17:00">17:00</option>
				<option value="18:00">18:00</option>
				<option value="19:00">19:00</option>
				<option value="20:00">20:00</option>
				<option value="21:00">21:00</option>
				<option value="22:00">22:00</option>
				<option value="23:00">23:00</option>
				<option value="24:00">24:00</option>
			</select><br>
			<label for="out2"><strong>*</strong>プラン2のチェックアウト時間</label>
			<select id="out2" name="out2">
				<option value="9:00">9:00</option>
				<option value="10:00">10:00</option>
				<option value="11:00">11:00</option>
				<option value="12:00">12:00</option>
				<option value="13:00">13:00</option>
				<option value="14:00">14:00</option>
			</select><br>
			
			<input type="submit" value="変更"> <!-- リンクを挿入 -->
			<p>(*)は必須項目です。</p>
		</div>
</form>

<hr>
<h3 class="delete">宿ID:${hotel.id}番の削除処理を完了しました</h3>

<form action="/DevelopExercise/src/main/java/hotel/HotelDeleteServlet?action=delete" method="post">
<h2 class="dn">宿削除</h2>

<dt><label for="hotelid">宿ID</label></dt>
<dd><input type="text" name="hotelid">
</dd>
<input type="submit" value="削除"> <!-- リンクを挿入 -->
<p>(*)は必須項目です。</p>

</form>

<table border="1">
<tr><td>id</td><td>宿名</td><td>都道府県</td><td>住所</td><td>電話番号</td>
<td>プラン名1</td>
	<td>プラン1の部屋数</td>
	<td>プラン1の値段</td>
	<td>プラン1のチェックイン時間</td>
	<td>プラン1のチェックアウト時間</td>
<td>プラン名2</td>
	<td>プラン2の部屋数</td>
	<td>プラン2の値段</td>
	<td>プラン2のチェックイン時間</td>
	<td>プラン2のチェックアウト時間</td>
</tr>
<c:forEach items="${HotelList}" var="hotel"> <!--MemberListはサーブレットで作成  -->
<tr>
<td>${hotel.id}</td><td>${hotel.name}</td><td>${hotel.region}</td>
<td>${hotel.address}</td><td>${hotel.tel}</td><td>${hotel.plan1}</td>
<td>${hotel.room1}</td><td>${hotel.price1}</td><td>${hotel.in1}</td>
<td>${hotel.out1}</td><td>${hotel.plan2}</td><td>${hotel.room2}</td>
<td>${hotel.price2}</td><td>${hotel.in2}</td><td>${hotel.out2}</td>
</tr>
</c:forEach>
</table>

</body>
</html>