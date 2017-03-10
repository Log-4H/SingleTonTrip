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
<c:import url="/WEB-INF/views/module/top.jsp" />
<div class="w3-container w3-content" style="max-width: 1400px; margin-top: 130px">
	<form action="<c:url value='companyList'/>" method="get">
		<div>
			<select name="selectOption">
				<option value="m.member_id">ID</option>
				<option value="c.company_nm">업체명</option>
				<option value="c.company_address">주소</option>
				<option value="t.company_type_nm">업체분류</option>
			</select> 
			<input type="text" name="selectValue" /> 
			<input type="submit" value="검색" />
		</div>
	</form>
	
	<table border='1'>
		<thead>
			<tr>
				<td>사진</td>
				<td>ID</td>
				<td>companyName</td>
				<td>Phone</td>
				<td>Type</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${companyList}" var="c">
			<tr>
				<td>${c.companyImg}</td>
				<td><a href="<c:url value='companyDetail?memberId=${c.memberId}'/> ">${c.memberId}</a></td>
				<td>${c.companyNm}</td>
				<td>${c.memberPhone}</td>
				<td>${c.companyTypeNm}</td>		
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
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>