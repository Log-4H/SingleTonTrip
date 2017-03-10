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
<h2>친구요청리스트</h2>
	<div>
		<table border='1'>
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>State</td>
					<td>수락&거절</td>		
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${friendAddList}" var="f">
				<tr>
					<td>${f.memberId}</td>
					<td>${f.memberNm}</td>
					<td>${f.approveStateNm}</td>
					<td><a href="<c:url value='friendApprove?memberId=${f.memberId}&&approveStateCd=2'/> ">수락</a>/<a href="<c:url value='friendApprove?memberId=${f.memberId}&&approveStateCd=3'/> ">거절</a></td>	
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:import url="/WEB-INF/views/module/footer.jsp"></c:import>
</body>
</html>