<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp"></c:import>
<script src="<c:url value='/js/mileageUse.js'/>"></script>
<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 130px">
	<div class="w3-col m7">
		<h3>
			<a href="index">홈</a>
		</h3>
		<c:choose>
			<c:when test="${sessionLevel == 3}">
				<form action="" method="post">
					<div class="w3-row-padding">
						<div class="w3-col m12">
							<div class="w3-card-2 w3-round w3-white">
								<div class="w3-container w3-padding">
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
									<hr class="w3-clear">

									합계: <input type="text" id="total" name="total" value="${total}"><br>
									마일리지 : <input type="text" id="mileage" name="mileage" value="">
									<input type="hidden" id="operation" value="-"> <input
										type="button" onclick='btnClick();return false;' value="적용">
									*사용 마일리지가 없으면 0을 입력해주세요.<br> 결제금액 :
									<div id="price">${total}</div>
									<input type="submit"
										class="w3-btn w3-theme-d1 w3-margin-bottom" value="결제" />

								</div>
							</div>
						</div>
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<form action="paymentAd" method="post">
					<div class="w3-row-padding">
						<div class="w3-col m12">
							<div class="w3-card-2 w3-round w3-white">
								<div class="w3-container w3-padding">
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
													<td><a href="deleteAdApplyList?adNo=${list.adNo}"><button
																type="button">취소</button></a></td>
												</tr>
											</tbody>
										</c:forEach>
									</table>
									<hr class="w3-clear">

									합계: 	<input type="text" id="total" name="total" value="${total}" readonly> <br> 
									결제금액 : <div id="price">${total}</div>
											<input type="submit" class="w3-btn w3-theme-d1 w3-margin-bottom" value="결제" />

								</div>
							</div>
						</div>
					</div>
				</form>

			</c:otherwise>
		</c:choose>
	</div>
</div>
<c:import url="../module/footer.jsp"></c:import>
