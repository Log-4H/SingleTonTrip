<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<script src="<c:url value='/js/payCancel.js'/>"></script>
<style>
a.panelFocus a, a:hover, a:focus {
	color: black;
}
</style>
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/examples/city.jpg');"></div>
		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 1400px; margin-top: 80px">
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								<div class="header header-primary text-center"
									style="height: 70px;">
									<h4>환불 리스트</h4>
								</div>
								<div class="content">
									</br>
									<table class="table">
										<thead>
											<tr>
												<th>회원아이디</th>
												<th>결제금</th>
												<th>상품가</th>
												<th>결제등록일</th>
												<th>결제일</th>
												<th>관리자아이디</th>
												<th>상태</th>
												<th>여부</th>
											</tr>
										</thead>
										<c:forEach var="p" items="${paybackList}">
											<tbody>
												<tr>
													<td>${p.memberId}</td>
													<td>${p.paymentPrice}</td>
													<td>${p.paymentTotalPrice}</td>
													<td>${p.paymentApplyDate}</td>
													<td>${p.paymentFinishDate}</td>
													<td>${p.adminId}</td>
													<td>${p.paymentStateNm}</td>
													<td>
														<c:if test="${p.paymentPrice > 0}">
															<a href="payback?memberId=${p.memberId}&paymentTotalPrice=${p.paymentTotalPrice}&paymentTargetNo=${p.paymentTargetNo}" onclick="payback_click();return false;">환불</a>/
														</c:if>
														<c:if test="${p.paymentStateNm != '환불완료'}">
															<a href="paybackCancel?paymentTargetNo=${p.paymentTargetNo}" onclick="paybackCancel_click();return false;">취소</a>
														</c:if>
													</td>
												</tr>
											</tbody>
										</c:forEach>
									</table>
									<!-- 페이징 -->
									<div align="center">
										<ul class="pagination pagination-info">
											<c:if test="${startPage>1}">
												<li>
													<a href="<c:url value='adApplyList?currentPage=${startPage-pageSize}&selectValue=${selectValue}'/>">prev</a>
												</li>
											</c:if>
											<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
												<li>
													<a href="<c:url value='adApplyList?currentPage=${i}&selectValue=${selectValue}'/>">${i}</a>
												</li>
											</c:forEach>
											<c:if test="${endPage ne lastPage}">
												<li>
													<a href="<c:url value='adApplyList?currentPage=${startPage+pageSize}&selectValue=${selectValue}'/>">next</a>
												</li>
											</c:if>
										</ul>
									</div>
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