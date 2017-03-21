$(document).on('click', '.searchPersonPaging', function() {
	var personCurrentPage = $(this).attr('value');
	var value = $("#searchValue").val();
	var pos=$("#personResult").position().top;
	$("html, body").animate({scrollTop:pos},'speed');
	$.ajax({
		url : "searchPersonList",
		type : "POST",
		data : {
			personCurrentPage : personCurrentPage, value : value
		},
		dataType : "json",
		success : function(data) {
			var bodyHtml = "";
			var pagingHtml = "";
			var personMap = data.personMap;
			bodyHtml = searchPersonListHtml(personMap.searchPersonList);
			pagingHtml = searchPagingHtml("searchPersonPaging",personMap.startPage, personMap.pageSize, personMap.endPage, personMap.lastPage);
			$("#searchPersonList").html(bodyHtml);
			$("#searchPersonPaging").html(pagingHtml);
		}
	})
});

$(document).on('click', '.searchCompanyPaging', function() {
	var companyCurrentPage = $(this).attr('value');
	var value = $("#searchValue").val();
	var pos=$("#companyResult").position().top;
	$("html, body").animate({scrollTop:pos},'speed');
	$.ajax({
		url : "searchCompanyList",
		type : "POST",
		data : {
			companyCurrentPage : companyCurrentPage, value : value
		},
		dataType : "json",
		success : function(data) {
			var bodyHtml = "";
			var pagingHtml = "";
			var companyMap = data.companyMap;
			bodyHtml = searchCompanyListHtml(companyMap.searchCompanyList);
			pagingHtml = searchPagingHtml("searchCompanyPaging", companyMap.startPage, companyMap.pageSize, companyMap.endPage, companyMap.lastPage);
			$("#searchCompanyList").html(bodyHtml);
			$("#searchCompanyPaging").html(pagingHtml);
		}
	})
});
$(document).on('click', '.searchTripPaging', function() {
	var tripCurrentPage = $(this).attr('value');
	var value = $("#searchValue").val();
	var pos=$("#tripResult").position().top;
	$("html, body").animate({scrollTop:pos},'speed');
	$.ajax({
		url : "searchTripList",
		type : "POST",
		data : {
			tripCurrentPage : tripCurrentPage, value : value
		},
		dataType : "json",
		success : function(data) {
			var bodyHtml = "";
			var pagingHtml = "";
			var tripMap = data.tripMap;
			bodyHtml = searchTripListHtml(tripMap.searchTripList);
			pagingHtml = searchPagingHtml("searchTripPaging",tripMap.startPage, tripMap.pageSize, tripMap.endPage, tripMap.lastPage);
			$("#searchTripList").html(bodyHtml);
			$("#searchTripPaging").html(pagingHtml);
		}
	})
});


function searchPersonListHtml(searchPersonList) {
	var html = "";
	$.each(searchPersonList,function(key, item) {
		html+="<tr>";
		html+="<td>";
		html+="<img src='./images/"+item.memberImg+"' class='img-rounded' width='100' height='100'>";
		html+="</td>";
		html+="<td><a href='pageMain?pageId="+item.memberId+"'>"+item.memberId+"</a></td>";
		html+="<td>"+item.memberNm+"</td>";
		html+="<td>"+item.personGender+"</td>";
		html+="<td>"+item.personBirth+"</td>";
		html+="</tr>";
	})
	return html;
}
function searchCompanyListHtml(searchCompanyList) {
	var html = "";
	$.each(searchCompanyList,function(key, item) {
		html+="<tr>";
		html+="<td>";
		html+="<img src='./images/"+item.memberImg+"'  class='img-rounded' width='100' height='100'>";
		html+="</td>";
		html+="<td><a href='pageMain?pageId="+item.memberId+"'>"+item.memberId+"</a></td>";
		html+="<td>"+item.companyNm+"</td>";
		html+="<td>"+item.companyAddress+"</td>";
		html+="<td>"+item.memberPhone+"</td>";
		html+="<td>"+item.companyTypeNm+"</td>";
		html+="</tr>";
	})
	return html;
}
function searchTripListHtml(searchTripList) {
	var html = "";
	$.each(searchTripList,function(key, item) {
		html+="<tr>";
		html+="<td>"+item.tripThemeNm+"</td>";
		html+="<td><a href='pageMain?pageId="+item.personId+"'>"+item.tripTitle+"</a></td>";
		html+="<td>";
		if(item.regionDo == item.regionSi){
			html+=item.regionDo;
		}else{
			html+=item.regionDo+" "+item.regionSi;
		}
		html+="</td>";
		html+="<td>"+item.tripStartDate+" ~ "+item.tripEndDate+"</td>";
		html+="</tr>";
	})
	return html;
}


function searchPagingHtml(classNm, startPage, pageSize, endPage, lastPage){
	var html ="";
	if(startPage>1){
		html+= "<a href='javascript:void(0)' class='"+classNm+"' value='"+Number(startPage-pageSize)+"'>prev</a>";
	}
	for(var i=startPage; i<=endPage; i++){
		html+= "<a href='javascript:void(0)' class='"+classNm+"' value='"+i+"'>"+i+"</a>";
	}
	if(endPage != lastPage){
		html+= "<a href='javascript:void(0)' class='"+classNm+"' value='"+Number(startPage+pageSize)+"'>next</a>";
	}
	return html;
}