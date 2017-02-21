<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="joinBegin" method="post">
개인 or 회원?
<input type="radio" class="checkLevel" name="memberLevel" value="3"><span>회원</span>
<input type="radio" class="checkLevel" name="memberLevel" value="2"><span>업체</span>
<button type="submit">선택</button>
</form>
</body>
</html>