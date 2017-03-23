// 이미지 미리보기
function fileInfo(f) {
	$("#postInputImg").empty();
	var file = f.files;
	var reader = new FileReader();
	reader.onload = function(rst) {
		var html = "";
		html += postImgAppend(rst.target.result);
		html += "<button type='button' class='btn' onclick='postImgDelete()'>이미지 삭제</button>";
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
//포스트 등록 modal
function postAddModalShow() {
	$("#postAddForm")[0].reset();
	$("#postInputImg").empty();
	$("#postAddModal").modal('show');
};
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
			var postList = data.postList;
			html = postAppend(postList);
			$("#postList").empty();
			$("#postList").append(html);
			$("#postAddForm")[0].reset();
			postImgDelete();
		}
	})
});
// 포스트등록 이미지 삭제
function postImgDelete() {
	var postImgFile = $('#postImgFile');
	postImgFile.replaceWith(postImgFile.val('').clone(true));
	$("#postInputImg").empty();
};

// 포스트 더보기
$(document).on('click', '#addList', function() {
	var lastPostRow = $('.lastPostRow').attr('value');
	lastPostRow = Number(lastPostRow);
	lastPostRow += 5;
	var html = "";
	$.ajax({
		url : "postList",
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
				html = postImgAppend("./images/" + post.postImg);
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
	$.each(postList,function(key, item) {
		html += "<div class='card'>";
		html += "<div align='right'>";
		if($("#pageId").val() == $("#sessionId").val()){
			html += "<button type='button' class='btn btn-info' onclick='postModifyModalShow("
					+ item.postNo + ")'><i class='fa fa-edit'></i></button>";
			html += "<button type='button' class='btn btn-danger' onclick='postDeleteModalShow("
					+ item.postNo + ")'><i class='fa fa-times'></i></button>";
		}
		html+="</div>";
		html+="<div class='card-header'>";
		html += "<h3><strong>" + item.postTitle + "</strong></h3>";
		html+="</div>";
		html+="<div class='card-block'>";
		if (item.postImg != null) {
			html += "<img src='./images/"+ item.postImg
					+ "' style='width: 50%; height:50%' onclick='doImgPop(\"./images/"+item.postImg+"\")'>";
		}
		html += "<br>";
		html += "<p class='card-text'>" + item.postContent + "</p>";
		html+="<div class='card-block'>";
		html += "<button type='button' class='commentListBtn' value='"
				+ item.postNo
				+ "''><i class='fa fa-comment'></i>  Comment</button> ";
		html += "<input type='hidden' id='lastCommentRow"
				+ item.postNo + "' value='10'>";
		html += "<input type='hidden' id='commentFlag"
				+ item.postNo + "' value='close'>";
		html += "<div id='commentList" + item.postNo + "'>";
		html += "</div>";
		html += "</div>";
		html += "</div>";
		html+="<div class='card-footer text-muted'>";
		html+="<h6>"+item.postRegDate+"</h6>";
		html += "</div>";
		html += "</div>";
		html+="<br><br>";
	})
	return html;
}

// 댓글 html추가
function postCommentAppend(postNo, postCommentList) {
	var html = "";
	if($("#sessionId").val()!=""){
	html += "<input type='text' id='comment" + postNo + "'> ";
	html += " <button type='button' class='btn commentAddBtn' value='" + postNo
			+ "'>댓글등록</button>";
	}
	html += "<div align='center'>";
	html += "<table class='table'>";
	html += "<thead>";
	html += "<tr>";
	html += "<th>ID</th>";
	html += "<th>Content</th>";
	html += "<th>regDate</th>";
	html += "<th>Delete</th>";
	html += "</tr>";
	html += "</thead>";
	html += "<tbody id='tbody" + postNo + "'>";
	$.each(postCommentList,function(key, item) {
		console.log($("#pageId").val());
		console.log($("#sessionId").val());
		console.log(item.memberId);
		html += "<tr>";
		html += "<td>" + item.memberId + "</td>";
		html += "<td>" + item.postCommentContent + "</td>";
		html += "<td>" + item.postCommentRegDate + "</td>";
		html += "<td>";
		if($("#pageId").val() == $("#sessionId").val() || $("#sessionId").val() == item.memberId){
			html +="<button type='button' class='btn btn-danger btn-simple btn-xs commentDelete' "
				+ "postno='"+ postNo+ "' value='"+ item.postCommentNo+ "'>" 
				+"<i class='fa fa-times'></i></button>";
		}
		html += "</td>";
		html += "</tr>";
	})
	html += "</tbody>";
	html += "</table>";
	html += "<button class='btn commentListAdd' value='" + postNo
	+ "'>댓글더보기</button>";
	html += "</div>";
	return html;
}

// 포스트 이미지 html추가
function postImgAppend(img) {
	var html = "";
	html += "<img src='" + img+ "' style='width: 50%; height:50%'><br>";
	return html;
}