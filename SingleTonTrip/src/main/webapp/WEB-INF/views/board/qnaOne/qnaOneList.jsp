<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<c:import url="./qnaOneAdd.jsp"></c:import>
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
											<i class="material-icons">help_outline</i> 1:1문의내역
										</h4>
									</div>
									<div class="content">
										<div align="right">
											<c:if test="${sessionLevel ne null && sessionLevel != 1}">
												<button type="button" class="btn btn-primary"
													onclick="qnaOneAddModalShow()">
													<i class="fa fa-pencil"></i>  1:1문의하기
												</button>
											</c:if>
										</div>
										<div class="table-responsive">
											<table class="table">
												<thead>
													<tr>
														<th class="text-center">#</th>
														<th class="text-center">Title</th>
														<th class="text-center">ID</th>
														<th class="text-right">RegDate</th>
														<c:if test="${sessionLevel ne null && sessionLevel == 1}">
															<th class="text-right">Actions</th>
														</c:if>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${boardList }" var="b">
														<input type="hidden" id="flag${b.boardNo}" value="close">
														<tr id="tr${b.boardNo}">
															<td class="text-center">${b.boardNo }</td>
															<td class="text-center"><a href="javscript:void(0)"
																class="qnaDetail" value="${b.boardNo }">
																	${b.boardTitle }</a></td>
															<td class="text-center">${b.memberId }</td>
															<td class="text-right">${b.boardRegDate }</td>
															<c:if test="${sessionLevel ne null && sessionLevel == 1}">
																<td class="text-right">
																	<button type="button" rel="tooltip" title="Reply"
																		class="btn btn-primary btn-simple btn-xs">
																		<i class="fa fa-reply"></i>
																	</button>
																	<button type="button" rel="tooltip" title="Remove"
																		class="btn btn-danger btn-simple btn-xs">
																		<i class="fa fa-times"></i>
																	</button>
																</td>
															</c:if>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<div align="center">
												<c:if test="${startPage>1}">
													<a
														href="<c:url value='qnaOne?currentPage=${startPage-pageSize}'/>">prev</a>
												</c:if>
												<c:forEach var="i" begin="${startPage}" end="${endPage}"
													step="1">
													<a href="<c:url value='qnaOne?currentPage=${i}'/>">${i}</a>
												</c:forEach>
												<c:if test="${endPage ne lastPage}">
													<a
														href="<c:url value='qnaOne?currentPage=${startPage+pageSize}'/>">next</a>
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