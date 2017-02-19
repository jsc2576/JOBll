$(document).ready (function (){
	findAll();
});

<!-- find data list -->

function findAll(){
	$.ajax({
		method : "GET",
		url : "/atcl/all",
		success: findSuccess(list)
	});
}

function findRcvWait(){
	$.ajax({
		method : "GET",
		url : "/atcl/rcv/wait",
		success : findSuccess(list),
		error : Error()
	});
}

function findRcvCmpt(){
	$.ajax({
		method : "GET",
		url : "/atcl/rcv/cmpt",
		success : findSuccess(list),
		error : Error()
	});
}

function findPrcsWait(){
	$.ajax({
		method : "GET",
		url : "/atcl/prcs/wait",
		success : findSuccess(list),
		error : Error()
	});
}

function findPrcsCmpt(){
	$.ajax({
		method : "GET",
		url : "/atcl/prcs/cmpt",
		success : findSuccess(list),
		error : Error()
	});
}

function Error(){
	
}

function findSuccess(list){
	for(var total_count=0; total_count<list.length(); total_count++){
		str_html = "<tr>";
		
		for(var i=0; i<list[i].length(); i++){
			str_html += "<td>"+list[i].atcl_idx+"</td>";
			str_html += "<td>"+list[i].atcl_sbjt+"</td>";
			str_html += "<td>"+list[i].cmpny_nm+"</td>";
			str_html += "<td>"+list[i].reg_date+"</td>";
			str_html += "<td>"+list[i].prcs_stus+"</td>";
			
		}
		
		str_html += "</tr>";
		
		$("#data_list").html(str_html);
	}
}

var page_nm = 0;
var list_nm = 5;

function pagination_next(){
	page_nm++;
	pagination_mv();
}

function pagination_prev(){
	if(page_nm > 0)
		page_nm--;
	
	pagination_mv();
}

pagination_mv();
function pagination_mv(){
	alert("pagination");
	var str_html = "";
	if(page_nm<=0){
		str_html += "<li class='disabled'>";
	}
	else{
		str_html += "<li>";
	}
	
	str_html += "<a class='glyphicon glyphicon-chevron-left' onclick='pagination_prev()'></a></li>";
	str_html += "<li><a onclick='pagination_click(" + (page_nm * list_nm + 1) + ")'>" + (page_nm * list_nm + 1) + "</a></li>"
	str_html += "<li><a onclick='pagination_click(" + (page_nm * list_nm + 2) + ")'>" + (page_nm * list_nm + 2) + "</a></li>"
	str_html += "<li><a onclick='pagination_click(" + (page_nm * list_nm + 3) + ")'>" + (page_nm * list_nm + 3) + "</a></li>"
	str_html += "<li><a onclick='pagination_click(" + (page_nm * list_nm + 4) + ")'>" + (page_nm * list_nm + 4) + "</a></li>"
	str_html += "<li><a onclick='pagination_click(" + (page_nm * list_nm + 5) + ")'>" + (page_nm * list_nm + 5) + "</a></li>"
	
	str_html += "<li><a class='glyphicon glyphicon-chevron-right' onclick='pagination_next()'></a></li>";
	alert(str_html);
	$("#page_nm").html(str_html);
	
}