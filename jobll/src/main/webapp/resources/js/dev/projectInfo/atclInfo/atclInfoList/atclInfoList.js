$(document).ready (function (){
	viewIssue(0,0);

});

function viewIssue(off,page_off) {
	var prjt_idx = $("#prjt_idx").val();
	
	$.ajax({
		method : "POST",
		url : "/issue/search/read",
		data : {"prjt_idx" : prjt_idx, off : off, page_off : page_off},
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
		
			$("#list").html(str_html);
			
			var page_html =  
				"<div class=\"container\">"+
				"<ul class=\"pagination\">";
				if(page_off==0)
					page_html += "<li class=\"disabled\">"; 
				else 
					page_html += "<li>";
				page_html += "<a onclick = \"viewIssue("+(page_off-1)+","+(page_off-5)+")\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>";
				for(i=0; i<5; i++){
					if(i==(off-page_off))
						page_html += "<li class=\"active\">";
					else
						page_html += "<li>";
					page_html+="<a onclick = \"viewIssue("+(page_off+i)+","+(page_off)+")\">"+(page_off+i+1)+"</a></li>";
				}
				page_html +="<li>"+ 
					"<a onclick = \"viewIssue("+(page_off+5)+","+(page_off+5)+")\">" + 
					"<span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>"+
			  	"</ul>"+
			  	"</div>";
				$("#pagination").html(page_html);
		},
		error: function(){}
	});
}


//게시글을 클릭할때 form 전송 data(atcl_idx)를 생성해주는 함수
function atclInfoGetIdx(idx) {
	
	var str_html = "<input type = 'hidden' name = 'atcl_idx' id = 'atcl_idx' value = "+idx+">";
	
	$("#getIdx").append(str_html);
	$("#issueRead").submit();
}
