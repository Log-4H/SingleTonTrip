//객실탭 클릭시 여행리스트 호출
$(document).on('click', '#roomTab', function() {
	$.ajax({
		url : "roomList",
		type : "POST",
		dataType : "json",
		success : function(data) {
			var html = "";
			var roomList = data.roomList;
			html = roomListAppend(roomList);
			$("#roomList").empty();
			$("#roomList").append(html);
		}
	})
});
//숙소 html추가
function roomListAppend(roomList) {
	var html = "";
	$.each(roomList,function(key, item) {
		var roomFacilityList = item.roomFacilityList
		html += "<div class='w3-container w3-card-2 w3-white w3-round w3-margin'><br>";
		if($("#sessionLevel").val() == 2){
			if($("#pageId").val() == $("#sessionId").val()){
				html += "<span class='w3-right w3-opacity'>";
				html += "<button type='button' class='btn btn-primary'>수정</button>";
				html += "<button type='button' class='btn btn-primary'>삭제</button>";
				html += "</span>";
			}
		}else if($("#sessionLevel").val() == 3){
			html += "<span class='w3-right w3-opacity'>";
			html += "<button type='button' class='btn btn-primary roomReserveListModal' ddayOption='default' value='"+item.roomNo+"'>실시간예약</button>";
			html += "</span>";
		}else if($("#sessionId").val()==""){
			html += "<span class='w3-right w3-opacity'>";
			html += "</span>";
		}
		html += "<h4>" + item.roomNm + "</h4><br>";
		html += "<hr class='w3-clear'>";
		html += "<div class='w3-row-padding' style='margin:0 -16px'>";
		html += "<div class='w3-half'>";
		if (item.postImg != null) {
			html += "<img src='./images/"+item.postImg+ "' style='width: 100%' class='w3-margin-bottom'>";
		}else{
			html += "<img src='./images/RoomSample.jpg' style='width: 100%' class='w3-margin-bottom'>";
		}
		html += "</div>";
		html += "</div>";
		html += "<p>" + item.roomDetail + "</p>";
		html += "<hr class='w3-clear'>";
		html += "<p>기본인원 : "+ item.roomBaseCount + "</p>";
		html += "<p>최대인원 : "+ item.roomMaxCount + "</p>";
		html += "<p>평일가격 : "+ item.roomNormalPrice + "</p>";
		html += "<p>주말/공휴일가격 : "+ item.roomHolidayPrice + "</p>";
		html += "<p>1인추가가격 : "+ item.roomExtraPrice + "</p>";
		html += "<hr class='w3-clear'>";
		html += "<h4>객실시설</h4><br>";
		$.each(roomFacilityList, function(key, value) {
			html += "<p>"+value.facilityNm+"</p>";
		});
		html += "</div>";
	})
	return html;
}
//실시간예약 modal
$(document).on('click', '.roomReserveListModal', function() {
	var roomNo = $(this).attr('value');
	$('#roomReserveNo').val(roomNo);
	$('#ddayYear').val(0);
	$('#ddayMonth').val(0);
	var ddayOption = 'default';
	var ddayYear = $('#ddayYear').val();
	var ddayMonth = $('#ddayMonth').val();
	reserveCalendar(roomNo, ddayYear, ddayMonth, ddayOption);
	$("#roomReserveListModal").modal('show');
});
//달력변경 modal
$(document).on('click', '.calendarMoveBtn', function() {
	var roomNo = $('#roomReserveNo').val();
	var ddayOption = $(this).attr('ddayOption');
	var ddayYear = $('#ddayYear').val();
	var ddayMonth = $('#ddayMonth').val();
	reserveCalendar(roomNo, ddayYear, ddayMonth, ddayOption);
	$("#roomReserveListModal").modal('show');
});
//달력 load function
function reserveCalendar(roomNo, ddayYear, ddayMonth, ddayOption){
	$.ajax({
		url : "calendar",
		type : "POST",
		data : {roomNo, ddayYear:ddayYear, ddayMonth:ddayMonth, ddayOption:ddayOption},
		dataType : "json",
		success : function(data) {
			var html ="";
			var calendarTitle = data.ddayYear+"년 "+(data.ddayMonth+1)+"월";
			$("#calendarTitle").html(calendarTitle);
			var calendarList = data.calendarList;
			html = calenderAppend(calendarList);
			$('#calendarListTbody').html(html);
			$('#ddayYear').val(data.ddayYear);
			$('#ddayMonth').val(data.ddayMonth);
		}
	})
}
//달력 추가 html
function calenderAppend(calendarList){
	var html = "";
	var notThisMonthColor="#BDBDBD";
	var sundayColor="#FF0000";
	var weekdayColor="#000000";
	var saturdayColor="#0000FF";
	$.each(calendarList,function(key, item) {
		if(key%7==0){
			 html+= "<tr class='fc-week'>";
		}
		html+= "<td class='fc-day fc-widget-content'>";
		html+= "<div style='min-height: 80px;'>";
		html+= "<div class='fc-day-number' style='color:"
		if(item.day > (key+1) || (key-item.day) > 27){
			html+=notThisMonthColor;
		}else{
			if(key%7==0){
				html+= sundayColor;
			}else if((key%7)>0 && (key%7)<6){
				html+= weekdayColor;
			}else if(key%7==6){
				html+= saturdayColor;
			}
		}
		html+=";font-weight:bold;'>"+item.day;
		if(item.reserveVo != null){
			html+="<br>";
			html+="예약중!";
		}
		html+="</div>";
		html+= "<div class='fc-day-content'>";
		html+= "<div style='position: relative; height: 25px;'> </div>";
		html+= "</div>";
		html+= "</div>";
		html+= "</td>";
		if(key%7==6){
			 html+= "</tr>";
		}
	});
	return html;
}
/*
//여행 상세보기
$(document).on('click', '.tripDetailBtn', function() {
	var tripNo = $(this).attr('value');
	var tripFlag = $("#tripFlag" + tripNo).attr('value');
	var html = "";
	if (tripFlag == 'close') {
		$.ajax({
			url : "tripView",
			type : "POST",
			data : {
				tripNo : tripNo
			},
			dataType : "json",
			success : function(data) {
				var trip = data.trip;
				var planList = data.planList;
				html = tripDetailAppend(trip, planList);
				$("#tripDetail" + tripNo).empty();
				$("#tripDetail" + tripNo).append(html);
				if(planList.length!=0){
					var planSite = new Array;
					var planContent = new Array;
					$.each(planList, function(key, item) {
						planSite.push(item.planSite);
						planContent.push(item.planContent);
					});
					googleMap(tripNo, planSite, planContent);
				}
				$("#tripFlag" + tripNo).val("open");
			}
		})
	} else {
		$("#tripDetail" + tripNo).empty();
		$("#tripFlag" + tripNo).val("close");
	}
});
//여행지역(시) 리스트
function regionSiListShow(value){
	$.ajax({
		url : "regionSiList",
		type : "POST",
		data : {regionDo : value},
		dataType : "json",
		success : function(data) {
			$("#regionSiList").empty();
			var regionSiList = data.regionSiList;
			$.each(regionSiList,function(key, item) {
				$("#regionSiList").append("<option value='"+item.regionCd+"'>"+item.regionSi+"</option>");
			});
		}
	})
}
//여행등록 modal
function tripAddModalShow(){
	$("#tripAddForm")[0].reset();
	$.ajax({
		url : "tripAdd",
		type : "GET",
		dataType : "json",
		success : function(data) {
			var tripThemeList = data.tripThemeList;
			$.each(tripThemeList,function(key, item) {
				$("#tripThemeList").append("<option value='"+item.tripThemeCd+"'>"+item.tripThemeNm+"</option>");
			});
			var regionDoList = data.regionDoList;
			$.each(regionDoList,function(key, item) {
				$("#regionDoList").append("<option value='"+item.regionDo+"'>"+item.regionDo+"</option>");
			});
			$("#tripAddModal").modal('show');
		}
	})
};
//여행등록
$(document).on('click', '#tripAddBtn', function() {
	$.ajax({
		url : "tripAdd",
		type : "POST",
		data : $("#tripAddForm").serialize(),
		dataType : "json",
		success : function(data) {
			var html = "";
			var tripList = data.tripList;
			html = tripAppend(tripList);
			$("#tripList").empty();
			$("#tripList").append(html);
		}
	})
});

//여행일정등록 modal
$(document).on('click', '.planAddModalBtn', function() {
	var tripNo = $(this).attr('value');
	$("#planAddForm")[0].reset();
	$("#planAddTripNo").val(tripNo);
	$("#planAddModal").modal('show');
});
//여행일정 등록
$(document).on('click', '#planAddBtn', function() {
	$.ajax({
		url : "planAdd",
		type : "POST",
		data : $("#planAddForm").serialize(),
		dataType : "json",
		success : function(data) {
			var html = "";
			var trip = data.trip;
			var planList = data.planList;
			html = tripDetailAppend(trip, planList);
			$("#tripDetail" + trip.tripNo).empty();
			$("#tripDetail" + trip.tripNo).append(html);
			if(planList.length!=0){
				var planSite = new Array;
				var planContent = new Array;
				$.each(planList, function(key, item) {
					planSite.push(item.planSite);
					planContent.push(item.planContent);
				});
				googleMap(trip.tripNo, planSite, planContent);
			}
			$("#tripFlag" + trip.tripNo).val("open");
		}
	})
});
//여행일정수정 modal
$(document).on('click', '.planModifyShow', function() {
	var planNo = $(this).attr('value');
	$.ajax({
		url : "planView",
		type : "POST",
		data : {
			planNo : planNo
		},
		dataType : "json",
		success : function(data) {
			var plan = data.plan;
			$("#planModifyNo").val(plan.planNo);
			$("#planModifyTripNo").val(plan.tripNo);
			$("#planModifySite").val(plan.planSite);
			$("#planModifyContent").val(plan.planContent);
			$("#planModifyStartTime").val(plan.planStartTime);
			$("#planModifyEndTime").val(plan.planEndTime);
			$(".planModifyPrice").val(plan.planPrice);
			$("#planModifyModal").modal('show');
		}
	})
});
//여행일정 수정
$(document).on('click', '#planModifyBtn', function() {
	$.ajax({
		url : "planUpdate",
		type : "POST",
		data : $("#planModifyForm").serialize(),
		dataType : "json",
		success : function(data) {
			var html = "";
			var trip = data.trip;
			var planList = data.planList;
			html = tripDetailAppend(trip, planList);
			$("#tripDetail" + trip.tripNo).empty();
			$("#tripDetail" + trip.tripNo).append(html);
			if(planList.length!=0){
				var planSite = new Array;
				var planContent = new Array;
				$.each(planList, function(key, item) {
					planSite.push(item.planSite);
					planContent.push(item.planContent);
				});
				googleMap(trip.tripNo, planSite, planContent);
			}
			$("#tripFlag" + trip.tripNo).val("open");
		}
	})
});
//여행일정 삭제modal
$(document).on('click', '.planDeleteShow', function() {
	var planNo = $(this).attr('value');
	var tripNo = $(this).attr('tripNo');
	$("#planDeleteNo").val(planNo);
	$("#planDeleteTripNo").val(tripNo);
	$("#planDeleteModal").modal('show');
});

//여행일정 삭제
$(document).on('click', '#planDeleteBtn', function() {
	var planNo = $("#planDeleteNo").val();
	var tripNo = $("#planDeleteTripNo").val();
	$.ajax({
		url : "planDelete",
		type : "POST",
		data : {planNo : planNo, tripNo:tripNo},
		dataType : "json",
		success : function(data) {
			var html = "";
			var trip = data.trip;
			var planList = data.planList;
			html = tripDetailAppend(trip, planList);
			$("#tripDetail" + trip.tripNo).empty();
			$("#tripDetail" + trip.tripNo).append(html);
			if(planList.length!=0){
				var planSite = new Array;
				var planContent = new Array;
				$.each(planList, function(key, item) {
					planSite.push(item.planSite);
					planContent.push(item.planContent);
				});
				googleMap(trip.tripNo, planSite, planContent);
			}
			$("#tripFlag" + trip.tripNo).val("open");
		}
	})
});
//여행 html추가
function tripAppend(tripList) {
	var html = "";
	$.each(tripList,function(key, item) {
		html += "<div class='w3-container w3-card-2 w3-white w3-round w3-margin'><br>";
		html += "<span class='w3-right w3-opacity'>"
				+ item.tripRegDate + "</span><br>";
		if($("#pageId").val() == $("#sessionId").val()){
			html += "<span class='w3-right w3-opacity'>";
			html += "<button type='button' class='btn btn-primary'>수정</button>";
			html += "<button type='button' class='btn btn-primary'>마감</button>";
			html += "</span>";
		}else if($("#sessionId").val()==""){
			html += "<span class='w3-right w3-opacity'>";
			html += "</span>";
		}else if(item.recruitStateCd==1){
			html += "<span class='w3-right w3-opacity'>";
			html += "<button type='button' class='btn btn-primary tripJoinModalShow' value='"+item.tripNo+"'>참가신청</button>";
			html += "</span>";
		}
		if (item.recruitStateCd == 1) {
			html += "<span class='label label-success'>";
		} else if (item.recruitStateCd == 2) {
			html += "<span class='label label-warning'>";
		} else if (item.recruitStateCd == 3) {
			html += "<span class='label label-danger'>";
		}
		html += item.recruitStateNm;
		html += "</span>";
		html += "<h4>" + item.tripTitle + "</h4><br>";
		html += "<hr class='w3-clear'>";
		html += "<p>" + item.tripThemeNm + "</p>";
		if(item.regionDo!=item.regionSi){
			html += "<p>" + item.regionDo + " " + item.regionSi + "</p>";
		}else{
			html += "<p>" + item.regionDo + "</p>";
		}
		html += "<hr class='w3-clear'>";
		html += "<p>" + item.tripContent + "</p>";
		html += "<hr class='w3-clear'>";
		html += "<div id='tripDetail" + item.tripNo
				+ "'></div>";
		html += "<button type='button' class='w3-btn w3-theme-d2 w3-margin-bottom tripDetailBtn' value='"
				+ item.tripNo + "''>";
		html += "<i class='fa fa-comment'></i>  상세보기</button> ";
		html += "<input type='hidden' id='tripFlag"
				+ item.tripNo + "' value='close'>";
		html += "</div>";
	})
	return html;
}
//여행상세보기 html추가
function tripDetailAppend(trip, planList) {
	var html = "";
	html += "<p>참여인원(현재인원/총인원) : " + trip.tripPresentMember + " / "
			+ trip.tripMaxMember + "</p>";
	html += "<p>여행기간 : " + trip.tripStartDate + " ~ " + trip.tripEndDate
			+ "</p>";
	html += "<p>예상경비(1인경비/총경비) : " + trip.tripPerPrice + " / "
			+ trip.tripTotalPrice + "</p>";
	html += "<p>모집기간 : " + trip.tripRecruitStartDate + " ~ "
			+ trip.tripRecruitEndDate + "</p>";
	html += "<p>태그 : #" + trip.tripTag + "</p>";
	html += "<hr class='w3-clear'>";
	if($("#pageId").val() == $("#sessionId").val()){
		html += "<button type='button' class='btn btn-primary planAddModalBtn' value='"+trip.tripNo+"'>일정등록</button>";
	}
	html += "<hr class='w3-clear'>";
	if(planList.length!=0){
		$.each(planList, function(key, item) {
			if($("#pageId").val() == $("#sessionId").val()){
				html += "<div align='right'>";
				html += "<a class='planModifyShow' value='"+ item.planNo+ "'>" ;
				html += "<span class='glyphicon glyphicon-wrench' aria-hidden='true'></span></a>";
				html += "<a class='planDeleteShow' tripNo='"+trip.tripNo+"' value='"+ item.planNo+ "'>" ;
				html += "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a>";
				html += "</div>"
			}
			html += "<p>일정No : " + key + "</p>";
			html += "<p>지역 : " + item.planSite + "</p>";
			html += "<p>내용 : " + item.planContent + "</p>";
			html += "<p>시간 : " + item.planStartTime + " ~ " + item.planEndTime
					+ "</p>";
			html += "<p>예상비용: " + item.planPrice + "</p>";
			html += "<hr class='w3-clear'>";
		});
		html += "<div id='google_map"+trip.tripNo+"' style='width:350px;height:350px;'></div>";
	}
	return html;
}

//여행그룹 참가modal
$(document).on('click', '.tripJoinModalShow', function() {
	$("#tripJoinBtn").hide();
	var tripNo = $(this).attr('value');
	$.ajax({
		url : "tripJoinCheck",
		type : "POST",
		data : {tripNo:tripNo},
		dataType : "json",
		success : function(data) {
			var html = "";
			var group = data.group;
			if(group!=null){
				if(group.approveStateCd=="1"){
					html += "그룹장의 승인 대기중입니다.";
				}else if(group.approveStateCd=="2"){
					html += "이미 그룹에 참가하셨습니다.";
				}else if(group.approveStateCd=="3"){
					html += "참여가 거부되었습니다.";
				}
			}else{
				$("#tripJoinBtn").show();
				html += "그룹장의 승인을 기다려야합니다.<br>";
				html +=	"그룹에 참가하시겠습니까?";
			}
			$("#tripJoinNo").val(tripNo);
			$("#tripJoinBody").html(html);
			$("#tripJoinModal").modal('show');
		}
	})
});
//여행그룹 참가신청
$(document).on('click', '#tripJoinBtn', function() {
	var tripNo = $("#tripJoinNo").val();
	var lastTripRow = $('.lastTripRow').attr('value');
	lastTripRow = Number(lastTripRow);
	$.ajax({
		url : "tripJoin",
		type : "POST",
		data : {tripNo:tripNo, lastTripRow:lastTripRow},
		dataType : "json",
		success : function(data) {
			var html = "";
			var tripList = data.tripList;
			html = tripAppend(tripList);
			$("#tripList").empty();
			$("#tripList").append(html);
		}
	})
});
*/