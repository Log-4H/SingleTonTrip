<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<script>
// 광고 불러온다
$(document).ready(function() {
	console.log("-----");
	$.ajax({
		url : "serviceAdList",
		type : "GET",
		dataType : "json",
		success : function(data) {
			console.log("sss?");
			console.log(data);
			var homeAdList = data.homeAdList;
			var html="";
			$.each(homeAdList,function(key, item) {
				html += "<p align='center'>여기 어떠세요?</p>";
				// 광고신청할 때 URL 입력했으면 그 주소로 가고 입력 안했으면 광고 신청한 사람의 페이지로 이동
				if(item.adPageAddress == null || item.adPageAddress == ""){
					html+="<a href='pageMain?pageId="+item.companyId+"'>";
				} else {
					html+="<a href='"+item.adPageAddress+"'>";
				}
				html+="<img src='./images/"+item.adImg+"' style='width:250px;height:150px;margin-top:0px;'></a>";
			});
			$('#adList').html(html);
		}
	})
});
</script>
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/base/BackImage.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div id="adList" style="margin-left:75%;margin-top:50;layout:fixed; position:fixed;">
				</div>
				<div class="container-fluid">
					<div class="row" style="height: 800px; margin-top: 80px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>여행검색</h4>
								</div>
								<br>
									<div class="content">
										<form action="<c:url value='mainTripList'/>" method="get">
											<div align="right">
												<select name="selectOption">
													<option value="t.person_id">ID</option>
													<option value="tn.trip_theme_nm">테마</option>
													<option value="t.trip_title">제목</option>
													<option value="t.trip_tag">태그</option>
												</select> 
												<input type="text" name="selectValue" /> 
												<input type="submit" value="검색" />
											</div>
										</form>
										<table class="table">
											<thead>
												<tr>
													<td>#</td>
													<td>주제</td>
													<td>테마</td>
													<td>지역</td>
													<td>여행기간</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${tripList}" var="t">
													<tr>
														<td><a href="pageMain?pageId=${t.personId}">
															<c:choose>
																<c:when test="${t.memberImg ne null}">
																<img src="./images/${t.memberImg}" class="img-rounded" width="100" height="100">
																</c:when>
																<c:otherwise>
																<img src="./assets/img/base/Male.jpg" class="img-rounded" width="100" height="100">
																</c:otherwise>
															</c:choose>
														</a></td>
														<td><a href="tripDetail?tripNo=${t.tripNo}">${t.tripTitle}</a></td>
														<td>${t.tripThemeNm}</td>
														<td>
															<c:if test="${t.regionDo eq t.regionSi }">
																${t.regionDo}
															</c:if> 
															<c:if test="${t.regionDo ne t.regionSi }">
																${t.regionDo } ${t.regionSi }
															</c:if>
														</td>
														<td>${t.tripStartDate}~ ${t.tripEndDate }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div align="center">
											<c:if test="${startPage>1}">
												<a href="<c:url value='mainTripList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
											</c:if>
											<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
												<a href="<c:url value='mainTripList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
											</c:forEach>
											<c:if test="${endPage ne lastPage}">
												<a href="<c:url value='mainTripList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
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
	<c:import url="/WEB-INF/views/module/footer.jsp" />
</body>
</html>