<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<body class="signup-page">
<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
      <div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/city.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							<form class="form" method="post" action="memberDrop" id="memberDrop" onsubmit="return memberDropCheck()">
								<div class="header header-primary text-center">
									<h4>탈퇴하시겠습니까?</h4>
								</div>
								<div class="content">

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">https</i>
										</span>
										<input type="password" name="memberPw" id="memberPw" placeholder="memberPw" class="form-control" />
									</div>
    								<div><input type="hidden" name="memberId" value="${memberId}"/></div>
									<!-- If you want to add a checkbox to this form, uncomment this code

									<div class="checkbox">
										<label>
											<input type="checkbox" name="optionsCheckboxes" checked>
											Subscribe to newsletter
										</label>
									</div> -->
								</div>
								<div class="footer text-center">
									<button type="submit" class="btn btn-simple btn-primary btn-lg">탈퇴하기</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
<script type="text/javascript">
function memberDropCheck() {
  if(memberDrop.memberPw.value == "") {
    alert("비밀번호를 입력해 주세요.");
    memberDrop.memberPw.focus();
    return false;
  }
  else return true;
}
</script>
</body>
</html>