<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionId eq null }">
<a href="login">로그인</a><br>
</c:if>
<c:if test="${sessionId ne null }">
<a href="logout">로그아웃</a><br>
</c:if>


세션아이디 : ${sessionId} <br>
세션이름 : ${sessionNm }	<br>
세션레벨 :${sessionLevel }	<br>
</body>
</html>