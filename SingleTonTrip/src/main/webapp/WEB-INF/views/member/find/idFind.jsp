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
<c:import url="/WEB-INF/views/module/top.jsp" />
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
<h3>아이디 찾기</h3>
	<div>
		<form action="memberIdFind" method="post">
			<div>이름<input type="text" name="memberNm"/></div>
			<div>E-MAIL<input type="text" name="memberEmail"/></div>
			<div><input type="submit"/></div>
		</form>
	</div>
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>