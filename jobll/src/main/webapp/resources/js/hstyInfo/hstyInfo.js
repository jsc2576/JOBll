$(document).ready (function (){
	findPrcs(0);
	pagination_mv();
});
var page_nm = 0; // 현재 보이는 페이지네이션의 페이지 
var list_nm = 5; // 하나의 페이지네이션에 보여지는 개수
var prcs_stus_nm = 0; // 현재 보여지고 있는 process stus 번호
var data_limit = 10; // 하나의 페이지에 보여지는 데이터 수

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
function findData(prcs_stus, atcl_offset, atcl_limit){
	$.ajax({
		method : "POST",
		url : "/hstyInfo/listRun",
		data : {prcs_stus : prcs_stus, atcl_offset : atcl_offset, atcl_limit : atcl_limit},
		success: function(list){
			var str_html = "<form id='hstyInfoReadOne' action = '/hstyInfo/readOne' method='post'>";
				str_html += "<table class ='table'>";
				str_html += "<thead><tr>";
				str_html += "<th>히스토리번호</th>";
				str_html += "<th>사용자아이디</th>";
				str_html += "<th>프로젝트인덱스</th>";
				str_html += "<th>히스토리날짜</th>";
				str_html += "<th>히스토리시간</th>";
				str_html += "<th>히스토리내용</th>";
				str_html += "<th>히스토리종류</th>";
				str_html += "</tr></thead>";			
				str_html += "<tbody>";
			$.each(list, function(index, value){
				str_html += "<tr onclick = 'readHstyInfo("+value.hsty_idx+")'>";
				str_html += "<td>"+value.hsty_idx+"</td>";
				str_html += "<td>"+value.usr_id+"</td>";
				str_html += "<td>"+value.prjt_idx+"</td>";
				str_html += "<td>"+value.hsty_date+"</td>";
				str_html += "<td>"+value.atcl_conts+"</td>";
				str_html += "<td>"+value.hsty_conts+"</td>";
				str_html += "<td>"+value.hsty_typ+"</td>";
				str_html += "</a></tr>";			
			});
			str_html += "</tbody>";
			str_html += "</table>";
			str_html += "<div id = 'getIdx'></div>";
			str_html += "</form>";
			$(".list").html(str_html);		
		},
		error: function(){alert("ERROR");}
	});
}


function readHstyInfo(idx){
	
	var str_html = "<input type ='hidden' name = 'hsty_idx' value = '"+idx+"'>";
	
	$(".list").html(str_html);
	
	$("#hstyInfo").submit();

}