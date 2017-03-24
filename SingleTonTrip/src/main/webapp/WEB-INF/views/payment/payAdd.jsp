<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<style>
a.panelFocus a, a:hover, a:focus {
	color: black;
}
</style>
<script>
// 마일리지 대입 값
function btnClick() {
    // 대입 숫자
    var num1=document.getElementById("total").value;
    var num2=document.getElementById("mileage").value;
    // 연산자
    var operation=document.getElementById("operation").value;
    // 결과값 넣기
    document.getElementById("price").innerHTML =eval(num1+operation+num2); 
};
// 결제 취소 버튼
function deleteAdApply_click() {
	console.log('paymentAdd suc');
	var check = confirm('결제 목록에서 삭제 하시겠습니까?');
	if(check == true) {
		document.form.submit();
		alert('삭제 되었습니다');
	} else {
		return false;
	}
};
// 결제 버튼
function paymentAd_click() {
	console.log('paymentAdd suc');
	var check = confirm('결제 하시겠습니까?');
	if(check == true) {
		document.form.submit();
		alert('결제 되었습니다');
	} else {
		return false;
	}
};
</script>
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/examples/city.jpg');"></div>
		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 100%; margin-top: 80px; margin-bottom: 50px">
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								<div class="header header-primary text-center"
									style="height: 80px;">
									<h4>결제 리스트</h4>
								</div>
								<div class="content">
									</br>
									<c:choose>
										<c:when test="${sessionLevel == 3}">
											<form action="" method="post">
												<table class="table">
													<thead>
														<tr>
															<th>#</th>
															<th>결제 내용</th>
															<th>가격</th>
															<th>Age</th>
															<th>City</th>
															<th>취소</th>
														</tr>
													</thead>
													<c:forEach var="list" items="${paymentList}">
														<tbody>
															<tr>
																<td>1</td>
																<td>${list.adContent}</td>
																<td>${list.adTotalPrice}</td>
																<td>35</td>
																<td>New York</td>
																<td><a href=""><button type="button">취소</button></a></td>
															</tr>
														</tbody>
													</c:forEach>
												</table>
												합계: 	<input type="text" id="total" name="total" value="${total}"><br> 
												마일리지 : <input type="text" id="mileage" name="mileage" value=""> 
														<input type="hidden" id="operation" value="-"> 
														<input type="button" onclick='btnClick();return false;' value="적용">
												*사용 마일리지가 없으면 0을 입력해주세요.<br> 
												결제금액 : <div id="price">${total}</div>
														<input type="submit" onclick="paymentAd_click();return false;" value="결제" />
										</c:when>
										<c:otherwise>
											<form action="paymentAd" method="post">
												<table class="table">
													<thead>
														<tr>
															<th>신청번호</th>
															<th>결제 내용</th>
															<th>가격</th>
															<th></th>
														</tr>
													</thead>
													<c:forEach var="list" items="${paymentList}">
														<tbody>
															<tr>
																<td>${list.adNo}</td>
																<td>${list.adContent}</td>
																<td>${list.adTotalPrice}</td>
																<td>
																	<a href="deleteAdApplyList?adNo=${list.adNo}" onclick="deleteAdApply_click(); return false;">취소</a>
																</td>
															</tr>
														</tbody>
														<input type="hidden" name="adNo" value="${list.adNo}">
													</c:forEach>
												</table>
												<hr class="w3-clear">
												<div align="right">
													합계:<input type="text" id="total" name="total" value="${total}" readonly/> <br> 
														<input type="submit" onclick="paymentAd_click();return false;" value="결제">
												</div>
											</form>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views//module/footer.jsp" />
</body>
</html>