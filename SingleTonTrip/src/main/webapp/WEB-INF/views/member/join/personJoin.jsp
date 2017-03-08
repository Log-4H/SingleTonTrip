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
	<form action="personJoin" method="post" enctype="multipart/form-data" id="form1">
		<input type="hidden" name="memberLevel" value="${memberLevel}">
		<div>
			<img id="blah" src="#" alt="your image" style="max-height: 100px; max-width: 100px"/><br>
			프로필사진:
	    	<input type='file' name="imgFile" id="imgInp" />	       
		</div>
		<div>
			아이디:
			<input type="text" name="memberId"/>
		</div>
		<div>
			비밀번호:
			<input type="password" name="memberPw"/>
		</div>
		<div>
			이름:
			<input type="text" name="memberNm"/>
		</div>
		<div>
			전화번호:
			<input type="text" name="memberPhone"/>
		</div>
		<div>
			이메일:
			<input type="text" name="memberEmail"/>
		</div>
		<div>
			생일:
			<input type="date" name="personBirth" />
		</div>
		<div>
			성별:
			<input type="radio" name="personGender" value="M"><span>남</span>
			<input type="radio" name="personGender" value="F"><span>여</span>
		</div>
		<div><input type="submit" value="회원가입"></div>
	</form>
</body>
</html>