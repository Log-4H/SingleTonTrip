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
<h2>친구리스트</h2>
<div>
	<form action="friendList" method="post">
		<table border='1'>
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>State</td>				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="" var="f">
				<tr>
					<td></td>
					<td></td>
					<td></td>	
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>