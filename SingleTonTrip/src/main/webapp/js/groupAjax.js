var groupMemberLevel;

//그룹리스트 modal show
$(document).on('click', '.groupListModalShow', function() {
	var currentPage = 1;
	groupMemberLevel = $(this).attr("value");
	if(groupMemberLevel == "leader"){
		$("#groupListModalTitle").html("내가 생성한 그룹");
	}else if(groupMemberLevel == "member"){
		$("#groupListModalTitle").html("내가 가입한 그룹");
	}
	$("#currentPage").val(currentPage);
	groupList(currentPage, groupMemberLevel);
	$("#groupListModal").modal('show');
});
//그룹리스트 ajax
function groupList(currentPage, groupMemberLevel){
	$.ajax({
		url : "groupList",
		type : "POST",
		data : {
			currentPage : currentPage, groupMemberLevel : groupMemberLevel
		},
		dataType : "json",
		success : function(data) {
			$("#currentPage").val(currentPage);
			var html = "";
			var groupList = data.groupList;
			html = groupListAppend(groupList);
			$("#groupList").empty();
			$("#groupList").append(html);
			$("#groupPaging").html(groupPaging(data.startPage, data.pageSize, data.endPage, data.lastPage));
		}
	})
}
//페이징 버튼 클릭이벤트
$(document).on('click', '.pagingBtn', function() {
	var currentPage = $(this).attr('value');
	$('.modal-body').scrollTop(0);
	groupList(currentPage, groupMemberLevel);
});
//그룹리스트 html추가
function groupListAppend(groupList) {
	var html = "";
	$.each(groupList,function(key, item) {
		html += "<div class='w3-container w3-card-2 w3-white w3-round w3-margin'><br>";
		html += "<span class='w3-right w3-opacity'>"+ item.groupApplyDate + "</span><br>";
		html += "<span class='w3-right w3-opacity'>";
		if($("#pageId").val() == $("#sessionId").val()){
			if (item.approveStateCd == 1) {
				html += "<button type='button' class='btn btn-info'>취소</button></span>";
			} else if (item.approveStateCd == 2) {
				html += "<button type='button' class='btn btn-info'>탈퇴</button></span>";
			}else{
				html += "</span>";
			}
		}else{
			html += "</span>";
		}
		if (item.approveStateCd == 1) {
			html += "<span class='label label-warning'>";
		}else if (item.approveStateCd == 2) {
			html += "<span class='label label-success'>";
		}else if (item.approveStateCd == 3) {
			html += "<span class='label label-danger'>";
		}
		html += item.approveStateNm+"</span>";
		html += "<h4>";
		if($("#pageId").val() == $("#sessionId").val() && item.approveStateCd==2){
		html += "<a href='javascript:void(0)' class='groupView' value='"+item.tripNo+"'>";
		}
		html += item.tripTitle;
		if($("#pageId").val() == $("#sessionId").val() && item.approveStateCd==2){
		html += "</a>";
		}
		html += "</h4><br>";
		html += "</div>";
	})
	return html;
}
//페이징 html추가
function groupPaging(startPage, pageSize, endPage, lastPage){
	var html ="";
	html +="<ul class='pagination pagination-sm'>";
	if(startPage>1){
		html+= "<li><a href='javascript:void(0)' class='pagingBtn' value='"+Number(startPage-pageSize)+"'>&laquo;</a></li>";
	}
	for(var i=startPage; i<=endPage; i++){
		html+= "<li><a href='javascript:void(0)' class='pagingBtn' value='"+i+"'>"+i+"</a></li>";
	}
	if(endPage != lastPage){
		html+= "<li><a href='javascript:void(0)' class='pagingBtn' value='"+Number(startPage+pageSize)+"'>&raquo;</a></li>";
	}
	html +="</ul>";
	return html;
}
//그룹상세정보
$(document).on('click', '.groupView', function() {
	var tripNo = $(this).attr('value')
	$.ajax({
			url : "groupView",
			type : "POST",
			data : {
				tripNo : tripNo
			},
			dataType : "json",
			success : function(data) {
				var html = "";
				var trip = data.trip;
				var groupMemberList = data.groupMemberList;
				html = groupViewAppend(trip, groupMemberList);
				$("#groupList").empty();
				$("#groupPaging").html(
						"<a href='javascript:void(0)' class='pagingBtn'" 
						+"value='"+$("#currentPage").val()+"'>"
						+"뒤로가기</a>");
				$("#groupList").append(html);
			}
	});
});
//그룹상세보기 html추가
function groupViewAppend(trip, groupMemberList) {
	var html = "";
	html += "<div class='w3-container w3-card-2 w3-white w3-round w3-margin'><br>";
	html += "<span class='w3-right w3-opacity'>모집기간 : " ;
	html += trip.tripRecruitStartDate + " ~ "+ trip.tripRecruitEndDate + "</span><br>";
	if (trip.recruitStateCd == 1) {
		html += "<span class='label label-success'>";
	} else if (trip.recruitStateCd == 2) {
		html += "<span class='label label-warning'>";
	} else if (trip.recruitStateCd == 3) {
		html += "<span class='label label-danger'>";
	}
	html += trip.recruitStateNm;
	html += "</span>";
	html += "<h4>" + trip.tripTitle + "</h4><br>";
	html += "<hr class='w3-clear'>";
	if(trip.regionDo!=trip.regionSi){
		html += "<p>" + trip.regionDo + " " + trip.regionSi + "</p>";
	}else{
		html += "<p>" + trip.regionDo + "</p>";
	}
	html += "<p>" + trip.tripContent + "</p>";
	html += "<hr class='w3-clear'>";
	html += "<p>참여인원(현재인원/총인원) : " + trip.tripPresentMember + " / "
	+ trip.tripMaxMember + "</p>";
	html += "<p>여행기간 : " + trip.tripStartDate + " ~ " + trip.tripEndDate + "</p>";
	html += "<p>예상경비(1인경비/총경비) : " + trip.tripPerPrice + " / "+ trip.tripTotalPrice + "</p>";
	html += "<hr class='w3-clear'>";
	html += "<h4>그룹원</h4><br>";
	html += "<hr class='w3-clear'>";
	html +="<table class='table table-striped table-hover'>";
	html +="<thead>";
	html +="<tr>";
	html +="<th>#</th>";
	html +="<th>ID</th>";
	html +="<th>NAME</th>";
	html +="<th>LEVEL</th>";
	html +="<th>APPLYDATE</th>";
	html +="</tr>";
	html +="</thead>";
	html +="<tbody>";
	$.each(groupMemberList, function(key, item) {
		html +="<tr>";
		html +="<td>"+key+"</td>";
		html +="<td>"+item.personId+"</td>";
		html +="<td>"+item.memberNm+"</td>";
		html +="<td>"+item.groupMemberLevel+"</td>";
		html +="<td>"+item.groupApplyDate+"</td>";
		html +="</tr>";
	});
	html +="</tbody>";
	html +="</table>";
	return html;
}