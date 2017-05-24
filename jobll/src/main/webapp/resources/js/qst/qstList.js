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
		url : "/qstList/listRun",
		data : {prcs_stus : prcs_stus, atcl_offset : atcl_offset, atcl_limit : atcl_limit},
		success: function(list){
	//		var str_html = "<form id='QstInfo' action = '/qstList/read' method='post'>";
			var	str_html = "<div class='row'><div class='col-lg-12'><h1 class='page-header'>문의 관리</h1></div> </div><div class='row'><div class='col-lg-12'><div class='panel panel-default'><div class='panel-heading'>문의 목록</div><div class='panel-body'>";
				str_html += "<table width='80%' class='table table-striped table-bordered table-hover' id='qstList'>";
				str_html += "<thead><tr>";
				str_html += "<th>No.</th>";
				str_html += "<th>제목</th>";
				str_html += "<th>내용</th>";
				str_html += "<th>등록날짜</th>";
				str_html += "<th>문의자</th>";
				str_html += "<th>문의상태</th>";
				str_html += "</tr></thead>";			
				str_html += "<tbody>";
			$.each(list, function(index, value){
				str_html += "<tr onclick = 'readQstInfo("+value.qst_idx+")'>";
				str_html += "<td>"+index+"</td>";
				str_html += "<td>"+value.qst_sbjt+"</td>";
				str_html += "<td>"+value.qst_conts+"</td>";
				str_html += "<td>"+value.reg_date+"</td>";
				str_html += "<td>"+value.usr_id+"</td>";
				if(value.qst_stus == 1){
					str_html += "<td>"+"미답변"+"</td>";
				}
				else if(value.qst_stus == 2){
					str_html += "<td>"+"답변완료"+"</td>";
				}
				else if(value.qst_stus == 3){
					str_html += "<td>"+"비공개"+"</td>";
				}
				str_html += "</a></tr>";				
			});
			
			str_html += "</tbody>";
			str_html += "</table>";
			str_html += "</div></div></div></div>"
	//		str_html += "</form>";
			$(".qstlist").html(str_html);		
		},
		error: function(){alert("ERROR");}
	});
}


function readQstInfo(idx){
	
	var str_html = "<input type ='hidden' name = 'qst_idx' value = '"+idx+"'>";
	
	$(".qstlist").html(str_html);
	
	$("#qstInfo").submit();

}