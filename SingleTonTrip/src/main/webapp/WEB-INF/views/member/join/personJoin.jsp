<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/personJoin" method="post">
		<input type="hidden" name="memberLevel" value="${memberLevel }">
		<div>
			아이디:
			<input type="text"/>
		</div>
		<div>
			비밀번호:
			<input type="password"/>
		</div>
		<div>
			이름:
			<input type="text"/>
		</div>
		<div>
			전화번호:
			<input type="text"/>
		</div>
		<div>
			이메일:
			<input type="text"/>
		</div>
		<div>
			생일:
			<input type="text"/>
		</div>
		<div>
			성별:
			<input type="radio" name="gender" value="M"><span>남</span>
			<input type="radio" name="gender" value="F"><span>여</span>
		</div>
		<div><input type="submit" value="회원가입"></div>
	</form>
</body>
</html>