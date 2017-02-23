<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>광고 신청 리스트</title>
</head>
<body>
<h1>신청 리스트</h1>
<table border="1">
 	<tr>
 		<th>번호</th>
 		<th>신청자</th>
 		<th>내용</th>
 		<th>신청일</th>
 		<th>상태</th>
 		<th>여부</th>
 	</tr>
 <c:forEach var="a" items="${adApplyList}">
 	<tr>
 		<td>${a.adNo}</td>
 		<td>${a.companyId}</td>
 		<td>${a.adContent}</td>
 		<td>${a.adApplyDate}</td>
 		<td>${a.approveStateCd}</td>
 		<td><a href="#">승인</a>/<a href="#">거절</a></td>
 	</tr>
</c:forEach>
</table>
</body>
</html>