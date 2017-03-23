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
					<div class="row" style="height: 300px; margin-top: 80px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center"
									style="height: 80px;">
									<h4>회원검색결과</h4>
								</div>
								<div class="content">
									<table class="table">
										<thead>
											<tr>
												<td>사진</td>
												<td>ID</td>
												<td>이름</td>
												<td>성별</td>
												<td>생년월일</td>
											</tr>
										</thead>
										<tbody id="searchPersonList">
											<c:if test="${personMap.searchPersonList.size() >= 1 }">
												<c:forEach items="${personMap.searchPersonList}" var="p">
													<tr>
														<c:choose>
															<c:when test="${p.memberImg ne null}">
																<td><img src="./images/${p.memberImg}"
																	class="img-rounded" width="100" height="100"></td>
															</c:when>
															<c:when test="${p.personGender == 'M'}">
																<td><img src="./images/Male.png"
																	class="img-rounded" width="100" height="100"></td>
															</c:when>
															<c:when test="${p.personGender == 'F'}">
																<td><img src="./images/Female.png"
																	class="img-rounded" width="100" height="100"></td>
															</c:when>
														</c:choose>
														<td><a href="pageMain?pageId=${p.memberId }">${p.memberId}</a></td>
														<td>${p.memberNm}</td>
														<td>${p.personGender}</td>
														<td>${p.personBirth}</td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${personMap.searchPersonList.size() < 1 }">
												<tr>
													<td colspan="5" align="center"><strong>검색결과가없습니다</strong></td>
												</tr>
											</c:if>
										</tbody>
									</table>
									<div id="searchPersonPaging" align="center">
										<c:if test="${personMap.startPage>1}">
											<a href="javascript:void(0)" class="searchPersonPaging"
												value="${personMap.startPage - personMap.pageSize}">prev</a>
										</c:if>
										<c:forEach var="i" begin="${personMap.startPage}"
											end="${personMap.endPage}" step="1">
											<a href="javascript:void(0)" class="searchPersonPaging"
												value="${i}">${i }</a>
										</c:forEach>
										<c:if test="${personMap.endPage ne personMap.lastPage}">
											<a href="javascript:void(0)" class="searchPersonPaging"
												value="${personMap.startPage + personMap.pageSize}">next</a>
										</c:if>
									</div>


								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="container-fluid">
					<div class="row" style="height: 300px; margin-top: 40px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center"
									style="height: 80px;">
									<h4>숙소검색결과</h4>
								</div>
								<div class="content">
									<table class="table">
										<thead>
											<tr>
												<td>사진</td>
												<td>ID</td>
												<td>업체명</td>
												<td>주소</td>
												<td>전화번호</td>
												<td>유형</td>
											</tr>
										</thead>
										<tbody id="searchCompanyList">
											<c:if test="${companyMap.searchCompanyList.size() >= 1 }">
												<c:forEach items="${companyMap.searchCompanyList}" var="c">
													<tr>
														<c:choose>
															<c:when test="${c.memberImg ne null} ">
																<td><img src="./images/${c.memberImg}"
																	class="img-rounded" width="100" height="100"></td>
															</c:when>
															<c:otherwise>
																<td><img src="./images/Company.jpg"
																	class="img-rounded" width="100" height="100"></td>
															</c:otherwise>
														</c:choose>
														<td><a href="pageMain?pageId=${c.memberId }">${c.memberId}</a></td>
														<td>${c.companyNm}</td>
														<td>${c.companyAddress}</td>
														<td>${c.memberPhone}</td>
														<td>${c.companyTypeNm}</td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${companyMap.searchCompanyList.size() < 1 }">
												<tr>
													<td colspan="6" align="center"><strong>검색결과가없습니다</strong></td>
												</tr>
											</c:if>
										</tbody>
									</table>
									<div id="searchCompanyPaging" align="center">
										<c:if test="${companyMap.startPage>1}">
											<a href="javascript:void(0)" class="searchCompanyPaging"
												value="${companyMap.startPage- companyMap.pageSize}">prev</a>
										</c:if>
										<c:forEach var="i" begin="${companyMap.startPage}"
											end="${companyMap.endPage}" step="1">
											<a href="javascript:void(0)" class="searchCompanyPaging"
												value="${i}">${i }</a>
										</c:forEach>
										<c:if test="${companyMap.endPage ne companyMap.lastPage}">
											<a href="javascript:void(0)" class="searchCompanyPaging"
												value="${companyMap.startPage+ companyMap.pageSize}">next</a>
										</c:if>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="container-fluid">
					<div class="row" style="height: 300px; margin-top: 40px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center"
									style="height: 80px;">
									<h4>여행검색결과</h4>
								</div>
								<div class="content">
									<table class="table">
										<thead>
											<tr>
												<td>테마</td>
												<td>제목</td>
												<td>지역</td>
												<td>여행기간</td>
											</tr>
										</thead>
										<tbody id="searchTripList">
											<c:if test="${tripMap.searchTripList.size() >= 1 }">
												<c:forEach items="${tripMap.searchTripList}" var="t">
													<tr>
														<td>${t.tripThemeNm}</td>
														<td><a href="pageMain?pageId=${t.personId }">${t.tripTitle}</a></td>
														<td><c:if test="${t.regionDo eq t.regionSi }">
										${t.regionDo}
										</c:if> <c:if test="${t.regionDo ne t.regionSi }">
										${t.regionDo } ${t.regionSi }
										</c:if></td>
														<td>${t.tripStartDate}~ ${t.tripEndDate }</td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${tripMap.searchTripList.size() < 1 }">
												<tr>
													<td colspan="4" align="center"><strong>검색결과가없습니다</strong></td>
												</tr>
											</c:if>
										</tbody>
									</table>
									<div id="searchTripPaging" align="center">
										<c:if test="${tripMap.startPage>1}">
											<a href="javascript:void(0)" class="searchTripPaging"
												value="${tripMap.startPage- tripMap.pageSize}">prev</a>
										</c:if>
										<c:forEach var="i" begin="${tripMap.startPage}"
											end="${tripMap.endPage}" step="1">
											<a href="javascript:void(0)" class="searchTripPaging"
												value="${i}">${i }</a>
										</c:forEach>
										<c:if test="${tripMap.endPage ne tripMap.lastPage}">
											<a href="javascript:void(0)" class="searchTripPaging"
												value="${tripMap.startPage+ tripMap.pageSize}">next</a>
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