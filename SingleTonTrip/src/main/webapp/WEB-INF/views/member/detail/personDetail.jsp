<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<body class="signup-page">
<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
      <div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/base/BackImage.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							
								<div class="header header-primary text-center">
									<h4>회원정보</h4>
								</div>
								<div class="content" align="center">
								
											<div>아이디</div>
											<div><input type="text" name="memberId" value="${personVo.memberId}" readonly="readonly"/></div>
											<div>이름</div>
											<div><input type="text" name="memberNm" value="${personVo.memberNm}" readonly="readonly"/></div>
											<div>전화번호</div>
											<div><input type="text" name="memberPhone" value="${personVo.memberPhone}" readonly="readonly"/></div>
											<div>이메일</div>
											<div><input type="text" name="memberEmail" value="${personVo.memberEmail}" readonly="readonly"/></div>
											<div>경고횟수</div>
											<div><input type="text" name="memberReportCount" value="${personVo.memberReportCount}" readonly="readonly"/></div>
											<div>가입일</div>
											<div><input type="text" name="memberRegDate" value="${personVo.memberRegDate}" readonly="readonly"/></div>
											<div>상태</div>
											<div><input type="text" name="actStateNm" value="${personVo.actStateNm}" readonly="readonly"/></div>
											<div>생년월일</div>
											<div><input type="text" name="personBirth" value="${personVo.personBirth}" readonly="readonly"/></div>
											<div>성별</div>
											<div><input type="text" name="personGender" value="${personVo.personGender}" readonly="readonly"/></div>
											<div>마일리지</div>
											<div><input type="text" name="personTotalMileage" value="${personVo.personTotalMileage}" readonly="readonly"/></div>
											<div>여행상태</div>
											<div><input type="text" name="tripStateNm" value="${personVo.tripStateNm}" readonly="readonly"/></div>
										
									
									<!-- If you want to add a checkbox to this form, uncomment this code

									<div class="checkbox">
										<label>
											<input type="checkbox" name="optionsCheckboxes" checked>
											Subscribe to newsletter
										</label>
									</div> -->
								</div>
								<div class="footer text-center">
									<a href="<c:url value='memberDrop?memberId=${personVo.memberId}'/> "><button class="btn btn-simple btn-primary btn-lg">탈퇴하기</button></a>
									<a href="<c:url value='personModify?memberId=${personVo.memberId}'/> "><button class="btn btn-simple btn-primary btn-lg">수정하기</button></a>
								</div>
							
						</div>
					</div>
				</div>
			</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>