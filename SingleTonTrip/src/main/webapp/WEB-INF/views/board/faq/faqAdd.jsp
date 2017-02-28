<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views//module/top.jsp"></c:import>
<body>
	<div class="w3-container w3-content"
		style="max-width: 1400px; margin-top: 80px">
		<div class="w3-col m7">
			<div class="w3-row-padding">
				<div class="w3-col m12">
					<div class="w3-card-2 w3-round w3-white">
						<div class="w3-container w3-padding">
							<h6 class="w3-opacity">faq 등록</h6>
							<form action="faqAdd" method="post">
								<!-- 여기서 셀렉박스 말고 탭으로 디자인 하면 갠츄날듯 -->
								<select name="boardCate.boardCateCd">
									<option value="#">::선택::</option>
									<c:forEach items="${faqCate}" var="f" begin="2" end="3">
										
										<option value="${f.boardCateCd}">${f.boardCateNm}</option>
										
									</c:forEach>
								</select>
								<hr class="w3-clear">
								<input type="text" class="form-control" name="boardTitle"
									placeholder="title">
								<hr class="w3-clear">
								<textarea class="form-control" rows="10" name="boardContent"
									style="resize: none;" placeholder="content"></textarea>
								<hr class="w3-clear">
								<input type="submit" class="w3-btn w3-theme" value="등록" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views//module/footer.jsp"></c:import>