<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp"></c:import>
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
<h3><a href="<%= request.getContextPath() %>/index">홈</a></h3>
<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 130px" align="center">
	<div class="w3-row-padding">
		<div class="w3-col m12">
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container w3-padding">
<c:choose>
	<c:when test="${sessionLevel == 1}">
		<table class="table">
		 	<tr>
		 		<th>번호</th>
		 		<th>신청자</th>
		 		<th>내용</th>
		 		<th>이미지파일</th>
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
		 		<td><a href="<%=request.getContextPath() %>/images/${a.adImg}" target="_blank">${a.adImg}</a></td>
		 		<td>${a.adApplyDate}</td>
		 		<td>${a.paymentFinishDate}</td>
		 		<td>${a.approveStateNm}</td>
		 		<td><a href="adApprove?adNo=${a.adNo}&companyId=${a.companyId}&adGroupCd=${a.adGroupCd}">승인</a>/
		 			<a href="adRefuse?adNo=${a.adNo}">거절</a></td>
		 	</tr>
		</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<table class="table">
		 	<tr>
		 		<th>번호</th>
		 		<th>신청자</th>
		 		<th>내용</th>
		 		<th>이미지파일</th>
		 		<th>신청일</th>
		 		<th>결제일</th>
		 		<th>상태</th>
		 	</tr>
		<c:forEach var="a" items="${adApplyList}">
		 	<tr>
		 		<td>${a.adNo}</td>
		 		<td>${a.companyId}</td>
		 		<td>${a.adContent}</td>
		 		<td><a href="<%=request.getContextPath() %>/images/${a.adImg}" target="_blank">${a.adImg}</a></td>
		 		<td>${a.adApplyDate}</td>
		 		<td>${a.paymentFinishDate}</td>
		 		<td>${a.approveStateNm}</td>
		 	</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>