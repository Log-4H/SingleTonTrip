<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<!-- Right Column -->
			<div class="w3-col m2">
				<div class="w3-card-2 w3-round w3-white w3-center">
					<div class="w3-container">
						<p>여기 어떠세요?</p>
						<c:forEach var="img" items="${homeAdList}">
							<a href="${img.adPageAddress}" target="_blank">
								<img src="./images/${img.adImg}" alt="" width="260px" height="235px">
							</a>
						</c:forEach>
					</div>
				</div>
				<br>


				
			</div>
			<!-- End Right Column -->
			
			
			
		</div>
		<!-- End Grid -->	
		
	</div>
	<!-- End Page Container -->
<br>
