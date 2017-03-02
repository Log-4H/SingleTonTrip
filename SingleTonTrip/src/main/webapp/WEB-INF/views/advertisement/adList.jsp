<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>광고 리스트</title>
</head>
<body>
<c:if test="${sessionLevel eq null || sessionLevel ne '1'}">
<script type="text/javascript">
	alert('관리자 전용 페이지 입니다');
</script>
<% response.sendRedirect("index"); %>
</c:if>
<h3><a href="index">홈</a></h3>
<table border=1>
	<tr>
		<th>신청자</th>
		<th>광고내용</th>
		<th>이미지파일</th>
		<th>유지기간</th>
		<th>승인자</th>
		<th></th>
	</tr>
	<c:forEach var="a" items="${adList}">
		<tr>
			<td>${a.companyId}</td>
			<td>${a.adContent}</td>
			<td><a href="<%=request.getContextPath() %>/images/${a.adImg}" target="_blank">${a.adImg}</a></td>
			<td>${a.adRegDate}~${a.adEndDate}</td>
			<td>${a.adminId}</td>
			<td>
				<form action="imgUpload" method="post" enctype="multipart/form-data">
					<input type="file" name="imgFile">
					<input type="hidden" name="adNo" value="${a.adNo}">
					<input type="submit" value="등록">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>