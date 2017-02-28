<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="<c:url value='/js/commons/jquery.min.js'/>"></script>
<script>
$(document).ready(function(){
$("#form").submit(function(){
	var newPw = $("#newPw").val();
	var newPwCheck =$("#newPwCheck").val();
	if(newPw!=newPwCheck){
		alert("비밀번호 틀렸어요");
		return false;
	}
});
});

</script>
<body>
	<form id="form" action="personModify" method="post">
		<div>ID</div>
		<div><input type="text" name="memberId" value="${personVo.memberId}" readonly="readonly"/></div>
		<div>Current PW</div>
		<div><input type="password" name="memberPw"/></div>
		<div>NEW PW</div>
		<div><input type="password" id="newPw" name="newPw"/></div>
		<div>NEW PW CHECK</div>
		<div><input type="password" id="newPwCheck" name="newPwCheck"/></div>
		<div>NAME</div>
		<div><input type="text" name="memberNm" value="${personVo.memberNm}"/></div>
		<div>PHONE</div>
		<div><input type="text" name="memberPhone" value="${personVo.memberPhone}"/></div>
		<div>EMAIL</div>
		<div><input type="text" name="memberEmail" value="${personVo.memberEmail}"/></div>
		<div>BIRTH</div>
		<div><input type="text" name="personBirth" value="${personVo.personBirth}"/></div>
		<div>GENDER</div>
		<div><input type="text" name="personGender" value="${personVo.personGender}"/></div>
		<div><input type="submit" value="개인정보수정"/></div>
	</form>
</body>
</html>