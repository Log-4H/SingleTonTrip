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
<h1 align="center">회원검색</h1><br>
	<div class="w3-row-padding">
		<div class="w3-col m12">
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container w3-padding">
					<form action="<c:url value='personList'/>" method="get">
						<div align="right">
							<select name="selectOption">
								<option value="m.member_id">ID</option>
								<option value="m.member_nm">Name</option>
							</select> 
							<input type="text" name="selectValue" /> 
							<input type="submit" value="검색" />
						</div>
					</form>
					<table class="table">
						<thead>
							<tr>
								<td>사진</td>
								<td>ID</td>
								<td>Name</td>
								<td>친구신청</td>				
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${personList}" var="p">
								<tr>
									<td><img src="<c:url value='/images/${p.memberImg}'/>" class="img-rounded" width="100" height="100"></td>
									<td><a href="pageMain?pageId=${p.memberId}">${p.memberId}</a></td>
									<td>${p.memberNm}</td>
										<c:if test="${sessionId ne p.memberId and p.friendState eq 0}">
											<td><a href="<c:url value='friendAdd?memberId=${p.memberId}'/> ">신청하기</a></td>
										</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div align="center">
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
				</div>
			</div>
		</div>
	</div>
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>