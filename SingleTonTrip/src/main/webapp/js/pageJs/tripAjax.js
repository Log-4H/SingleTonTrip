//구글 맵
function googleMap(no, planSite, planContent) {
	var mapOptions = {
		zoom : 14,
		scrollwheel : true, // 줌 인&아웃 휠 컨트롤
		zoomControl : true // 줌 컨트롤 표시
	};
	var map = new google.maps.Map(document.getElementById('google_map'+no),
			mapOptions);
	var marker = null;
	for (var i = 0; i < planSite.length; i++) {
		addMarker(map, planSite[i], planContent[i]);
	};
	google.maps.event.addDomListener(window, "resize", function() {
	   var center = map.getCenter();
	   google.maps.event.trigger(map, "resize");
	   map.setCenter(center); 
	});
}
//구글맵 마커등록
function addMarker(map, planSite, planContent){
	var geocoder = new google.maps.Geocoder();
	geocoder.geocode({'address' : planSite}, function(result, status) {
		if (status == google.maps.GeocoderStatus.OK) {
				map.setCenter(result[0].geometry.location);
				var marker = new google.maps.Marker({
							map : map,
							position : result[0].geometry.location,
						});
				var infowindow = new google.maps.InfoWindow({
							content : planContent
							});
				google.maps.event.addListener(marker,'click', function() {
					infowindow.open(map, marker);
				});
		} else {
			alert("Geocode was not successful for the following reason: "+ status);
		}
	});
}

//여행탭 클릭시 여행리스트 호출
$(document).on('click', '#tripTab', function() {
	var lastTripRow = $('.lastTripRow').attr('value');
	lastTripRow = Number(lastTripRow);
	$.ajax({
		url : "tripList",
		type : "POST",
		data : {
			lastTripRow : lastTripRow
		},
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
//여행리스트 더보기
$(document).on('click', '#addTripList', function() {
	var lastTripRow = $('.lastTripRow').attr('value');
	lastTripRow = Number(lastTripRow);
	lastTripRow += 5;
	var html = "";
	$.ajax({
		url : "tripList",
		type : "POST",
		data : {
			lastTripRow : lastTripRow
		},
		dataType : "json",
		success : function(data) {
			$('.lastTripRow').val(lastTripRow);
			var tripList = data.tripList;
			html = tripAppend(tripList);
			$("#tripList").empty();
			$("#tripList").append(html);
		}
	})
});
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
			$(".regionSiList").empty();
			var regionSiList = data.regionSiList;
			$.each(regionSiList,function(key, item) {
				$(".regionSiList").append("<option value='"+item.regionCd+"'>"+item.regionSi+"</option>");
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
		html += "<div class='card'>";
		html += "<div align='right'>";
		if($("#sessionLevel").val() == 3){
			if($("#pageId").val() == $("#sessionId").val()){
				if(item.recruitStateCd == 1){
				html += "<button type='button' class='btn btn-info tripModifyModalBtn' value='"+item.tripNo+"'><i class='fa fa-edit'></i></button>";
				html += "<button type='button' class='btn btn-success tripEndModalBtn' value='"+item.tripNo+"'><i class='material-icons'>check</i></button>";
				}else{
					html += "<button type='button' class='btn btn-danger tripDeleteModalBtn' value='"+item.tripNo+"'><i class='fa fa-times'></i></button>";
				}
			}else if(item.recruitStateCd==1){
				html += "<button type='button' class='btn btn-success tripJoinModalShow' value='"+item.tripNo+"'><i class='fa fa-user'></i></button>";
			}
		}
		html+="</div>";
		html+="<div class='card-header'><br><br>";
		if (item.recruitStateCd == 1) {
			html += "<span class='label label-success'>";
		} else if (item.recruitStateCd == 2) {
			html += "<span class='label label-warning'>";
		} else if (item.recruitStateCd == 3) {
			html += "<span class='label label-danger'>";
		}
		html += item.recruitStateNm;
		html += "</span>";
		html += "<h3><strong>" + item.tripTitle + "</strong></h3>";
		html+="</div>";
		html+="<div class='card-block'>";
		html += "<p class='card-text'>" + item.tripThemeNm + "</p>";
		if(item.regionDo!=item.regionSi){
			html += "<p class='card-text'>" + item.regionDo + " " + item.regionSi + "</p>";
		}else{
			html += "<p class='card-text'>" + item.regionDo + "</p>";
		}
		html +="</div>";
		html += "<hr>";
		html += "<h4>" + item.tripContent + "</h4>";
		html += "<hr>";
		html += "<div class='card-block' id='tripDetail" + item.tripNo
				+ "'></div>";
		html +="<div class='card-block'>";
		html += "<button type='button' class='btn btn-primary tripDetailBtn' value='"
				+ item.tripNo + "''>";
		html += "상세보기</button> ";
		html += "<input type='hidden' id='tripFlag"
				+ item.tripNo + "' value='close'>";
		html += "</div>";
		html +="<div class='card-footer text-muted'>";
		html +="<h6>"+item.tripRegDate+"</h6>";
		html += "</div>";
		html += "</div>";
		html +="<br><br>";
		
	})
	return html;
}
//여행상세보기 html추가
function tripDetailAppend(trip, planList) {
	var html = "";
	html += "<p class='card-text'>참여인원(현재인원/총인원) : " + trip.tripPresentMember + " / "
			+ trip.tripMaxMember + "</p>";
	html += "<p class='card-text'>여행기간 : " + trip.tripStartDate + " ~ " + trip.tripEndDate
			+ "</p>";
	html += "<p class='card-text'>예상경비(1인경비/총경비) : " + trip.tripPerPrice + " / "
			+ trip.tripTotalPrice + "</p>";
	html += "<p class='card-text'>모집기간 : " + trip.tripRecruitStartDate + " ~ "
			+ trip.tripRecruitEndDate + "</p>";
	html += "<p class='card-text'>태그 : #" + trip.tripTag + "</p>";
	if($("#pageId").val() == $("#sessionId").val()){
		html += "<button type='button' class='btn btn-primary planAddModalBtn' value='"+trip.tripNo+"'>일정등록</button>";
	}
	html += "<hr>";
	if(planList.length!=0){
		$.each(planList, function(key, item) {
			if($("#pageId").val() == $("#sessionId").val()){
				html += "<div align='right'>";
				html += "<button type='button' class='btn btn-info btn-simple btn-xs planModifyShow' value='"+ item.planNo+ "'>" ;
				html += "<i class='fa fa-edit'></i></button>";
				html += "<button type='button' class='btn btn-danger btn-simple btn-xs planDeleteShow' tripNo='"+trip.tripNo+"' value='"+ item.planNo+ "'>" ;
				html += "<i class='fa fa-times'></i></button>";
				html += "</div>"
			}
			html += "<p>일정No : " + key + "</p>";
			html += "<p>지역 : " + item.planSite + "</p>";
			html += "<p>내용 : " + item.planContent + "</p>";
			html += "<p>시간 : " + item.planStartTime + " ~ " + item.planEndTime
					+ "</p>";
			html += "<p>예상비용: " + item.planPrice + "</p>";
			html += "<hr>";
		});
		html += "<div class='googleMap' id='google_map"+trip.tripNo+"' style='max-width:700px; height:350px;'></div>";
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
//여행수정
$(document).on('click', '.tripModifyModalBtn', function() {
	var tripNo = $(this).attr('value');
	$("#tripModifyForm")[0].reset();
	$(".regionSiList").empty();
	$.ajax({
		url : "tripModifyForm",
		type : "GET",
		data : {
			tripNo : tripNo
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
			var trip = data.trip;
			var tripThemeList = data.tripThemeList;
			var regionDoList = data.regionDoList;
			var regionSiList = data.regionSiList;
			$.each(tripThemeList,function(key, tripTheme) {
				if(tripTheme.tripThemeCd == trip.tripThemeCd){
					$("#tripModifyThemeList").append("<option value='"+tripTheme.tripThemeCd+"' selected>"+tripTheme.tripThemeNm+"</option>");
				}else{
					$("#tripModifyThemeList").append("<option value='"+tripTheme.tripThemeCd+"'>"+tripTheme.tripThemeNm+"</option>");
				}
			});
			$.each(regionDoList,function(key, regionDo) {
				if(trip.regionDo == regionDo.regionDo){
					$("#regionModifyDoList").append("<option value='"+regionDo.regionDo+"' selected>"+regionDo.regionDo+"</option>");
				}else{
					$("#regionModifyDoList").append("<option value='"+regionDo.regionDo+"'>"+regionDo.regionDo+"</option>");
				}
			});
			$.each(regionSiList,function(key, regionSi) {
				if(trip.regionCd == regionSi.regionCd){
					$(".regionSiList").append("<option value='"+regionSi.regionCd+"' selected>"+regionSi.regionSi+"</option>");
				}else{
					$(".regionSiList").append("<option value='"+regionSi.regionCd+"'>"+regionSi.regionSi+"</option>");
				}
			});
			$("#tripModifyNo").val(trip.tripNo);
			$("#tripModifyTitle").val(trip.tripTitle);
			$("#tripModifyContent").val(trip.tripContent);
			$("#tripModifyMaxMember").val(trip.tripMaxMember);
			$("#tripModifyTag").val(trip.tripTag);
			$("#tripModifyStartDate").val(trip.tripStartDate);
			$("#tripModifyEndDate").val(trip.tripEndDate);
			$("#tripModifyRecruitEndDate").val(trip.tripRecruitEndDate);
			$("#tripModifyModal").modal('show');
		}
	})
});
//여행수정처리
$(document).on('click', '#tripModifyBtn', function() {
	$.ajax({
		url : "tripModify",
		type : "POST",
		data : $("#tripModifyForm").serialize(),
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

//여행마감 modal
$(document).on('click', '.tripEndModalBtn', function() {
	var tripNo = $(this).attr('value');
	$("#tripEndNo").val(tripNo);
	$("#tripEndModal").modal('show');
});
//여행마감 처리
$(document).on('click', '#tripEndBtn', function() {
	var tripNo = $("#tripEndNo").val();
	var lastTripRow = $('.lastTripRow').attr('value');
	lastTripRow = Number(lastTripRow);
	$.ajax({
		url : "tripEnd",
		type : "POST",
		data : {tripNo : tripNo , lastTripRow : lastTripRow},
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
//여행삭제 modal
$(document).on('click', '.tripDeleteModalBtn', function() {
	var tripNo = $(this).attr('value');
	$("#tripDeleteNo").val(tripNo);
	$("#tripDeleteModal").modal('show');
});
//여행삭제 처리
$(document).on('click', '#tripDeleteBtn', function() {
	var tripNo = $("#tripDeleteNo").val();
	var lastTripRow = $('.lastTripRow').attr('value');
	lastTripRow = Number(lastTripRow);
	$.ajax({
		url : "tripDelete",
		type : "POST",
		data : {tripNo : tripNo , lastTripRow : lastTripRow},
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

