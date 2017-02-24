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
					<td><a href="#"><button name="adNo" value="${list.adNo}">취소</button></a></td>			
				</tr>
			</c:forEach>
		</table>
		합계: 	<input type="text" id="total" value="${total}"><br>
		마일리지 : <input type="text" id="mileage" name="mileage" value="">
				<input type="hidden" id="operation" value="-">
				<input type="button" class="minus" onclick='btnClick();return false;' value="적용"><br>
		결제금액 :	<div id="price" name="price">${total}</div>
				<input type="submit" value="결제">
	</form>
</body>
</html>