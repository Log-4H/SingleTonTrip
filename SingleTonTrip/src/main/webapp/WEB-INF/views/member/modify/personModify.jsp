<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/views/module/top.jsp"></c:import>
<body class="signup-page">
<c:import url="/WEB-INF/views/module/nav.jsp"></c:import>
      <div class="wrapper">
		<div class="header header-filter" style="background-image: url('./assets/img/BackImage.jpg'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							<form class="form" action="personModify" method="post" enctype="multipart/form-data" id="form1">		
								<div class="header header-primary text-center">
									<h4>회원정보수정(개인)</h4>
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
								<div class="content" align="center">
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">photo</i>
										</span>
										<img id="blah" src="#" alt="your image" style="max-height: 100px; max-width: 100px"/><br>
										<input type='file' name="imgFile" id="imgInp" />
									</div>

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">perm_identity</i>
										</span>
										<input type="text" class="form-control" id="memberId" name="memberId" value="${personVo.memberId}" readonly="readonly"/>
									</div>
							
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" class="form-control" id="memberPw" name="memberPw" placeholder="현재비밀번호"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" class="form-control" id="newPw" name="newPw" placeholder="새 비밀번호"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" class="form-control" id="newPwCheck" name="newPwCheck" placeholder="새 비밀번호확인"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">face</i>
										</span>
										<input type="text" class="form-control" name="memberNm" value="${personVo.memberNm}"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">call</i>
										</span>
										<input type="text" class="form-control" name="memberPhone" value="${personVo.memberPhone}"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">mail_outline</i>
										</span>
										<input type="text" class="form-control" name="memberEmail" value="${personVo.memberEmail}"/>
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">cake</i>
										</span>
										<input type="date" class="form-control" name="personBirth" value="${personVo.personBirth}"/>
									</div>
									
									<div class="input-group">
										<input type="radio" name="personGender" value="M"><span>남</span>
										<input type="radio" name="personGender" value="F"><span>여</span>
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
									<button type="submit" class="btn btn-simple btn-primary btn-lg">정보수정</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
<script>
$(document).ready(function(){
	$("#form1").submit(function(){
		var newPw = $("#newPw").val();
		var newPwCheck =$("#newPwCheck").val();
		if(newPw!=newPwCheck){
			alert("비밀번호 틀렸어요");
			return false;
		}
	});
});
</script>
<!-- 이미지사진미리보기 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#imgInp").on('change', function(){
            readURL(this);
        });
    });

    function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
	    	    reader.onload = function (e) {
					$('#blah').attr('src', e.target.result);
		    	}
	        reader.readAsDataURL(input.files[0]);
		}
    }
</script>
</body>
</html>