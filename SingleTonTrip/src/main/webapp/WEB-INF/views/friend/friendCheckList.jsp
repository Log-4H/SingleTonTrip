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
					<div class="row" style="height: 1400px; margin-top: 80px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>친구요청리스트</h4>
								</div>
									<div class="content">
										<table class="table">
											<thead>
												<tr>
													<th>ID</th>
													<th>Name</th>
													<th class="text-right">State</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${friendCheckList}" var="f">
												<tr>
													<td>${f.friendId}</td>
													<td>${f.memberNm}</td>
													<td class="text-right">${f.approveStateNm}</td>
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