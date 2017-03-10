<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
<h1 align="center">SigletonTrip</h1>
<h2 align="center">회원가입</h2>
<div style="width:100%;text-align:center!important;">
	<div style="width:30%;margin-left:auto;margin-right:auto;">
		<form action="personJoin" method="post" enctype="multipart/form-data" id="form1">
			<input type="hidden" name="memberLevel" value="${memberLevel}">
			<div align="center">
				프로필사진
				<img id="blah" src="#" alt="your image" style="max-height: 100px; max-width: 100px"/><br>
				<input type='file' name="imgFile" id="imgInp" />	       
			</div>
			<div>
				<input type="text" class="form-control" name="memberId" placeholder="아이디"/>
			</div>
			<div>
				<input type="password" class="form-control" name="memberPw" placeholder="비밀번호"/>
			</div>
			<div>
				<input type="text" class="form-control" name="memberNm" placeholder="이름"/>
			</div>
			<div>
				<input type="text" class="form-control" name="memberPhone" placeholder="전화번호"/>
			</div>
			<div>
				<input type="text" class="form-control" name="memberEmail" placeholder="이메일"/>
			</div>
			<div>
				<input type="date" class="form-control" name="personBirth"/>
			</div>
			<div>
				<input type="radio" name="personGender" value="M"><span>남</span>
				<input type="radio" name="personGender" value="F"><span>여</span>
			</div>
			<br>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
</div>	

</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>
