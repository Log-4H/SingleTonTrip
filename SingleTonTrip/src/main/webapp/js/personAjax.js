//댓글 삭제
$(document).on('click', '.commentDelete', function(){
	var postCommentNo = $(this).attr('value');
	var postNo = $(this).attr('postno');
	var divId = "commentList" + postNo;
	var lastCommentRow = $('#'+'lastCommentRow'+postNo).attr('value');
	lastCommentRow = Number(lastCommentRow);
	$.ajax({
		url : "postCommentDelete",
		type : "POST",
		data : {postNo : postNo, postCommentNo : postCommentNo, lastCommentRow : lastCommentRow},
		dataType : "json",
		success : function(data) {
			var postCommentList = data.postCommentList;
			html = postCommentAppend(postNo, postCommentList);
			$("#"+divId).empty();
			$("#"+divId).append(html);
			$("#flag"+postNo).val("open");
		}
	})
});

//댓글 리스트 보기
$(document).on('click', '.commentListBtn', function(){
	var postNo = $(this).attr('value');
	var flag = $("#flag"+postNo).attr('value');
	var divId = "commentList" + postNo;
	var html = ""
	if(flag=='close'){
	$.ajax({
		url : "postCommentList",
		type : "POST",
		data : {postNo : postNo},
		dataType : "json",
		success : function(data) {
			var postCommentList = data.postCommentList;
			html = postCommentAppend(postNo, postCommentList);
			$("#"+divId).empty();
			$("#"+divId).append(html);
			$("#flag"+postNo).val("open");
			}
	})
	}else{
		$("#"+divId).empty();
		$("#flag"+postNo).val("close");
	}
});

//댓글 리스트 추가
$(document).on('click', '.commentListAdd', function(){
	var postNo = $(this).attr('value');
	var lastCommentRow = $('#'+'lastCommentRow'+postNo).attr('value');
	lastCommentRow = Number(lastCommentRow);
	var divId = "commentList" + postNo;
	var html = ""
	$.ajax({
		url : "postCommentList",
		type : "POST",
		data : {postNo : postNo, lastCommentRow: lastCommentRow},
		dataType : "json",
		success : function(data) {
			$('#'+'lastCommentRow'+postNo).val(lastCommentRow+5);
			var postCommentList = data.postCommentList;
			$.each(postCommentList, function(key, item) {
				var postCommentList = data.postCommentList;
				html = postCommentAppend(postNo, postCommentList);
				$("#"+divId).empty();
				$("#"+divId).append(html);
			})
		}
	})
});

//댓글 등록 
$(document).on('click', '.commentAddBtn', function(){
	var postNo = $(this).attr('value');
	var postCommentContent = $("#comment"+postNo).val();
	var divId = "commentList" + postNo;
	var html = "";
	$.ajax({
		url : "postCommentAdd",
		type : "POST",
		data : {postNo : postNo, postCommentContent : postCommentContent},
		dataType : "json",
		success : function(data) {
			var postCommentList = data.postCommentList;
			html = postCommentAppend(postNo, postCommentList);
			$("#"+divId).empty();
			$("#"+divId).append(html);
			}
	})
});


//포스트 등록
$(document).on('click', '#postAddBtn', function(){
	var formData = new FormData($("#postAddForm")[0]);
	$.ajax({
		url : "postAdd",
		type : "POST",
		data : formData,
		dataType : "json",
		contentType: false,
        processData: false,
        cache: false,
		success : function(data) {
			var postList = data.postList;
			html = postAppend(postList);
			$("#postList").empty();
			$("#postList").append(html);
		}
	})
});

//포스트 더보기
$(document).on('click', '#addList', function(){
	var lastPostRow = $('#lastPostRow').attr('value');
	lastPostRow = Number(lastPostRow);
	var html = "";
	$.ajax({
		url : "postList",
		type : "POST",
		data : {lastPostRow : lastPostRow},
		dataType : "json",
		success : function(data) {
			$('#lastPostRow').val(lastPostRow+5);
			var postList = data.postList;
			html = postAppend(postList);
			$("#postList").empty();
			$("#postList").append(html);
		}
	})
});

//포스트 html추가
function postAppend(postList){
	var html = "";
	$.each(postList, function(key, item) {
		html+="<div class='w3-container w3-card-2 w3-white w3-round w3-margin'><br>";
		html+="<span class='w3-right w3-opacity'>"+item.postRegDate+"</span>";
		html+="<h4>"+item.postTitle+"</h4><br>";
		html+="<hr class='w3-clear'>";
		html+="<p>"+item.postContent+"</p>";
		if(item.postImg!=null){
			html+="<div class='w3-row-padding' style='margin:0 -16px'>";
			html+="<div class='w3-half'>";
			html+="<img src='../images/"+item.postImg+"' style='width: 100%' class='w3-margin-bottom'>";
			html+="</div>";
			html+="</div>";
		}
		html+="<hr class='w3-clear'>";
		html+="<button type='button' class='w3-btn w3-theme-d2 w3-margin-bottom commentListBtn' value='"+item.postNo+"''><i class='fa fa-comment'></i>  Comment</button> ";
		html+="<input type='hidden' id='lastCommentRow"+item.postNo+"' value='10'>";
		html+="<input type='hidden' id='flag"+item.postNo+"' value='close'>";
		html+="<div id='commentList"+item.postNo+"'>";
		html+="</div>";
		html+="</div>";
		})
		return html;
}

//댓글 html추가
function postCommentAppend(postNo, postCommentList){
	var html = "";
	html+="<input type='text' id='comment"+postNo+"'>";
	html+="<button type='button' class='commentAddBtn' value='"+postNo+"'>댓글등록</button>";
	html+="<button class='commentListAdd' value='"+postNo+"'>댓글더보기</button>";
	html+="<table border='1'>";
	html+="<thead>";
	html+="<tr>";
	html+="<td>ID</td>";
	html+="<td>Content</td>";
	html+="<td>regDate</td>";
	html+="<td></td>";
	html+="</tr>";
	html+="</thead>";
	html+="<tbody id='tbody"+postNo+"'>";
	$.each(postCommentList, function(key, item) {
		html+="<tr>";
		html+="<td>"+item.memberId+"</td>";
		html+="<td>"+item.postCommentContent+"</td>";
		html+="<td>"+item.postCommentRegDate+"</td>";
		html+="<td><a class='commentDelete' postno='"+postNo+"' value='"+item.postCommentNo+"'><span class='glyphicon glyphicon glyphicon-remove' aria-hidden='true'></span></a></td>";
		html+="</tr>";
	})
	html+="</tbody>";
	html+="</table>";
	return html;
}