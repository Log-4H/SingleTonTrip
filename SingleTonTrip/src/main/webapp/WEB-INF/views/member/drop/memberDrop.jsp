<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/views/module/top.jsp" />
<div align="center" class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
	<form action="memberDrop" method="post">
		<h1>탈퇴 하시겠습니까?</h1>
		<div>비밀번호 확인</div>
		<div><input type="password" name="memberPw"/></div>
		<div><input type="hidden" name="memberId" value="${memberId}"/></div>
		<input type="submit" value="탈퇴하기"/>
	</form>
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>