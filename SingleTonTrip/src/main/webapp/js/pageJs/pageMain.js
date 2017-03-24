// 프로필 요청
$(document).ready(function() {
	console.log($("#sessionId").val());
	if ($("#pageLevel").val() == 2) {
		companyDetail();
	} else if ($("#pageLevel").val() == 3) {
		personDetail();
	}
	;

	// 개인회원 프로필
	function personDetail() {
		$.ajax({
			url : "personDetail",
			type : "POST",
			dataType : "json",
			success : function(data) {
				var html = "";
				var person = data.person;
				var profileImg = "";
				if (person.memberImg != null) {
					profileImg = "./images/" + person.memberImg;
				} else if (person.personGender == "F") {
					profileImg = "./images/Female.png";
				} else {
					profileImg = "./images/Male.png";
				}
				$("#profileImg").attr("src", profileImg);
				$("#profileImg").attr("src", profileImg);
				html += "<h3 class='title'>"+ person.memberNm + "</h3>";
				html += rate(person.memberEvaluationRating * 10)+" <strong>"+person.memberEvaluationRating+"</strong>";
				html += "<h6>" + person.personBirth + "</h6>";
				html += "<h6>" + person.personGender + "</h6>";
				html += "<h6>" + person.memberEmail + "</h6>";
				html += "<h6>" + person.tripStateNm + "</h6>";
				

				$("#profileContent").html(html);
			}
		})
	}
	;
	// 업체회원프로필
	function companyDetail() {
		$.ajax({
			url : "companyDetail",
			type : "POST",
			dataType : "json",
			success : function(data) {
				var html = "";
				var company = data.company;
				var profileImg = "";
				if (company.memberImg != null) {
					profileImg = "./images/" + company.memberImg;
				} else {
					profileImg = "./images/Company.jpg";
				}
				$("#profileImg").attr("src", profileImg);
				$("#profileImg").attr("src", profileImg);
				html += "<h3 class='title'>" + company.companyNm +"</h3>";
				html += rate(company.memberEvaluationRating * 10) +" <strong>"+company.memberEvaluationRating+"</strong>";
				html += "<h6>" + company.memberNm + "</h6>";
				html += "<h6>" + company.companyTypeNm + "</h6>";
				html += "<h6>" + company.memberPhone + "</h6>";
				html += "<h6>" + company.memberEmail + "</h6>";

				$("#profileContent").html(html);
			}
		})
	};
});
//페이지 친구 체크
$(document).ready(
		function() {
			var sessionId = $('#sessionId').val();
			$.ajax({
				url : "pageFriendCheck",
				type : "GET",
				dataType : "json",
				success : function(data) {
					var pageFriendCheck = data.pageFriendCheck;
					if (pageFriendCheck == null
							&& $('#pageId').val() != $('#sessionId').val()) {
						$('#friendApproveBtn').show();
					}
				}
			})
		});
//페이지 친구 추가
$(document).on('click', '.pageFriendAddBtn', function() {
	$.ajax({
		url : "pageFriendAdd",
		type : "GET",
		success : function(data) {
			console.log("friend add success");
			$('#friendApproveBtn').hide();
		}
	})
});
/*평점 토탈 보여주기
$(document).ready(function() {
	$.ajax({
		url : "evaluationRating",
		type : "GET",
		data : {
			pageLevel:pageLevel
		},
		dataType : "json",
		success : function(data) {
			var evaluationList = data.evaluationList;
			html = evaluationListHtml(evaluationList, pageLevel);
			$("#evaluationList").html(html);
		}
	})
});
*/

/*
// 광고 불러온다
$(document).ready(function() {
	console.log("-----");
	$.ajax({
		url : "serviceAdList",
		type : "GET",
		dataType : "json",
		success : function(data) {
			console.log("sss?");
			console.log(data);
			var homeAdList = data.homeAdList;
			var html="";
			$.each(homeAdList,function(key, item) {
				
				html += "<p>여기 어떠세요?</p>";
				// 광고신청할 때 URL 입력했으면 그 주소로 가고 입력 안했으면 광고 신청한 사람의 페이지로 이동
				if(item.adPageAddress == null || item.adPageAddress == ""){
					html+="<a href='pageMain?pageId="+item.companyId+"'>";
				} else {
					html+="<a href='"+item.adPageAddress+"'>";
				}
				html+="<img src='./images/"+item.adImg+"' alt='' style='width:100%; max-height:150px;'></a>";
			});
			$("#adList").html(html);
			
		}
	})
});
*/