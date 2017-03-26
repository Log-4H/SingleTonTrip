<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />

<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/base/BackImage.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 800px; margin-top: 80px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>신고리스트</h4>
								</div>
									<div class="content">

										<table class="table">
											<thead>
												<tr>
													<td>no</td>
													<td>제목</td>
													<td>날짜</td>
													<td>상태</td>				
												</tr>
											</thead>
											
											<tbody>
												<c:forEach items="${reportList}" var="r" varStatus="i">
													<tr>
														<td>${i.index}</td>
														<td><a href="<c:url value='reportDetail?reportNo=${r.reportNo}'/>">${r.reportTitle}</a></td>
														<td>${r.reportDate}</td>
														<td>${r.approveStateNm}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div align="center">
											<c:if test="${startPage>1}">
												<a href="<c:url value='reportList?currentPage=${startPage-pageSize}'/>">prev</a>
											</c:if>
											<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
												<a href="<c:url value='reportList?currentPage=${i}'/>">${i}</a>
											</c:forEach>
											<c:if test="${endPage ne lastPage}">
												<a href="<c:url value='reportList?currentPage=${startPage+pageSize}'/>">next</a>
											</c:if>
										</div>
									</div>
							</div>
						</div>
						<a href="reportAdd"><button class="btn btn-simple btn-primary btn-lg">신고하기</button></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views//module/footer.jsp" />
</body>
</html>