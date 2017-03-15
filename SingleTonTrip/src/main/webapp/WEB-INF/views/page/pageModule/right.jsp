<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
//프로필 요청 
$(document).ready(function() {
	$.ajax({
		url : "serviceAdList",
		type : "POST",
		dataType : "json",
		success : function(data) {
			var homeAdList = data.homeAdList;
			var html="";
			$.each(homeAdList,function(key, item) {
				html += "<p>여기 어떠세요?</p>"
					+	"<a href='"+item.adPageAddress+"' target='_blank'>"
					+	"<img src='./images/"+item.adImg+"' alt='' style='width:50%'>"
					+	"</a>";
			});
			$("#adtest").html(html);
			
		}
	})
});
</script>
			<!-- Right Column -->
			<div class="w3-col m2">
				<div class="w3-card-2 w3-round w3-white w3-center">
					<div class="w3-container" id="adtest">
					
					</div>
				</div>
				<br>

				<div class="w3-card-2 w3-round w3-white w3-center">
					<div class="w3-container">
						<p>Friend Request</p>
						<img src="http://www.w3schools.com/w3images/avatar6.png"
							alt="Avatar" style="width: 50%"><br> <span>Jane
							Doe</span>
						<div class="w3-row w3-opacity">
							<div class="w3-half">
								<button class="w3-btn w3-green w3-btn-block w3-section"
									title="Accept">
									<i class="fa fa-check"></i>
								</button>
							</div>
							<div class="w3-half">
								<button class="w3-btn w3-red w3-btn-block w3-section"
									title="Decline">
									<i class="fa fa-remove"></i>
								</button>
							</div>
						</div>
					</div>
				</div>

				
			</div>
			<!-- End Right Column -->
			
			
			
		</div>
		<!-- End Grid -->	
		
	</div>
	<!-- End Page Container -->
<br>
