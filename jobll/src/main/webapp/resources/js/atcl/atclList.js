$(document).ready (function (){
	findData(0);
});

function findData(prcs_stus, atcl_offset, atcl_limit){
	$.ajax({
		method : "POST",
		url : "/atcl/find.json",
		data : {prcs_stus : prcs_stus},
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




var page_nm = 0;
var list_nm = 5;
var prcs_stus = 0;

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
	var str_html = "";
	if(page_nm<=0){
		str_html += "<li class='disabled'>";
	}
	else{
		str_html += "<li>";
	}
	
	str_html += "<a onclick='pagination_prev()'></a></li>";
	str_html += "<li><a href='findData(" + (page_nm * list_nm + 1) + ")'>" + (page_nm * list_nm + 1) + "</a></li>"
	str_html += "<li><a href='findData(" + (page_nm * list_nm + 2) + ")'>" + (page_nm * list_nm + 2) + "</a></li>"
	str_html += "<li><a href='findData(" + (page_nm * list_nm + 3) + ")'>" + (page_nm * list_nm + 3) + "</a></li>"
	str_html += "<li><a href='findData(" + (page_nm * list_nm + 4) + ")'>" + (page_nm * list_nm + 4) + "</a></li>"
	str_html += "<li><a href='findData(" + (page_nm * list_nm + 5) + ")'>" + (page_nm * list_nm + 5) + "</a></li>"
	
	str_html += "<li><a onclick='pagination_next()'></a></li>";
	$("#page_nm").html(str_html);
	
}
