$(document).on('click', '.commentAddBtn', function(){
	var id = $(this).attr('value');
	var formId = "commentAddForm" + id;
	var divId = "commentList" + id;
	var html = ""
	$.ajax({
		url : "postCommentAdd",
		type : "POST",
		data : $("#"+formId).serialize(),
		dataType : "json",
		success : function(data) {
			console.log("success");
			var commentList = data.commentList;
			$.each(commentList, function(key, item) {
					html+=item.memberId +", "+ item.postCommentContent +", "+ item.postCommentRegDate + "<br>";
			})
			$("#"+divId).empty();
			$("#"+divId).append(html);
			}
	})
});


$(document).on('click', '#postAddBtn', function(){
	var formData = new FormData($("#postAddForm")[0]);
	var html = ""
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
			var postCommentList = data.postCommentList;
			html = postAppend(postList, postCommentList);
			$("#postList").empty();
			$("#postList").append(html);
		}
	})
});

$(document).on('click', '#addList', function(){
	var beginRow = $('#beginRow').attr('value');
	beginRow = Number(beginRow);
	var html = ""
	$.ajax({
		url : "postAddList",
		type : "POST",
		data : {beginRow : beginRow},
		dataType : "json",
		success : function(data) {
			$('#beginRow').val(beginRow+5);
			var postList = data.postList;
			var postCommentList = data.postCommentList;
			html = postAppend(postList, postCommentList);
			$("#scrollPost").append(html);
		}
	})
});
function postAppend(postList, postCommentList){
	var html = "";
	$.each(postList, function(key, item) {
		var postNo = item.postNo;
		html+="<div class='w3-container w3-card-2 w3-white w3-round w3-margin'><br>";
		html+="<span class='w3-right w3-opacity'>"+item.postRegDate+"</span>";
		html+="<h4>"+item.postTitle+"</h4><br>";
		html+="<hr class='w3-clear'>";
		html+="<p>"+item.postContent+"</p>";
		if(item.postImg!=null){
			var postImg = "../images/" + item.postImg;
			html+="<div class='w3-row-padding' style='margin:0 -16px'>";
			html+="<div class='w3-half'>";
			html+="<img src='"+postImg+"' style='width: 100%' class='w3-margin-bottom'>";
			html+="</div>";
			html+="</div>";
		}
		html+="<hr class='w3-clear'>";
		html+="<form id='commentAddForm"+postNo+"'>";
		console.log(postNo);
		html+="<input type='hidden' name='postNo' value='"+postNo+"'>"
		html+="<input type='text' name='postCommentContent' class='w3-btn w3-margin-bottom' placeholder='input comment'>";
		html+="<button type='button' class='w3-btn w3-theme-d2 w3-margin-bottom commentAddBtn' value='"+postNo+"''><i class='fa fa-comment'></i>  Comment</button> ";
		html+="</form>";
		html+="<div id='commentList"+postNo+"'>";
		$.each(postCommentList, function(key, item) {
			if(postNo==item.postNo){
				html+=item.memberId +", "+ item.postCommentContent +", "+  item.postCommentRegDate + "<br>";
			}
		})
		html+="</div>";
		html+="</div>";
		})
		return html;
}