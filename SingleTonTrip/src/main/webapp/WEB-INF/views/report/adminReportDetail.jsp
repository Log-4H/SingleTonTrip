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
								
									<div class="header header-primary text-center" style="height: 80px;">
										<h4>${reportVo.reportTitle }</h4>
									</div>
									<div class="content">
										</br>
										<div>
											<div class="row">
				                                <div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">신고유형</label>
														<input type="text" name="reportType" value="${reportVo.reportTypeNm}" class="form-control" readonly>
													</div>
				                                </div>
				                                <div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">신고자</label>
														<input type="text" name="memberId" value="${reportVo.memberId}" class="form-control" readonly>
													</div>
				                                </div>
				                                  <div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">신고대상</label>
														<input type="text" name="reportId" value="${reportVo.reportId}" class="form-control" readonly>
													</div>
				                                </div>
				                                <div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">신고날짜</label>
														<input type="text" name="reportDate" value="${reportVo.reportDate}" class="form-control" readonly>
													</div>
				                                </div>
				                            </div>
										</div>

										<div class="form-group label-floating">
											<label class="control-label">신고내용</label>
											<textarea class="form-control" rows="10" name="reportContent" style="resize: none;"readonly>${reportVo.reportContent} </textarea>
										</div>
										
										<div class="row">
				                                <div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">승인이유</label>
														<input type="text" name="reportApproveReason" class="form-control" >
													</div>
				                                </div>
				                                <div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">승인날짜</label>
														<input type="text" name="reportApproveDate" value="${reportVo.reportApproveDate}" class="form-control" readonly>
													</div>
				                                </div>
				                                  <div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">승인상태</label>
														<input type="text" name="reportApproveNm" value="${reportVo.approveStateNm}" class="form-control" readonly>
													</div>
				                                </div>
				                                <div class="col-md-6">
													<div class="form-group label-floating">
														<label class="control-label">승인자</label>
														<input type="text" name="adminId" value="${reportVo.adminId}" class="form-control" readonly>
													</div>
				                                </div>
				                                <div align="center">
				                                	<td><a href="<c:url value='reportModify?reportNo=${r.reportNo}'/>"><button>승인<i class="material-icons">check</i></button></a><a href="<c:url value='reportModify?reportNo=${r.reportNo}'/>"><button>거절<i class="material-icons">close</i></button></a></td>
				                                </div>
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