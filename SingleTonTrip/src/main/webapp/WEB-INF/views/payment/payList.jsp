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
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/base/BackImage.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 1400px; margin-top: 80px">
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>결제 내역</h4>
								</div>
								<div class="content">
																		
									</br>
									<div>
										<c:if test="${sessionLevel eq 1}">
											<div style="margin:10px;" align="right">
												<form action="<c:url value='payList'/>" method="get">
													<input type="text" name="selectValue" style=" width: 230x; height: 27.6px; margin-top: 10px; padding-bottom: 4px;" /> 
													<input type="submit" class="btn btn-info btn-sm" value="검색"/>
												</form>
											</div>
										</c:if>
									</div>

									<table class="table">
										<thead>
											<tr>
												<th class="text-center">구분</th>
												<c:if test="${sessionLevel eq 1}">
													<th>회원 ID</th>
												</c:if>
												<th>결제 내용</th>
												<th>가격</th>
												<th>날짜</th>
												<th>상태</th>
												<!--  <th class="text-right">Actions</th> -->
											</tr>
										</thead>
										<tbody>
											<c:forEach var="payList" items="${adPayList}">
												<tr>
													<td class="text-center">${payList.paymentCate.paymentCateNm}</td>
													<c:if test="${sessionLevel eq 1}">
														<td>${payList.memberId}</td>
													</c:if>
													<td>${payList.ad.adContent}</td>
													<td>${payList.paymentPrice}</td>
													<td>${payList.paymentFinishDate}</td>
													<td>${payList.paymentStateNm}</td>
													<!--  <td class="td-actions text-right">
											                <button type="button" rel="tooltip" title="View Profile" class="btn btn-info btn-simple btn-xs">
											                    <i class="fa fa-user"></i>
											                </button>
											                <button type="button" rel="tooltip" title="Edit Profile" class="btn btn-success btn-simple btn-xs">
											                    <i class="fa fa-edit"></i>
											                </button>
											                <button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs">
											                    <i class="fa fa-times"></i>
											                </button>
											            </td> 
											        -->
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- 페이징 -->
									<div align="center">
										<ul class="pagination pagination-info">
											<c:if test="${startPage>1}">
												<li><a
													href="<c:url value='payList?currentPage=${startPage-pageSize}&selectValue=${selectValue}'/>">
														prev </a></li>
											</c:if>

											<c:forEach var="i" begin="${startPage}" end="${endPage}"
												step="1">
												<li><a
													href="<c:url value='payList?currentPage=${i}&selectValue=${selectValue}'/>">
														${i} </a></li>
											</c:forEach>
											<c:if test="${endPage ne lastPage}">
												<li><a
													href="<c:url value='payList?currentPage=${startPage+pageSize}&selectValue=${selectValue}'/>">
														next </a></li>
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