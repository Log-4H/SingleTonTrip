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
<c:if test="${sessionLevel eq null || sessionLevel ne '1' && sessionLevel ne '2'}">
<script type="text/javascript">
	alert('관리자 전용 페이지 입니다');
</script>
<% response.sendRedirect("index"); %>
</c:if>
<h1>신청 리스트</h1>
<h3><a href="index">홈</a></h3>
<c:choose>
	<c:when test="${sessionLevel == 1 || sessionLevel eq null}">
		<table border="1">
		 	<tr>
		 		<th>번호</th>
		 		<th>신청자</th>
		 		<th>내용</th>
		 		<th>신청일</th>
		 		<th>결제일</th>
		 		<th>상태</th>
		 		<th>여부</th>
		 	</tr>
		<c:forEach var="a" items="${adApplyList}">
		 	<tr>
		 		<td>${a.adNo}</td>
		 		<td>${a.companyId}</td>
		 		<td>${a.adContent}</td>
		 		<td>${a.adApplyDate}</td>
		 		<td>${a.paymentFinishDate}</td>
		 		<td>${a.approveStateCd}</td>
		 		<td><a href="adApprove?adNo=${a.adNo}">승인</a>/<a href="adRefuse?adNo=${a.adNo}">거절</a></td>
		 	</tr>
		</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<table border="1">
		 	<tr>
		 		<th>번호</th>
		 		<th>신청자</th>
		 		<th>내용</th>
		 		<th>신청일</th>
		 		<th>결제일</th>
		 		<th>상태</th>
		 	</tr>
		<c:forEach var="a" items="${adApplyList}">
		 	<tr>
		 		<td>${a.adNo}</td>
		 		<td>${a.companyId}</td>
		 		<td>${a.adContent}</td>
		 		<td>${a.adApplyDate}</td>
		 		<td>${a.paymentFinishDate}</td>
		 		<td>${a.approveStateCd}</td>
		 	</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>