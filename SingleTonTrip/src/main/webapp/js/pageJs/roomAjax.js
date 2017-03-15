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
	var roomNo = $('#roomReserveNo').val();
	var notThisMonthColor="#BDBDBD";
	var sundayColor="#FF0000";
	var weekdayColor="#000000";
	var saturdayColor="#0000FF";
	$.each(calendarList,function(key, item) {
		if(key%7==0){
			 html+= "<tr class='fc-week'>";
		}
		
		html+= "<td class='fc-day fc-widget-content'>";
		if(item.reserveVo == null){
			
		}
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
		html+="</div>";
		html+= "<div class='fc-day-content'>";
		if(item.day <=(key+1) && (key-item.day)<27){
			if(item.reserveVo != null){
				html+="<h5 style='color:#FF0000;'>예약중</h5>";
			}else{
				html+="<form action='reserveAdd' method='post'>";
				html+="<input type='hidden' name='roomNo' value='"+roomNo+"'>";
				html+="<input type='hidden' name='reserveCheckinDate' value='"+item.date+"'>";
				html+="<button type='submit' class='btn btn-default'>예약</button>";
				html+="</form>";
			}
		}
		html+= "<div style='position: relative; height: 25px;'></div>";
		html+= "</div>";
		html+= "</div>";
		html+= "</td>";
		if(key%7==6){
			 html+= "</tr>";
		}
	});
	return html;
}