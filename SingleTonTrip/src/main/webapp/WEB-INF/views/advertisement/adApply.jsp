<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp" />
<script src="<c:url value='/js/adApply.js'/>"></script>
<style>
a.panelFocus a, a:hover, a:focus {
	color: black;
}
</style>
<body class="profile-page">
	<c:if test="${sessionLevel eq null || sessionLevel ne '1' && sessionLevel ne '2'}">
		<script type="text/javascript">
			alert('관리자 전용 페이지 입니다');
		</script>
		<c:redirect url="main" />
	</c:if>
	<c:import url="/WEB-INF/views/module/nav.jsp" />
	<div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/base/BackImage.jpg');"></div>
		<div class="main main-raised">
			<div class="profile-content">
				<div class="container-fluid">
					<div class="row" style="height: 100%; margin-top: 80px; margin-bottom: 50px">
						<div class="col-md-8 col-md-offset-2">
							<div class="card card-signup">
								<div class="header header-primary text-center" style="height: 80px;">
									<h4>광고 신청</h4>
								</div>
								<div class="content">
									<form action="adApply" method="post" enctype="multipart/form-data">
										<table class="table">
											<tr>
												<th></th>
												<th>설명</th>
												<th>가격(1일)</th>
												<th>수량(일수)</th>
												<th>합계</th>
											</tr>
											<c:forEach var="ad" items="${adPrice}">
												<tr>
													<td><input type="radio" name="adPriceCd" value="${ad.adPriceCd}"></td>
													<td>${ad.adPriceDetail}</td>
													<td>${ad.adPricePerday}</td>
													<td>${ad.adPriceAmount}</td>
													<td>${ad.adPriceTotal}</td>
												</tr>
											</c:forEach>
										</table>
									<br>
									<center>
										<p>※광고에 사용 할 이미지 파일을 등록 해 주세요.</p>
										<input type="file" name="imgFile">
										<p>※광고 클릭시 이동할 페이지 주소. 생략하면 신청자의 페이지로 이동합니다.(생략가능)</p>
										<input type="text" name="adPageAddress" size="40" placeholder="ex) http://...."><br> 
										<input type="submit" onclick="adApply_click();return false;" value="신청"><br> 
										<a href="payAdd">결제하러가기</a>
									</center>
									</form>
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