<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />

<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/examples/city.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 800px; margin-top: 80px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>숙박업체검색</h4>
								</div>
									<div class="content">
										<form action="<c:url value='companyList'/>" method="get">
											<div align="right">
												<select name="selectOption">
													<option value="m.member_id">ID</option>
													<option value="c.company_nm">업체명</option>
													<option value="c.company_address">주소</option>
													<option value="t.company_type_nm">업체분류</option>
												</select> 
												<input type="text" name="selectValue" /> 
												<input type="submit" value="검색" />
											</div>
										</form>
																<table class="table">
											<thead>
												<tr>
													<td>사진</td>
													<td>ID</td>
													<td>업체명</td>
													<td>전화번호</td>
													<td>업체분류</td>
													<td>주소</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${companyList}" var="c">
													<tr>
														<td><img src="<c:url value='/images/${f.memberImg}'/>" class="img-rounded" width="100" height="100"></td>
														<td><a href="pageMain?pageId=${c.memberId}">${c.memberId}</a></td>
														<td>${c.companyNm}</td>
														<td>${c.memberPhone}</td>
														<td>${c.companyTypeNm}</td>
														<td>${c.companyAddress}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div align="center">
											<c:if test="${startPage>1}">
												<a href="<c:url value='companyList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
											</c:if>
											<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
												<a href="<c:url value='companyList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
											</c:forEach>
											<c:if test="${endPage ne lastPage}">
												<a href="<c:url value='companyList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
											</c:if>
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