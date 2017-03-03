<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결제 정보</title>
<script type="text/javascript">
function btnClick() {
    //대입 숫자
    var num1=document.getElementById("total").value;
    var num2=document.getElementById("mileage").value;
    //연산자
    var operation=document.getElementById("operation").value;
    //결과값 넣기
    document.getElementById("price").innerHTML =eval(num1+operation+num2); 
}
</script>
</head>
<body>
<c:choose>
	<c:when test="${sessionLevel == 3}">
		<form action="" method="post">
			<table border=1>
				<tr>
					<th>결제 내용</th>
					<th>가격</th>
					<th>취소</th>
				</tr>
				<c:forEach var="list" items="${paymentList}">
					<tr>
						<td>${list.adContent}</td>
						<td>${list.adTotalPrice}</td>
						<td><a href=""><button type="button">취소</button></a></td>			
					</tr>
				</c:forEach>
			</table>
			합계: 	<input type="text" id="total" name="total" value="${total}"><br>
			마일리지 : <input type="text" id="mileage" name="mileage" value="">
					<input type="hidden" id="operation" value="-">
					<input type="button" onclick='btnClick();return false;' value="적용"> *사용 마일리지가 없으면 0을 입력해주세요.<br>
			결제금액 :	<div id="price">${total}</div>
					<input type="submit" value="결제">
		</form>
	</c:when>
	<c:otherwise>
		<form action="paymentAd" method="post" enctype="multipart/form-data">
			<table border=1>
				<tr>
					<th>결제 내용</th>
					<th>가격</th>
					<th>취소</th>
				</tr>
				<c:forEach var="list" items="${paymentList}">
					<tr>
						<td>${list.adContent}</td>
						<td>${list.adTotalPrice}</td>
						<td><a href="deleteAdApplyList?adNo=${list.adNo}"><button type="button">취소</button></a></td>
					</tr>
				</c:forEach>
			</table>
			합계: 	<input type="text" id="total" name="total" value="${total}" readonly><br>
			결제금액 :	<div id="price">${total}</div>
					<input type="submit" value="결제">
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>