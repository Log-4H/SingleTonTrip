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
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/examples/city.jpg');"></div>
		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 1400px; margin-top: 80px">
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
														<input type="submit" class="w3-btn w3-theme-d1 w3-margin-bottom" value="결제" />
										</c:when>
										<c:otherwise>
											<form action="paymentAd" method="post">
												<table class="table">
													<thead>
														<tr>
															<th>#</th>
															<th>결제 내용</th>
															<th>가격</th>
															<th>취소</th>
														</tr>
													</thead>
													<c:forEach var="list" items="${paymentList}">
														<tbody>
															<tr>
																<td>1</td>
																<td>${list.adContent}</td>
																<td>${list.adTotalPrice}</td>
																<td>
																	<a href="deleteAdApplyList?adNo=${list.adNo}"><button type="button">취소</button></a>
																</td>
															</tr>
														</tbody>
														<input type="hidden" name="adNo" value="${list.adNo}">
													</c:forEach>
												</table>
												<hr class="w3-clear">

												합계: 	<input type="text" id="total" name="total" value="${total}" readonly> <br> 
												결제금액 : <div id="price">${total}</div>
														<input type="submit" class="w3-btn w3-theme-d1 w3-margin-bottom" value="결제" />
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