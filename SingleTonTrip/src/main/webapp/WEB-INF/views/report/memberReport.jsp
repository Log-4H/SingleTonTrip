<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/examples/city.jpg');"></div>
		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 800px; margin-top: 80px">
						<div class="col-md-6 col-md-offset-3">
							<div class="card card-signup">
								<form method="post" action="reportAdd">
									<div class="header header-primary text-center" style="height: 80px;">
										<h4>신고하기</h4>
									</div>
									<div class="content">
										</br>
										<div class="input-group">
											<span class="input-group-addon"></span>
											<select name="reportTypeList.reportTypeCd">
												<option value="#">::선택::</option>
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