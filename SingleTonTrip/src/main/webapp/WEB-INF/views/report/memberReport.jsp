<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<c:import url="./faqAdd.jsp"></c:import>
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
											<i class="material-icons">forum</i> FAQ
										</h4>
									</div>
									<div class="content">
										<div align="right">
											<c:if test="${sessionLevel ne null && sessionLevel == 1}">
											<button type="button" class="btn btn-primary"
												onclick="faqAddModalShow()">
												<i class="fa fa-pencil"></i>  FAQ 등록
											</button>
										</c:if>
										</div>
										<div class="table-responsive">
												<form method="post" action="reportAdd">
													<div class="header header-primary text-center" style="height: 80px;">
														<h4>신고하기</h4>
													</div>
													<div class="content">
														</br>
														<div class="input-group">
															<span class="input-group-addon"></span>
															<select name="reportTypeCd">
																<option>::선택::</option>
																<c:forEach items="${reportTypeList}" var="r">
																	<option value="${r.reportTypeCd}">${r.reportTypeNm}</option>
																</c:forEach>
															</select>
														</div>
				
														<div class="input-group">
															<span class="input-group-addon"></span>
															<c:choose>
															<c:when test="${reportId ne null}">
															<input type="text" class="form-control" name="reportId" value="${reportId }" readonly>
															</c:when>
															<c:otherwise>
															<input type="text" class="form-control" name="reportId" placeholder="신고대상">
															</c:otherwise>
															</c:choose>
														</div>
				
														<div class="input-group">
															<span class="input-group-addon"></span>
															<input type="text" class="form-control" name="reportTitle" placeholder="title">
														</div>
														<div class="input-group">
															<span class="input-group-addon"></span>
															<textarea class="form-control" rows="10" name="reportContent" style="resize: none;" placeholder="content" ></textarea>
														</div>
													</div>
													<div class="footer text-center">
														<button type="submit" class="btn btn-simple btn-primary btn-lg">등록</button>
													</div>
												</form>
											<div align="center">
												<c:if test="${startPage>1}">
													<a
														href="<c:url value='faq?currentPage=${startPage-pageSize}'/>">prev</a>
												</c:if>
												<c:forEach var="i" begin="${startPage}" end="${endPage}"
													step="1">
													<a href="<c:url value='faq?currentPage=${i}'/>">${i}</a>
												</c:forEach>
												<c:if test="${endPage ne lastPage}">
													<a
														href="<c:url value='faq?currentPage=${startPage+pageSize}'/>">next</a>
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