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
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 1) + ")'>" + (page_nm * list_nm + 1) + "</a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 2) + ")'>" + (page_nm * list_nm + 2) + "</a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 3) + ")'>" + (page_nm * list_nm + 3) + "</a></li>";
	str_html += "<li><a onclick='findpage(" + (page_nm * list_nm + 4) + ")'>" + (page_nm * list_nm + 4) + "</a></li>";
	str_html += "<li><a onclick\='findpage(" + (page_nm * list_nm + 5) + ")'>" + (page_nm * list_nm + 5) + "</a></li>";
	
	str_html += "<li><a onclick='pagination_next()'><span class='glyphicon glyphicon-chevron-right'></span></a></li>";
	$("#page_nm").html(str_html);
	
}


// 데이터를 찾는 함수
function findData(prcs_stus, atcl_offset, atcl_limit){

	$.ajax({
		method : "POST",
		url : "/atclInfo/listRun",
		data : {prcs_stus : prcs_stus, atcl_offset : atcl_offset, atcl_limit : atcl_limit},
		success: function(list){

			var str_html = "<form id='issueRead' action = '/issue/check/read' method='post'>";
			str_html += "<table class = 'table'>";
			str_html += "<thead><tr>";
			str_html += "<th class = 'tb-No'>No.</th>";
			str_html += "<th class = 'tb-sbjt'>제목</th>";
			str_html += "<th class = 'tb-id'>작성자</th>";
			str_html += "<th class = 'tb-reg-date'>등록일</th>";
			str_html += "<th class = 'tb-atcl-typ'>유형</th>";
			str_html += "</tr></thead>";
		
			str_html += "<tbody>";
			$.each(list, function(index, value){
				str_html += "<tr onclick = 'atclInfoGetIdx("+value.atcl_idx+")'>";
				str_html += "<td class = 'tb-No'>"+index+"</td>";
				str_html += "<td class = 'tb-sbjt'>"+value.atcl_sbjt+"</td>";
				str_html += "<td class = 'tb-id'>"+value.usr_id+"</td>";
				str_html += "<td class = 'tb-reg-date'>"+value.reg_date+"</td>";
				if(value.atcl_typ == 1)
					str_html += "<th class = 'tb-atcl-typ'>진행중</th>";
				else if(value.atcl_typ == 2)
					str_html += "<th class = 'tb-atcl-typ'>진행 완료</th>";
				else if(value.atcl_typ == 3)
					str_html += "<th class = 'tb-atcl-typ'>진행 중단</th>";
				else if(value.atcl_typ == 4)
					str_html += "<th class = 'tb-atcl-typ'>진행 초과</th>";
				else if(value.atcl_typ == 5)
					str_html += "<th class = 'tb-atcl-typ'>협의중</th>";
				str_html += "</a></tr>";
				
			});
			str_html += "</tbody>";
			str_html += "</table>";
			str_html += "<div id = 'getIdx'></div>";
			str_html += "</form>";

			$("#data_list").html(str_html);		
		},
		error: function(){alert("ERROR");}
	});
}
//게시글을 클릭할때 form 전송 data(atcl_idx)를 생성해주는 함수
function atclInfoGetIdx(idx) {
	
	var str_html = "<input type = 'hidden' name = 'atcl_idx' id = 'atcl_idx' value = "+idx+">";
	
	$("#getIdx").append(str_html);
	$("#atclInfoReadOne").submit();
}

//게시판의 페이지네이션에서 페이지가 존재하는지 아닌지 체크하는 함수
function findatclListCount(num, str_html){
	
}

