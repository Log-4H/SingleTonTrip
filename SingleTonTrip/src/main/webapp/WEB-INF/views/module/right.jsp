<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
// 광고 불러온다
$(document).ready(function() {
	console.log("-----");
	$.ajax({
		url : "serviceAdList",
		type : "GET",
		dataType : "json",
		success : function(data) {
			console.log("sss?");
			console.log(data);
			var homeAdList = data.homeAdList;
			var html="";
			$.each(homeAdList,function(key, item) {
				
				html += "<p>여기 어떠세요?</p>";
				// 광고신청할 때 URL 입력했으면 그 주소로 가고 입력 안했으면 광고 신청한 사람의 페이지로 이동
				if(item.adPageAddress == null || item.adPageAddress == ""){
					html+="<a href='pageMain?pageId="+item.companyId+"'>";
				} else {
					html+="<a href='"+item.adPageAddress+"'>";
				}
				html+="<img src='./images/"+item.adImg+"' alt='' style='width:100%; max-height:150px;'></a>";
			});
			$("#adList").html(html);
			
		}
	})
});
$(document).ready(function() {
	var sessionId = $('#sessionId').val();
	$.ajax({
		url : "pageFriendCheck",
		type : "GET",
		dataType : "json",
		success : function(data) {
			console.log(data);
			var pageFriendCheck = data.pageFriendCheck;
			if(pageFriendCheck==null && $('#pageId').val()!= $('#sessionId').val()){
				$('#friendApproveDiv').show();
			}
		}
	})
});
</script>
			<!-- Right Column -->
			<div class="w3-col m2">
				<div class="w3-card-2 w3-round w3-white w3-center" id="adList">

				</div>
				<br>

				<div class="w3-card-2 w3-round w3-white w3-center" id="friendApproveDiv" style="display:none;">
					<div class="w3-container">
						<p><strong>친구 신청</strong></p>
						<span></span>
						<div class="w3-row w3-opacity">
							<a href="friendAdd?memberId=${pageId }">
							<button class="w3-btn w3-green w3-btn-block w3-section"
								title="Accept">
								<i class="fa fa-check"></i>
							</button>
							</a>
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
