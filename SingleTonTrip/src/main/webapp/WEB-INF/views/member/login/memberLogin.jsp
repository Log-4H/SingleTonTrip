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
							<form class="form" method="post" action="login" id="login" onsubmit="return loginCheck()">
								<div class="header header-primary text-center">
									<h4>Login</h4>
									<div class="social-line">
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-facebook-square"></i>
										</a>
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-twitter"></i>
										</a>
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-google-plus"></i>
										</a>
									</div>
								</div>
								<div class="content">

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">done</i>
										</span>
										<input type="text" class="form-control" id="loginId" name="loginId" placeholder="아이디" value="person1">
									</div>

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" class="form-control" id="loginPw" name="loginPw" placeholder="비밀번호" value="person1"/>
									</div>
									<div class="checkbox">
										<label>
											<input type="checkbox" name="optionsCheckboxes" checked>
											아이디저장
										</label>
									</div>
    									
									<!-- If you want to add a checkbox to this form, uncomment this code

									<div class="checkbox">
										<label>
											<input type="checkbox" name="optionsCheckboxes" checked>
											Subscribe to newsletter
										</label>
									</div> -->
								</div>
								<div class="footer text-center">
									<button type="submit" class="btn btn-simple btn-primary btn-lg">로그인</button>
								</div>
							</form>
								<div class="footer text-center">
									<a href="memberIdFind"><button class="btn btn-primary btn-simple">아이디찾기</button></a>
									<a href="memberPwFind"><button class="btn btn-primary btn-simple">비밀번호찾기</button></a>
								</div>
						</div>
					</div>
				</div>
			</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
<script type="text/javascript">
function loginCheck() {
  if(login.loginId.value == "") {
    alert("아이디를 입력해 주세요.");
    login.loginId.focus();
    return false;
  }
  else if(login.loginPw.value == "") {
    alert("비밀번호를 입력해 주세요.");
    login.loginPw.focus();
    return false;
  }
  else return true;
}
</script>
</body>
</html>