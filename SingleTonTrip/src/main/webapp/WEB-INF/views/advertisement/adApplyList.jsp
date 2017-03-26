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
	<c:if
		test="${sessionLevel eq null || sessionLevel ne '1' && sessionLevel ne '2'}">
		<script type="text/javascript">
			alert('관리자 전용 페이지 입니다');
		</script>
		<c:redirect url="index" />
	</c:if>
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/base/BackImage.jpg');"></div>
		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 1400px; margin-top: 80px">
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								<div class="header header-primary text-center"
									style="height: 80px;">
									<h4>광고 신청 리스트</h4>
								</div>
								<div class="content">
									</br>
									<table class="table">
										<thead>
											<tr>
												<th>번호</th>
												<th>신청자</th>
												<th>내용</th>
												<th>이미지파일</th>
												<th>신청일</th>
												<th>결제일</th>
												<th>상태</th>
												<c:if test="${sessionLevel == 1}">
													<th>여부</th>
												</c:if>
											</tr>
										</thead>
										<c:forEach var="a" items="${adApplyList}">
											<tbody>
												<tr>
													<td>${a.adNo}</td>
													<td>${a.companyId}</td>
													<td>${a.adContent}</td>
													<td>
														<a href="<%=request.getContextPath() %>/images/${a.adImg}" target="_blank">${a.adImg}</a>
													</td>
													<td>${a.adApplyDate}</td>
													<td>${a.paymentFinishDate}</td>
													<td>${a.approveStateNm}</td>
													<td>
														<c:if test="${sessionLevel == 1}">
															<a href="adApprove?adNo=${a.adNo}&companyId=${a.companyId}&adGroupCd=${a.adGroupCd}">승인</a>/
															<a href="adRefuse?adNo=${a.adNo}">거절</a>
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