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
	<form action="<c:url value='personList'/>" method="get">
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
				<td>Birth</td>
				<td>Gender</td>
				<td>Act State</td>
				<td>친구신청</td>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${personList}" var="p">
			<tr>
				<td><a href="<c:url value='personDetail?memberId=${p.memberId}'/> ">${p.memberId}</a></td>
				<td>${p.memberNm}</td>
				<td>${p.memberPhone}</td>
				<td>${p.memberEmail}</td>
				<td>${p.personBirth}</td>
				<td>${p.personGender}</td>
				<td>${p.actStateNm}</td>
				<c:if test="${sessionId ne p.memberId and p.friendState eq 0}">
				<td><a href="<c:url value='friendAdd?memberId=${p.memberId}'/> ">신청하기</a></td>
				</c:if>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<c:if test="${startPage>1}">
			<a href="<c:url value='personList?currentPage=${startPage-pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">prev</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<a href="<c:url value='personList?currentPage=${i}&selectOption=${selectOption}&selectValue=${selectValue}'/>">${i}</a>
		</c:forEach>
		<c:if test="${endPage ne lastPage}">
			<a href="<c:url value='personList?currentPage=${startPage+pageSize}&selectOption=${selectOption}&selectValue=${selectValue}'/>">next</a>
		</c:if>
	</div>
</body>
</html>