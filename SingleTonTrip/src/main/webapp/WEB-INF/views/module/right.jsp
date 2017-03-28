<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				html += "<p align='center'>여기 어떠세요?</p>";
				// 광고신청할 때 URL 입력했으면 그 주소로 가고 입력 안했으면 광고 신청한 사람의 페이지로 이동
				if(item.adPageAddress == null || item.adPageAddress == ""){
					html+="<a href='pageMain?pageId="+item.companyId+"'>";
				} else {
					html+="<a href='"+item.adPageAddress+"'>";
				}
				html+="<img src='./images/"+item.adImg+"' style='width:250px;height:150px;margin-top:0px;'></a>";
			});
			$('#adList').html(html);
		}
	})
});
</script>
<!-- Right Column -->
<div id="adList" style="width:150%;margin-top:50;layout:fixed; position:fixed;">

</div>
