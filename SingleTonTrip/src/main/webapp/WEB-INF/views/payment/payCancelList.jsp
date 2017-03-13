<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../module/top.jsp"></c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>환불리스트</title>
</head>
<body>
<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 130px" align="center">
	<div class="w3-row-padding">
		<div class="w3-col m12">
			<div class="w3-card-2 w3-round w3-white">
				<div class="w3-container w3-padding">
					<table class="table">
						<tr>
							<th>회원아이디</th>
							<th>결제금</th>
							<th>상품가</th>
							<th>결제등록일</th>
							<th>결제일</th>
							<th>관리자아이디</th>
							<th>상태</th>
							<th>여부</th>
						</tr>
						<c:forEach var="p" items="${payback}">
							<tr>
								<td>${p.memberId}</td>
								<td>${p.paymentPrice}</td>
								<td>${p.paymentTotalPrice}</td>
								<td>${p.paymentApplyDate}</td>
								<td>${p.paymentFinishDate}</td>
								<td>${p.adminId}</td>
								<td>${p.paymentStateNm}</td>
								<td>
									<a href="payback?memberId=${p.memberId}&paymentTotalPrice=${p.paymentTotalPrice}&paymentTargetNo=${p.paymentTargetNo}">환불</a>/
									<a href="">취소</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>