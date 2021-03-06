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
			var searchAdList = data.searchAdList;
			var html="";
			html += "<h4 align='center'>여기 어떠세요?</h4>";
			$.each(searchAdList,function(key, item) {
				// 광고신청할 때 URL 입력했으면 그 주소로 가고 입력 안했으면 광고 신청한 사람의 페이지로 이동
				if(item.adPageAddress == null || item.adPageAddress == ""){
					html+="<a href='pageMain?pageId="+item.companyId+"'>";
				} else {
					html+="<a href='"+item.adPageAddress+"'>";
				}
				html+="<img src='./images/"+item.adImg+"' style='width:100%;height:250px;margin-top:3px;'></a>";
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
				<div class="container-fluid">
					<div class="row" style="height: 100%; margin-top:80px; margin-bottom:50px;">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>숙박업체검색</h4>
								</div>
									<div id="adList" class="content">
										
									</div>
									<div class="content">
										<form action="<c:url value='companyList'/>" method="get">
											<div align="right" style="margin-top:5px;">
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
														<c:choose>
														<c:when test="${c.memberImg ne null}">
														<td><img src="./images/${c.memberImg}" class="img-rounded" width="100" height="100"></td>
														</c:when>
														<c:otherwise>
														<td><img src="./assets/img/base/Company.jpg" class="img-rounded" width="100" height="100"></td>
														</c:otherwise>
														</c:choose>
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