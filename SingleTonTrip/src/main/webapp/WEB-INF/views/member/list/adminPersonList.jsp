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
									<h4>회원검색(관리자)</h4>
								</div>
									<div class="content">
										<form action="<c:url value='personList'/>" method="get">
											<div align="right">
												<select name="selectOption">
													<option value="m.member_id">ID</option>
													<option value="m.member_nm">이름</option>
												</select> 
												<input type="text" name="selectValue" /> 
												<input type="submit" value="검색" />
											</div>
										</form>
										<table class="table">
											<thead>
												<tr>
													<td>사진</td>
													<td>정보수정</td>
													<td>이름</td>
													<td>페이지</td>
													<td>친구신청</td>				
												</tr>
											</thead>
											
											<tbody>
												<c:forEach items="${personList}" var="p">
													<tr>
														<td><img src="<c:url value='/images/${p.memberImg}'/>" class="img-rounded" width="100" height="100"></td>
														<td><a href="<c:url value='personDetail?memberId=${p.memberId}'/> ">${p.memberId}</a></td>
														<td>${p.memberNm}</td>
														<td><a href="pageMain?pageId=${p.memberId}">${p.memberId}</a></td>
															<c:if test="${sessionId ne p.memberId and p.friendState eq 0}">
																<td><a href="<c:url value='friendAdd?memberId=${p.memberId}'/> ">신청하기</a></td>
															</c:if>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div align="center">
											<c:if test="${startPage>1}">
												<a href="<c:url value='adminPersonList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
											</c:if>
											<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
												<a href="<c:url value='adminPersonList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
											</c:forEach>
											<c:if test="${endPage ne lastPage}">
												<a href="<c:url value='adminPersonList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
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