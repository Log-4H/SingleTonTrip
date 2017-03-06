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
	<table border='1'>
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>삭제</td>		
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${friendTotalList}" var="f">
			<tr>
				<td>${f.friendId}</td>
				<td>${f.memberNm}</td>
				<td><a href="<c:url value='friendApprove?memberId=${f.memberId}&&approveStateCd=3'/> ">삭제</a></td>	
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>