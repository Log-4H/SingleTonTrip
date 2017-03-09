<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp"></c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>광고 신청</title>
</head>
<body>
<c:if test="${sessionLevel eq null || sessionLevel ne '1' && sessionLevel ne '2'}">
<script type="text/javascript">
	alert('업체 전용 페이지 입니다');
</script>
<% response.sendRedirect("index"); %>
</c:if>
<h3><a href="index">홈</a></h3>
<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 130px">
	<div class="w3-col m7">
	<form action="/adApply" method="post" enctype="multipart/form-data">
	<div class="w3-row-padding">
		<div class="w3-col m12">
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container w3-padding">
					<fieldset>
						<legend>단가 목록</legend>
						<table class="table">
							<tr>
								<th></th>
								<th>설명</th>
								<th>가격(1일)</th>
								<th>수량(일수)</th>
								<th>합계</th>
							</tr>
							<c:forEach var="ad" items="${adPrice}" >
								<tr>
									<td><input type="radio" name="adPriceCd" value="${ad.adPriceCd}"></td>
									<td>${ad.adPriceDetail}</td>
									<td>${ad.adPricePerday}</td>
									<td>${ad.adPriceAmount}</td>
									<td>${ad.adPriceTotal}</td>
								</tr>
							</c:forEach>
						</table>
						</fieldset><br>
						<center>
							<p>*광고에 쓰일 이미지 파일을 등록 해 주세요.</p>
							<input type="file" name="imgFile">
							<input type="submit" value="신청"><br>
							<a href="payAdd">결제하러 가기</a>
						</center>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>
</div>
</body>
</html>

