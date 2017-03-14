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
		if(item.groupMemberLevel=="member"){
			if (item.approveStateCd == 1) {
				html += "<button type='button' class='btn btn-info applyCancelBtn' value='"+item.tripNo+"'>취소</button>";
			}else if (item.approveStateCd == 2) {
				html += "<button type='button' class='btn btn-info groupDropBtn' value='"+item.tripNo+"'>탈퇴</button>";
			}
		}else if(item.groupMemberLevel=="leader"){
			if (item.tripPresentMember < item.tripMaxMember) {
				html += "<button type='button' class='btn btn-info tripEndModalBtn' value='"+item.tripNo+"' data-dismiss='modal'>마감</button>";
			}	
		}
		html +="</span>";			
		if (item.approveStateCd == 1) {
			html += "<span class='label label-warning'>";
		}else if (item.approveStateCd == 2) {
			html += "<span class='label label-success'>";
		}else if (item.approveStateCd == 3) {
			html += "<span class='label label-danger'>";
		}
		html += item.approveStateNm+"</span>";
		html += "<h4>";
		html += "<a href='javascript:void(0)' class='groupView' value='"+item.tripNo+"'>";
		html += item.tripTitle;
		html += "</a>";
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
	var tripNo = $(this).attr('value');
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
				html = groupViewAppend(trip);
				$("#groupList").empty();
				$("#groupPaging").html(
						"<a href='javascript:void(0)' class='pagingBtn'" 
						+"value='"+$("#currentPage").val()+"'>"
						+"뒤로가기</a>");
				$("#groupList").append(html);
				html = groupMemberListAppend(tripNo, groupMemberList, 2);
				$("#groupMemberList").html(html);
			}
	});
});
//그룹상세보기 html추가
function groupViewAppend(trip) {
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
	if(trip.personId==$("#sessionId").val()){
	html += "<span class='w3-right w3-opacity'>";
	html += "<button type='button' class='btn btn-primary' id='applyMemberListBtn' tripNo='"+trip.tripNo+"' value='1'>참가신청자보기</button>"
	html += "</span>";
	}
	html += "<hr class='w3-clear'>";
	html +="<table class='table table-striped table-hover'>";
	html +="<thead>";
	html +="<tr>";
	html +="<th>#</th>";
	html +="<th>ID</th>";
	html +="<th>NAME</th>";
	html +="<th>LEVEL</th>";
	html +="<th>APPLYDATE</th>";
	html +="<th>APPROVEDATE</th>";
	html +="</tr>";
	html +="</thead>";
	html +="<tbody id='groupMemberList'>";
	html +="</tbody>";
	html +="</table>";
	return html;
}
//그룹상세보기 그룹멤버 html 추가
function groupMemberListAppend(tripNo, groupMemberList, approveStateCd){
	var html = "";
	var groupApplyDate ="";
	var groupApproveDate ="";
	if(approveStateCd == "1"){
		$('#applyMemberListBtn').val('2');
		$('#applyMemberListBtn').html("그룹원 보기");
	}else{
		$('#applyMemberListBtn').val('1');
		$('#applyMemberListBtn').html("참가신청자보기");
	}
	$.each(groupMemberList, function(key, item) {
		groupApplyDate = item.groupApplyDate.substr(0,10);
		html +="<tr>";
		html +="<td>"+key+"</td>";
		html +="<td>"+item.personId+"</td>";
		html +="<td>"+item.memberNm+"</td>";
		html +="<td>"+item.groupMemberLevel+"</td>";
		html +="<td>"+groupApplyDate+"</td>";
		html +="<td>";
		if(approveStateCd =="2"){
			groupApproveDate = item.groupApproveDate.substr(0,10);
			html+= groupApproveDate;
		}else{
			html +="<a href='javascript:void(0)' class='groupApproveBtn' tripNo='"+tripNo+"' personId='"+item.personId+"' value='2'>승인</a> / ";
			html +="<a href='javascript:void(0)' class='groupApproveBtn' tripNo='"+tripNo+"' personId='"+item.personId+"' value='3'>거절</a>";
		}
		html +="</td>";
		html +="</tr>";
		
	});
	return html;
}
//참가신청자 리스트
$(document).on('click', '#applyMemberListBtn', function() {
	var tripNo = $(this).attr('tripNo');
	var approveStateCd = $(this).attr('value');
	$.ajax({
			url : "applyMemberList",
			type : "POST",
			data : {
				tripNo : tripNo, approveStateCd : approveStateCd
			},
			dataType : "json",
			success : function(data) {
				var html = "";
				var groupMemberList = data.groupMemberList;
				html = groupMemberListAppend(tripNo, groupMemberList, approveStateCd);
				$("#groupMemberList").html(html);
			}
	});
});
//그룹참가 신청자 승인 or 거절
$(document).on('click', '.groupApproveBtn', function() {
	var tripNo = $(this).attr('tripNo');
	var approveStateCd = $(this).attr('value');
	var personId = $(this).attr('personId');
	console.log(tripNo);
	console.log(approveStateCd);
	$.ajax({
			url : "groupApprove",
			type : "POST",
			data : {
				tripNo : tripNo, personId : personId, approveStateCd : approveStateCd
			},
			dataType : "json",
			success : function(data) {
				var html = "";
				var trip = data.trip;
				var groupMemberList = data.groupMemberList;
				html = groupViewAppend(trip);
				$("#groupList").empty();
				$("#groupPaging").html(
						"<a href='javascript:void(0)' class='pagingBtn'" 
						+"value='"+$("#currentPage").val()+"'>"
						+"뒤로가기</a>");
				$("#groupList").append(html);
				html = groupMemberListAppend(tripNo, groupMemberList, 2);
				$("#groupMemberList").html(html);
			}
	});
});

//가입취소
$(document).on('click', '.applyCancelBtn', function() {
	var tripNo = $(this).attr('value');
	var currentPage = $("#currentPage").val();
	var groupMemberLevel = "member";
	$.ajax({
			url : "applyCancel",
			type : "POST",
			data : {
				tripNo : tripNo, currentPage : currentPage, groupMemberLevel : groupMemberLevel
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
	});
});
//그룹탈퇴
$(document).on('click', '.groupDropBtn', function() {
	var tripNo = $(this).attr('value');
	var currentPage = $("#currentPage").val();
	var groupMemberLevel = "member";
	$.ajax({
			url : "groupDrop",
			type : "POST",
			data : {
				tripNo : tripNo, currentPage : currentPage, groupMemberLevel : groupMemberLevel
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
	});
});