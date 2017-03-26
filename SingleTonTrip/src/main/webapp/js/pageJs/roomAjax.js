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
		html += "<div class='card'>";
		html += "<div align='right'>";
		if($("#sessionLevel").val() == 2){
			if($("#pageId").val() == $("#sessionId").val()){
				html += "<button type='button' class='btn btn-info' value='"+item.roomNo+"'><i class='fa fa-edit'></i></button>";
				html += "<button type='button' class='btn btn-danger' value='"+item.roomNo+"'><i class='fa fa-times'></i></button>";
			}
		}else if($("#sessionLevel").val() == 3){
			html += "<button type='button' class='btn btn-success roomReserveListModal' ddayOption='default' value='"+item.roomNo+"'><i class='fa fa-check-circle-o'></i> 실시간예약</button>";
		}
		html+="</div>";
		html+="<div class='card-header'><br><br>";
		html += "<h3><strong>" + item.roomNm + "</strong></h3>";
		html+="</div>";
		html+="<div class='card-block'>";
		if (item.postImg != null) {
			html += "<img src='./images/"+item.postImg+ "' style='width: 50%; height:50%'>";
		}else{
			html += "<img src='./assets/img/base/Room.jpg' style='width: 50%; height:50%'>";
		}
		html += "</div>";
		html+="<div class='card-block'>";
		html += "<p>" + item.roomDetail + "</p>";
		html += "<hr>";
		html += "<p>기본인원 : "+ item.roomBaseCount + "</p>";
		html += "<p>최대인원 : "+ item.roomMaxCount + "</p>";
		html += "<p>평일가격 : "+ item.roomNormalPrice + "</p>";
		html += "<p>주말/공휴일가격 : "+ item.roomHolidayPrice + "</p>";
		html += "<p>1인추가가격 : "+ item.roomExtraPrice + "</p>";
		html += "<hr>";
		html += "<h4>객실시설</h4><br>";
		$.each(roomFacilityList, function(key, value) {
			html += "<p>"+ value.facilityIcon+" "+value.facilityNm+"</p>";
		});
		html += "</div>";
		html += "</div>";
		html += "<br><br>";
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
				html+="<button type='button' class='btn btn-danger disabled'>예약중</button>";
			}else{
				console.log(item.date);
				html+="<form action='reserveAdd' method='post'>";
				html+="<input type='hidden' name='roomNo' value='"+roomNo+"'>";
				html+="<input type='hidden' name='reserveCheckinDate' value='"+item.date+"'>";
				html+="<button type='submit' class='btn btn-info'>예약</button>";
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