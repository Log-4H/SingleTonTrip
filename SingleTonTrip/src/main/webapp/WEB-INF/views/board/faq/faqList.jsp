<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<style>
div.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

div.list {
	padding: 10px;
}
a.panelFocus a, a:hover, a:focus {
    color: black;
}
</style>
<body class="profile-page">
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('./assets/img/examples/city.jpg');"></div>

		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 1400px; margin-top: 50px">
						<div class="col-md-6 col-md-offset-3">
							<c:forEach items="${faqList}" var="i">

								<div class="panel">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse${i.boardNo}" class="panelFocus">
												<div class="row">
													<div class="col-xs-12 col-sm-6 col-md-8" align="center">
														<h4>${i.boardTitle}</h4>
													</div>
													<div class="col-xs-6 col-md-4">
														<h6>${i.boardRegDate}</h6>
													</div>
												</div>
											</a>
										</h4>
									</div>
									<div id="collapse${i.boardNo}" class="panel-collapse collapse">
										<div class="panel-body">${i.boardContent }</div>
									</div>
								</div>
								<c:if test="${sessionLevel eq 1 }">
									<input type="button" class="w3-btn w3-theme" value="삭제" />
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views//module/footer.jsp" />
</body>
</html>