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
	<form action="<c:url value='companyList'/>" method="get">
		<div>
			<select name="selectOption">
				<option value="m.member_id">ID</option>
				<option value="m.member_nm">Name</option>
				<option value="m.member_phone">Phone</option>
				<option value="m.member_email">Email</option>
			</select> 
			<input type="text" name="selectValue" /> 
			<input type="submit" value="검색" />
		</div>
	</form>
	<table border='1'>
		<thead>
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Phone</td>
				<td>Email</td>
				<td>CRD</td>
				<td>Type</td>
				<td>Act State</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${companyList}" var="c">
			<tr>
				<td>${c.memberId}</td>
				<td>${c.memberNm}</td>
				<td>${c.memberPhone}</td>
				<td>${c.memberEmail}</td>
				<td>${c.companyCrd}</td>
				<td>${c.companyTypeNm}</td>
				<td>${c.actStateNm}</td>		
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<c:if test="${startPage>1}">
			<a href="<c:url value='companyList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<a href="<c:url value='companyList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
		</c:forEach>
		<c:if test="${endPage ne lastPage}">
			<a href="<c:url value='companyList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
		</c:if>
	</div>
</body>
</html>