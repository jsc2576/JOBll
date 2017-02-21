$(document).ready (function (){
	findPrcs(0);
	pagination_mv();

});

var page_nm = 0; // 현재 보이는 페이지네이션의 페이지 
var list_nm = 5; // 하나의 페이지네이션에 보여지는 개수
var prcs_stus_nm = 0; // 현재 보여지고 있는 process stus 번호
var data_limit = 10; // 하나의 페이지에 보여지는 데이터 수

//public method 

function findPrcs(prcs_stus){
	prcs_stus_nm = prcs_stus;
	findData(prcs_stus_nm, 0, data_limit);
}

function findpage(page){
	findData(prcs_stus_nm, list_nm * page, data_limit);
}


function pagination_next(){
	page_nm++;
	pagination_mv();
}

function pagination_prev(){
	if(page_nm > 0)
		page_nm--;
	
	pagination_mv();
}


// private 함수

// 페이네이션의 페이지가 이동할 때마다 호출하는 함수
function pagination_mv(){
	var str_html = "";
	if(page_nm<=0){
		str_html += "<li class='disabled'>";
	}
	else{
		str_html += "<li>";
	}
	
	str_html += "<a onclick='pagination_prev()'><span class='glyphicon glyphicon-chevron-left'></span></a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 1) + ")'>" + (page_nm * list_nm + 1) + "</a></li>"
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 2) + ")'>" + (page_nm * list_nm + 2) + "</a></li>"
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 3) + ")'>" + (page_nm * list_nm + 3) + "</a></li>"
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 4) + ")'>" + (page_nm * list_nm + 4) + "</a></li>"
	str_html += "<li><a onclick\='findpage(" + (page_nm * list_nm + 5) + ")'>" + (page_nm * list_nm + 5) + "</a></li>"
	
	str_html += "<li><a onclick='pagination_next()'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
	$("#page_nm").html(str_html);
	
}


// 데이터를 찾는 함수
function findData(prcs_stus, atcl_offset, atcl_limit){

	$.ajax({
		method : "POST",
		url : "/atcl/find",
		data : {prcs_stus : prcs_stus, atcl_offset : atcl_offset, atcl_limit : atcl_limit},
		success: function(list){
			
			var str_html = "<table border='1' style='width: 100%'><tr><th>접수번호</th><th>제목</th><th>기관명</th><th>등록일</th><th>처리상태</th></tr>";
			
			$.each(list, function(index, value){
				str_html += "<tr><a href='#'>";
			
				str_html += "<td>"+value.atcl_idx+"</td>";
				str_html += "<td>"+value.atcl_sbjt+"</td>";
				str_html += "<td>"+value.cmpny_nm+"</td>";
				str_html += "<td>"+value.reg_date+"</td>";
				str_html += "<td>"+value.prcs_stus+"</td>";
			
				str_html += "</a></tr>";
				
			});
			
			str_html += "</table>"
			$("#data_list").html(str_html);		
		},
		error: function(){alert("ERROR")}
	});
}


function findDataCount(){
	$.ajax({
		method : "POST",
		url : "/atcl/find.json",
		data : {prcs_stus : prcs_stus, atcl_offset : atcl_offset, atcl_limit : atcl_limit},
		success: function(data){
			
			
		}
	});
}

