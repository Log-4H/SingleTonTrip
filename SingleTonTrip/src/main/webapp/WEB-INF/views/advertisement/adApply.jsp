<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>광고 신청</title>
</head>
<body>
<c:if test="${sessionLevel eq null || sessionLevel ne '2'}">
<script type="text/javascript">
	alert('관리자 전용 페이지 입니다');
</script>
<% response.sendRedirect("index"); %>
</c:if>
<form action="adApply" method="post">
	<fieldset>
		<legend>단가 목록</legend>
		<table>
			<tr>
				<th></th>
				<th>설명</th>
				<th>가격(1일)</th>
				<th>수량(일수)</th>
				<th>합계</th>
			</tr>
		<c:forEach var="ad" items="${adPrice}">
			<tr>
				<td><input type="checkbox" name="adPriceCd" value="${ad.adPriceCd}"></td>
				<td>${ad.adPriceDetail}</td>
				<td>${ad.adPricePerday}</td>
				<td>${ad.adPriceAmount}</td>
				<td>${ad.adPriceTotal}</td>
			</tr>
		</c:forEach>
		</table>
	</fieldset>
	<input type="submit" value="신청">
</form>
</body>
</html>