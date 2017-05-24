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
	findData(prcs_stus_nm, 0, 0);
}

function findpage(page){
	findData(prcs_stus_nm, 0, 0);
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
	var prjt_idx = $(".prjt_idx").val();
	$.ajax({
		method : "POST",
		url : "/projectSupply/listRun",
		data : { prjt_idx : prjt_idx, prcs_stus : prcs_stus, atcl_offset : atcl_offset, atcl_limit : atcl_limit},
		success: function(list){
		//	var str_html = "<form id='projectSupplyReadOne' action = '/prjectSupply/readOne' method='post'>";
			var count=0;
			var str_html = "<div class='row'><div class='col-lg-12'><h1 class='page-header'>프로젝트 지원</h1></div> </div><div class='row'><div class='col-lg-12'><div class='panel panel-default'><div class='panel-heading'>프로젝트 지원 목록</div><div class='panel-body'>";
				str_html += "<table width='80%' class='table table-striped table-bordered table-hover' id='supplyList'>";
				str_html += "<thead><tr>";
				str_html += "<th>No.</th>";
				str_html += "<th>내용</th>";
				str_html += "<th>해당인원</th>";
				str_html += "<th>시작날짜</th>";
				str_html += "<th>종료날짜</th>";
				str_html += "<th>요청 상태</th>";
				str_html += "<th>지원 요청자</th>";
				str_html += "</tr></thead>";			
				str_html += "<tbody>";
			$.each(list, function(index, value){
				count++;
				str_html += "<tr onclick = 'readProjectSupply("+value.prjt_sup_list_idx+")'>";
				str_html += "<td>"+count+"</td>";
				str_html += "<td>"+value.sup_conts+"</td>";
				str_html += "<td>"+value.sup_person+"</td>";
				str_html += "<td>"+value.sup_strt_date+"</td>";
				str_html += "<td>"+value.sup_end_date+"</td>";
				if(value.appr_yn == 1){
					str_html += "<td>"+"승인완료"+"</td>";
				}
				else if(value.appr_yn == 2){
					str_html += "<td>"+"승인대기"+"</td>";
				}
				else if(value.appr_yn == 1){
					str_html += "<td>"+"승인거부"+"</td>";
				}
				else{
					str_html += "<td>"+"오류"+"</td>";
				}
				str_html += "<td>"+value.usr_id+"</td>";
				str_html += "</a></tr>";				
			});
			str_html += "</tbody>";
			str_html += "</table>";
			str_html += "<div id = 'getIdx'></div>";
			str_html += "</div></div></div></div>"
	//		str_html += "</form>";
			$(".list").html(str_html);		
		},
		error: function(){alert("ERROR");}
	});
}


function readProjectSupply(idx){
	
	var str_html = "<input type ='hidden' name = 'prjt_idx' value = '"+idx+"'>";
	
	$(".list").html(str_html);
	
	$("#projectSupply").submit();

}