<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />

<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/base/BackImage.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 600px; margin-top: 80px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>친구요청리스트</h4>
								</div>
									<div class="content">
										<table class="table">
											<thead>
												<tr>
													<th>사진</th>
													<th>ID</th>
													<th>이름</th>
													<th>상태</th>
													<th class="text-right">수락&거절</th>		
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${friendAddList}" var="f">
												<tr>
													<c:choose>
														<c:when test="${f.memberImg ne null}">
															<td><img src="./images/${f.memberImg}"
																class="img-rounded" width="100" height="100"></td>
														</c:when>
														<c:otherwise>
																<td><img src="./assets/img/base/Male.png"
																	class="img-rounded" width="100" height="100"></td>
															</c:otherwise>
													</c:choose>
													<td><a href="pageMain?pageId=${f.memberId}">${f.memberId}</a></td>
													<td>${f.memberNm}</td>
													<td>${f.approveStateNm}</td>
													<td class="text-right">
														<a href="<c:url value='friendApprove?memberId=${f.memberId}&&approveStateCd=2'/> "><button type="button" class="btn btn-info btn-simple btn-xs">
										                    <i class="material-icons">person_add</i>
										                </button></a>
										                <a href="<c:url value='friendApprove?memberId=${f.memberId}&&approveStateCd=3'/> "><button type="button" class="btn btn-danger btn-simple btn-xs">
										                    <i class="fa fa-times"></i>
										                </button></a>
													</td>	
												</tr>
												</c:forEach>
											</tbody>
										</table>
															

										
										
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