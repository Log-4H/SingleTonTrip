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
	<form action="companyJoin" method="post">
	<input type="hidden" name="memberLevel" value="${memberLevel }">
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
			사업자번호:
			<input type="text" name="companyCrd"/>
		</div>
		<div>
			분류:
			<input type="radio" name="companyTypeCd" value="1"/><span>호텔</span>
			<input type="radio" name="companyTypeCd" value="2"/><span>모텔</span>
			<input type="radio" name="companyTypeCd" value="3"/><span>펜션</span>
			<input type="radio" name="companyTypeCd" value="4"/><span>게스트하우스</span>
		</div>
		<div>
			주소:
			<input type="text" name="companyAddress"/>
		</div>
		<div><input type="submit" value="회원가입"></div>
	</form>
</body>
</html>