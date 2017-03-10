<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/views/module/top.jsp" />
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
<div align="center" >
	<h4>관리자 로그인</h4>
	<form action="login" method="post">
		아이디 : <input type="text" id="loginId" name="loginId" value="admin1">
		패스워드 : <input type="password" id="loginPw" name="loginPw" value="admin">
		<button type="submit">Login</button>
	</form>
	<br />
	<h4>업체 로그인</h4>
	<form action="login" method="post">
		아이디 : <input type="text" id="loginId" name="loginId" value="company1">
		패스워드 : <input type="password" id="loginPw" name="loginPw" value="company1">
		<button type="submit">Login</button>
	</form>
	<br />
	<h4>일반회원 로그인</h4>
	<form action="login" method="post">
		아이디 : <input type="text" id="loginId" name="loginId" value="person1">
		패스워드 : <input type="password" id="loginPw" name="loginPw" value="person1">
		<button type="submit">Login</button>
	</form>
	<br><br>
	<p>회원이 아니십니까? <a href="joinBegin">회원가입</a></p>
    <p>아이디가 기억나지않을땐 <a href="memberIdFind">아이디찾기</a></p>
    <p>비밀번호가 생각나지않을땐 <a href="memberPwFind">비밀번호찾기</a></p>
</div>
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>

