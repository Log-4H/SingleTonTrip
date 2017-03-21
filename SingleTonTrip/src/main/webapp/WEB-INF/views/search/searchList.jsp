<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/views/module/top.jsp" />
<script src="<c:url value='/js/searchList.js'/>"></script>
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
<div class="w3-row-padding">
<input type="hidden" id="searchValue" value="${value}">
<input type="hidden" id="personCurrentPage" value="1">
<input type="hidden" id="companyCurrentPage" value="1">
<input type="hidden" id="tripCurrentPage" value="1">
	<div class="w3-col m12">
		<h2 align="center">회원검색결과</h2><br>
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container w3-padding">
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
							<c:forEach items="${personMap.searchPersonList}" var="p" >
								<tr>
									<td><img src="./images/${p.memberImg}" class="img-rounded" width="100" height="100"></td>
									<td><a href="pageMain?pageId=${p.memberId }">${p.memberId}</a></td>
									<td>${p.memberNm}</td>
									<td>${p.personGender}</td>
									<td>${p.personBirth}</td>
								</tr>
							</c:forEach>
						</tbody>	
					</table>
					<div id="searchPersonPaging" align="center">
						<c:if test="${personMap.startPage>1}">
							<a href="javascript:void(0)" class="searchPersonPaging" value="${personMap.startPage - personMap.pageSize}">prev</a>
						</c:if>
						<c:forEach var="i" begin="${personMap.startPage}" end="${personMap.endPage}" step="1">
							<a href="javascript:void(0)" class="searchPersonPaging" value="${i}">${i }</a>
						</c:forEach>
						<c:if test="${personMap.endPage ne personMap.lastPage}">
							<a href="javascript:void(0)" class="searchPersonPaging" value="${personMap.startPage + personMap.pageSize}">next</a>
						</c:if>
					</div>
				</div>
			</div>
			<br><h2 align="center">숙소검색결과</h2><br>
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container w3-padding">
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
						<c:forEach items="${companyMap.searchCompanyList}" var="c" >
								<tr>
									<td><img src="./images/${c.memberImg}" class="img-rounded" width="100" height="100"></td>
									<td><a href="pageMain?pageId=${c.memberId }">${c.memberId}</a></td>
									<td>${c.companyNm}</td>
									<td>${c.companyAddress}</td>
									<td>${c.memberPhone}</td>
									<td>${c.companyTypeNm}</td>
								</tr>
							</c:forEach>
						</tbody>	
					</table>
					<div id="searchCompanyPaging" align="center">
						<c:if test="${companyMap.startPage>1}">
							<a href="javascript:void(0)" class="searchCompanyPaging" value="${companyMap.startPage- companyMap.pageSize}">prev</a>
						</c:if>
						<c:forEach var="i" begin="${companyMap.startPage}" end="${companyMap.endPage}" step="1">
							<a href="javascript:void(0)" class="searchCompanyPaging" value="${i}">${i }</a>
						</c:forEach>
						<c:if test="${companyMap.endPage ne companyMap.lastPage}">
							<a href="javascript:void(0)" class="searchCompanyPaging" value="${companyMap.startPage+ companyMap.pageSize}">next</a>
						</c:if>
					</div>
				</div>
			</div>
			<br><h2 align="center">여행검색결과</h2><br>
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container w3-padding">
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
							<c:forEach items="${tripMap.searchTripList}" var="t" >
								<tr>
									<td>${t.tripThemeNm}</td>
									<td><a href="pageMain?pageId=${t.personId }">${t.tripTitle}</a></td>
									<td>
										<c:if test="${t.regionDo eq t.regionSi }">
										${t.regionDo}
										</c:if>
										<c:if test="${t.regionDo ne t.regionSi }">
										${t.regionDo } ${t.regionSi }
										</c:if>
									</td>
									<td>${t.tripStartDate} ~ ${t.tripEndDate }</td>
								</tr>
							</c:forEach>
						</tbody>	
					</table>
					<div id="searchTripPaging" align="center">
						<c:if test="${tripMap.startPage>1}">
							<a href="javascript:void(0)" class="searchTripPaging" value="${tripMap.startPage- tripMap.pageSize}">prev</a>
						</c:if>
						<c:forEach var="i" begin="${tripMap.startPage}" end="${tripMap.endPage}" step="1">
							<a href="javascript:void(0)" class="searchTripPaging" value="${i}">${i }</a>
						</c:forEach>
						<c:if test="${tripMap.endPage ne tripMap.lastPage}">
							<a href="javascript:void(0)" class="searchTripPaging" value="${tripMap.startPage+ tripMap.pageSize}">next</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>