<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
<h1 align="center">SigletonTrip</h1>
<h2 align="center">업체약관</h2>
	<div align="center">
		<c:import url='terms.jsp'></c:import><br>
	</div>
	<div align="center">약관 동의 하시겠습니까?
		<a href="companyJoin?memberLevel=${memberLevel}">Yes</a>
	</div>
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>