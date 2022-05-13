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
<script src="js/openclose.js"></script>
<script src="js/fixmenu_pagetop.js"></script>
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

<div class="side-menu">
	<jsp:include page="/menu.jsp" />
</div>
<hr>

<form action="/shopping/CartServlet?action=add" method="post">

<!-- <dt><label for="dh-checkin">チェックイン</label></dt>
<dd><input id="dh-checkin" type="date" value=<%= GetDate()%> ></dd>

<dt><label for="dh-checkout">チェックアウト</label></dt>
<dd><input id="dh-checkout" type="date" value=<%= GetDate()+1%> ></dd> -->


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

<dt><label for="address">住所</label></dt>
<dd><input type="text" name="address">
</dd>

<dt><label for="price">合計料金（<span id="dh-price-label" class="priceNights">1</span>泊）</label></dt>
<dd>
<select name="min" id="min">
    <option value="0" selected>下限なし</option>
    <option value="1000">1,000円</option>
    <option value="2000">2,000円</option><option value="3000">3,000円</option><option value="4000">4,000円</option><option value="5000">5,000円</option><option value="6000">6,000円</option><option value="7000">7,000円</option><option value="8000">8,000円</option><option value="9000">9,000円</option><option value="10000">10,000円</option><option value="12000">12,000円</option><option value="14000">14,000円</option><option value="16000">16,000円</option><option value="18000">18,000円</option><option value="20000">20,000円</option><option value="30000">30,000円</option><option value="40000">40,000円</option><option value="50000">50,000円</option><option value="100000">100,000円</option><option value="150000">150,000円</option><option value="200000">200,000円</option>
</select>
<span>～</span>
<select name="max" id="max">
    <option value="1000">1,000円</option>
    <option value="2000">2,000円</option><option value="3000">3,000円</option><option value="4000">4,000円</option><option value="5000">5,000円</option><option value="6000">6,000円</option><option value="7000">7,000円</option><option value="8000">8,000円</option><option value="9000">9,000円</option><option value="10000">10,000円</option><option value="12000">12,000円</option><option value="14000">14,000円</option><option value="16000">16,000円</option><option value="18000">18,000円</option><option value="20000">20,000円</option><option value="30000">30,000円</option><option value="40000">40,000円</option><option value="50000">50,000円</option><option value="100000">100,000円</option><option value="150000">150,000円</option>
    <option value="200000">200,000円</option>
    <option value="999999" selected>上限なし</option>
</select>
<div class="priceSupplement">※1部屋あたり消費税込み</div>
</dd>

<dt><label for="heya_su">ご利用部屋数</label></dt>
<dd>
<select id="heya_su" name="heya_su">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>部屋
</dd>

<p>
<dd><input type="submit" value="検索"></dd>
</p>
<!-- <p class="stdSrchBtn smlSz"><a href="javascript:void(0);">検索</a></p> -->
</form>
<hr>
</div>


<div class="container">
    <div class="main-contents">
    <h2 class="dn">お知らせ</h2>
    <h3>金山温泉が安い！</h3>
      残り部屋数わずかとなっております。<br>
      ご予約はお早めに
    </div>
</div>

</body>
</html>