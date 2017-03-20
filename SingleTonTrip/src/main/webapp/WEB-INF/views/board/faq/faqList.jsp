<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views//module/top.jsp" />
<body>
	<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 80px">
		<div class="w3-col m7">
			<div class="w3-row-padding">
				<div class="w3-col m12">
					<div class="w3-card-2 w3-round w3-white">
						<div class="w3-container w3-padding">
							<h3 class="w3-opacity">FAQ</h3>
							<hr class="w3-clear">
							<c:forEach items="${faqList}" var="i">

								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse${i.boardNo}">
												<div class="row">
													<div class="col-xs-12 col-sm-6 col-md-8" align="center">
														<h4 class="w3-opacity">${i.boardTitle}</h4>
													</div>
													<div class="col-xs-6 col-md-4">
														<h6 class="w3-opacity">${i.boardRegDate}</h6>
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