//구글 맵
function googleMap(planSite, planContent) {
	var mapOptions = {
		zoom : 14,
		scrollwheel : true, // 줌 인&아웃 휠 컨트롤
		zoomControl : true // 줌 컨트롤 표시
	};
	var map = new google.maps.Map(document.getElementById('google_map'),
			mapOptions);
	var marker = null;
	for (var i = 0; i < planSite.length; i++) {
		addMarker(map, planSite[i], planContent[i]);
	};
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
// 이미지 미리보기
function fileInfo(f) {
	$("#postInputImg").empty();
	var file = f.files;
	var reader = new FileReader();
	reader.onload = function(rst) {
		var html = "";
		html += "<button type='button' id='postImgDelete'>이미지 삭제</button>";
		html += postImgAppend(rst.target.result);
		$("#postInputImg").append(html);
	}
	reader.readAsDataURL(file[0]);
}

// modal 이미지 미리보기
function fileModalInfo(f) {
	$("#postModalImg").empty();
	var file = f.files;
	var reader = new FileReader();
	reader.onload = function(rst) {
		var html = "";
		html = postImgAppend(rst.target.result);
		$("#postModalImg").append(html);
	}
	reader.readAsDataURL(file[0]);
}

// 포스트 등록
$(document).on('click', '#postAddBtn', function() {
	var formData = new FormData($("#postAddForm")[0]);
	$.ajax({
		url : "postAdd", // controller 로 보낼 url
		type : "POST", // 보내는 방식 ( get, post)
		data : formData, // 내가 보내는 데이터 (form 을보낼수도 있고
		// {postNo : postNo, lastPostRow : ('#lastPostRow')} 이런식으로 변수를 보냄
		dataType : "json", // 처리 후 데이터를 받는 형식
		contentType : false,
		processData : false,
		cache : false,
		success : function(data) { // 연결이 성공
			console.log(data);
			var postList = data.postList;
			html = postAppend(postList);
			$("#postList").empty();
			$("#postList").append(html);
		}
	})
});
// 포스트등록 이미지 삭제
$(document).on('click', '#postImgDelete', function() {
	var postImgFile = $('#postImgFile');
	postImgFile.replaceWith(postImgFile.val('').clone(true));
	$("#postInputImg").empty();
});

// 포스트 더보기
$(document).on('click', '#addList', function() {
	var lastPostRow = $('.lastPostRow').attr('value');
	lastPostRow = Number(lastPostRow);
	lastPostRow += 5;
	var html = "";
	$.ajax({
		url : "personMain",
		type : "POST",
		data : {
			lastPostRow : lastPostRow
		},
		dataType : "json",
		success : function(data) {
			$('.lastPostRow').val(lastPostRow);
			var postList = data.postList;
			html = postAppend(postList);
			$("#postList").empty();
			$("#postList").append(html);
		}
	})
});
// 포스트 수정 modal
function postModifyModalShow(postNo) {
	$("#postModalImg").empty();
	$.ajax({
		url : "postView",
		type : "POST",
		data : {
			postNo : postNo
		},
		dataType : "json",
		success : function(data) {
			var post = data.post;
			$("#postModifyTitle").val(post.postTitle);
			$("#postModifyNo").val(post.postNo);
			$("#postModifyContent").val(post.postContent);
			$("#postModifyModal").modal('show');
			if (post.postImg != null) {
				var html = "";
				html = postImgAppend("../images/" + post.postImg);
				$("#postModalImg").append(html);
			}

		}
	})
};

// 포스트 수정
$(document).on('click', '#postModifyBtn', function() {
	var lastPostRow = $('.lastPostRow').attr('value');
	var formData = new FormData($("#postModifyForm")[0]);
	var html = ""
	$.ajax({
		url : "postModify",
		type : "POST",
		data : formData,
		dataType : "json",
		contentType : false,
		processData : false,
		cache : false,
		success : function(data) {
			var postList = data.postList;
			html = postAppend(postList);
			$("#postList").empty();
			$("#postList").append(html);
		}
	})
});

// 포스트 삭제 modal
function postDeleteModalShow(postNo) {
	$("#postDeleteNo").val(postNo);
	$("#postDeleteModal").modal('show');
};

// 포스트 삭제
$(document).on('click', '#postDeleteBtn', function() {
	var lastPostRow = $('.lastPostRow').attr('value');
	var postNo = $('#postDeleteNo').val();
	$.ajax({
		url : "postDelete",
		type : "POST",
		data : {
			postNo : postNo,
			lastPostRow : lastPostRow
		},
		dataType : "json",
		success : function(data) {
			var postList = data.postList;
			html = postAppend(postList);
			$("#postList").empty();
			$("#postList").append(html);
		}
	})
});

// 댓글 리스트 보기
$(document).on('click', '.commentListBtn', function() {
	var postNo = $(this).attr('value');
	var commentFlag = $("#commentFlag" + postNo).attr('value');
	var divId = "commentList" + postNo;
	var html = ""
	if (commentFlag == 'close') {
		$.ajax({
			url : "postCommentList",
			type : "POST",
			data : {
				postNo : postNo
			},
			dataType : "json",
			success : function(data) {
				var postCommentList = data.postCommentList;
				html = postCommentAppend(postNo, postCommentList);
				$("#" + divId).empty();
				$("#" + divId).append(html);
				$("#commentFlag" + postNo).val("open");
			}
		})
	} else {
		$("#" + divId).empty();
		$("#commentFlag" + postNo).val("close");
	}
});

// 댓글 리스트 추가
$(document).on('click', '.commentListAdd', function() {
	var postNo = $(this).attr('value');
	var lastCommentRow = $('#' + 'lastCommentRow' + postNo).attr('value');
	lastCommentRow = Number(lastCommentRow);
	var divId = "commentList" + postNo;
	var html = "";
	$.ajax({
		url : "postCommentList",
		type : "POST",
		data : {
			postNo : postNo,
			lastCommentRow : lastCommentRow
		},
		dataType : "json",
		success : function(data) {
			$('#' + 'lastCommentRow' + postNo).val(lastCommentRow + 5);
			var postCommentList = data.postCommentList;
			$.each(postCommentList, function(key, item) {
				var postCommentList = data.postCommentList;
				html = postCommentAppend(postNo, postCommentList);
				$("#" + divId).empty();
				$("#" + divId).append(html);
			})
		}
	})
});

// 댓글 등록
$(document).on('click', '.commentAddBtn', function() {
	var postNo = $(this).attr('value');
	var postCommentContent = $("#comment" + postNo).val();
	var divId = "commentList" + postNo;
	var html = "";
	$.ajax({
		url : "postCommentAdd",
		type : "POST",
		data : {
			postNo : postNo,
			postCommentContent : postCommentContent
		},
		dataType : "json",
		success : function(data) {
			var postCommentList = data.postCommentList;
			html = postCommentAppend(postNo, postCommentList);
			$("#" + divId).empty();
			$("#" + divId).append(html);
		}
	})
});

// 댓글 삭제
$(document).on('click', '.commentDelete', function() {
	var postCommentNo = $(this).attr('value');
	var postNo = $(this).attr('postno');
	var divId = "commentList" + postNo;
	var lastCommentRow = $('#' + 'lastCommentRow' + postNo).attr('value');
	lastCommentRow = Number(lastCommentRow);
	$.ajax({
		url : "postCommentDelete",
		type : "POST",
		data : {
			postNo : postNo,
			postCommentNo : postCommentNo,
			lastCommentRow : lastCommentRow
		},
		dataType : "json",
		success : function(data) {
			var postCommentList = data.postCommentList;
			html = postCommentAppend(postNo, postCommentList);
			$("#" + divId).empty();
			$("#" + divId).append(html);
			$("#commentFlag" + postNo).val("open");
		}
	})
});

// 포스트 html추가
function postAppend(postList) {
	var html = "";
	$
			.each(
					postList,
					function(key, item) {
						html += "<div class='w3-container w3-card-2 w3-white w3-round w3-margin'><br>";
						html += "<span class='w3-right w3-opacity'>"
								+ item.postRegDate + "</span><br>";
						html += "<span class='w3-right w3-opacity'>";
						html += "<button type='button' class='btn btn-primary' onclick='postModifyModalShow("
								+ item.postNo + ")'>수정</button>";
						html += "<button type='button' class='btn btn-primary' onclick='postDeleteModalShow("
								+ item.postNo + ")'>삭제</button>";
						html += "</span>";
						html += "<h4>" + item.postTitle + "</h4><br>";
						html += "<hr class='w3-clear'>";
						html += "<p>" + item.postContent + "</p>";
						if (item.postImg != null) {
							html += "<div class='w3-row-padding' style='margin:0 -16px'>";
							html += "<div class='w3-half'>";
							html += "<img src='../images/"
									+ item.postImg
									+ "' style='width: 100%' class='w3-margin-bottom'>";
							html += "</div>";
							html += "</div>";
						}
						html += "<hr class='w3-clear'>";
						html += "<button type='button' class='w3-btn w3-theme-d2 w3-margin-bottom commentListBtn' value='"
								+ item.postNo
								+ "''><i class='fa fa-comment'></i>  Comment</button> ";
						html += "<input type='hidden' id='lastCommentRow"
								+ item.postNo + "' value='10'>";
						html += "<input type='hidden' id='commentFlag"
								+ item.postNo + "' value='close'>";
						html += "<div id='commentList" + item.postNo + "'>";
						html += "</div>";
						html += "</div>";
					})
	return html;
}

// 댓글 html추가
function postCommentAppend(postNo, postCommentList) {
	var html = "";
	html += "<input type='text' id='comment" + postNo + "'>";
	html += "<button type='button' class='commentAddBtn' value='" + postNo
			+ "'>댓글등록</button>";
	html += "<button class='commentListAdd' value='" + postNo
			+ "'>댓글더보기</button>";
	html += "<table border='1'>";
	html += "<thead>";
	html += "<tr>";
	html += "<td>ID</td>";
	html += "<td>Content</td>";
	html += "<td>regDate</td>";
	html += "<td></td>";
	html += "</tr>";
	html += "</thead>";
	html += "<tbody id='tbody" + postNo + "'>";
	$
			.each(
					postCommentList,
					function(key, item) {
						html += "<tr>";
						html += "<td>" + item.memberId + "</td>";
						html += "<td>" + item.postCommentContent + "</td>";
						html += "<td>" + item.postCommentRegDate + "</td>";
						html += "<td><a class='commentDelete' postno='"
								+ postNo
								+ "' value='"
								+ item.postCommentNo
								+ "'><span class='glyphicon glyphicon glyphicon-remove' aria-hidden='true'></span></a></td>";
						html += "</tr>";
					})
	html += "</tbody>";
	html += "</table>";
	return html;
}

// 포스트 이미지 html추가
function postImgAppend(img) {
	var html = "";
	html += "<div class='w3-row-padding' style='margin:0 -16px'>";
	html += "<div class='w3-half'>";
	html += "<img src='" + img
			+ "' style='width: 100%' class='w3-margin-bottom'>";
	html += "</div>";
	html += "</div>";
	return html;
}

// 여행탭 클릭시 여행리스트 호출
$(document).on('click', '#tripTab', function() {
	var lastTripRow = $('#lastTripRow').attr('value');
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
// 여행 상세보기
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
				var planSite = new Array;
				var planContent = new Array;
				$.each(planList, function(key, item) {
					planSite.push(item.planSite);
					planContent.push(item.planContent);
				});
				googleMap(planSite, planContent);
				$("#tripFlag" + tripNo).val("open");
			}
		})
	} else {
		$("#tripDetail" + tripNo).empty();
		$("#tripFlag" + tripNo).val("close");
	}
});

// 여행 html추가
function tripAppend(tripList) {
	var html = "";
	$
			.each(
					tripList,
					function(key, item) {
						html += "<div class='w3-container w3-card-2 w3-white w3-round w3-margin'><br>";
						html += "<span class='w3-right w3-opacity'>"
								+ item.tripRegDate + "</span><br>";
						html += "<span class='w3-right w3-opacity'>";
						html += "<button type='button' class='btn btn-primary'>수정</button>";
						html += "<button type='button' class='btn btn-primary'>삭제</button>";
						html += "</span>";
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
						html += "<p>" + item.regionDo + " " + item.regionSi
								+ "</p>";
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
// 여행상세보기 html추가
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
	$.each(planList, function(key, item) {
		html += "<p>일정No : " + item.planNo + "</p>";
		html += "<p>지역 : " + item.planSite + "</p>";
		html += "<p>내용 : " + item.planContent + "</p>";
		html += "<p>시간 : " + item.planStartTime + " ~ " + item.planEndTime
				+ "</p>";
		html += "<p>예상비용: " + item.planPrice + "</p>";
	});
	html += "<div id='google_map' style='width:350px;height:350px;'></div>";
	html += "<hr class='w3-clear'>";
	return html;
}
