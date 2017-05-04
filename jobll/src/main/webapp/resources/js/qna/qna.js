$(document).ready(function(){
	pagination_mv();		
});

var page_nm = 0; // 현재 보이는 페이지네이션의 페이지 
var list_nm = 10; // 리스트 한번에 보여지는 개수

//페이네이션의 페이지가 이동할 때마다 호출하는 함수
function pagination_mv(){
	var str_html = "";
	if(page_nm<=0){
		str_html += "<li class='disabled'>";
	}
	else{
		str_html += "<li>";
	}
	
	str_html += "<a onclick='pagination_prev()'><span class='glyphicon glyphicon-chevron-left'></span></a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 1) + ")'>" + (page_nm * list_nm + 1) + "</a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 2) + ")'>" + (page_nm * list_nm + 2) + "</a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 3) + ")'>" + (page_nm * list_nm + 3) + "</a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 4) + ")'>" + (page_nm * list_nm + 4) + "</a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 5) + ")'>" + (page_nm * list_nm + 5) + "</a></li>";
	
	str_html += "<li><a onclick='pagination_next()'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
	$("#page_nm").html(str_html);
	
}

function findpage(offset){
	findData(offset, list_nm);
}


//데이터를 찾는 함수
function findData(offset, limit){
	$.ajax({
		method : "POST", 
		url : "/qst/read",
		data : {offset : offset, limit : limit},
		success : function(list){
			alert("success");
		},
		error : function(){
			alert("fail");
		}
	});
}
