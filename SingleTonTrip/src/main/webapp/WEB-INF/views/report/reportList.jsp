<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<body class="components-page">
	<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/base/pageMain.jpg');"></div>
		<div class="main main-raised">
			<div class="section">
				<div class="container">
					<div class="row">
						<c:import url="/WEB-INF/views/module/left.jsp"></c:import>
						<div class="col-md-8 col-md-offset-1">
							<div class="tim-container">
								<div class="card card-signup">
									<div class="header header-primary text-center"
										style="height: 80px;">
										<h4>
											<i class="material-icons">notifications</i> 신고리스트
										</h4>
									</div>
									<div class="content">
										<div align="right">
											<c:if test="${sessionLevel ne null && sessionLevel != 1}">
											<a href="reportAdd"><button type="button" class="btn btn-primary">
												<i class="fa fa-pencil"></i> 신고하기
											</button></a>
										</c:if>
										</div>
										<div class="table-responsive">
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
													<a
														href="<c:url value='reportList?currentPage=${startPage-pageSize}'/>">prev</a>
												</c:if>
												<c:forEach var="i" begin="${startPage}" end="${endPage}"
													step="1">
													<a href="<c:url value='reportList?currentPage=${i}'/>">${i}</a>
												</c:forEach>
												<c:if test="${endPage ne lastPage}">
													<a
														href="<c:url value='reportList?currentPage=${startPage+pageSize}'/>">next</a>
												</c:if>
											</div>
										</div>
									</div>
								</div>
								<br> <br> <br> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
	</div>
</body>
</html>