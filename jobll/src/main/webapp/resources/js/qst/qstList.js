$(document).ready (function (){
	findData(0,0,0);
});

function findData(prcs_stus, off, page_off){
	$.ajax({
		method : "POST",
		url : "/qstList/listRun",
		data : {prcs_stus : prcs_stus, off : off, page_off : page_off},
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
				str_html += "<td>"+(index+off*10+1)+"</td>";
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
			
			var page_html =  
				"<div class=\"container\">"+
				"<ul class=\"pagination\">";
				if(page_off==0)
					page_html += "<li class=\"disabled\">"; 
				else 
					page_html += "<li>";
				page_html += "<a onclick = \"findData("+prcs_stus+","+(page_off-1)+","+(page_off-5)+")\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>";
				for(i=0; i<5; i++){
					if(i==(off-page_off))
						page_html += "<li class=\"active\">";
					else
						page_html += "<li>";
					page_html+="<a onclick = \"findData("+prcs_stus+","+(page_off+i)+","+(page_off)+")\">"+(page_off+i+1)+"</a></li>";
				}	
				page_html +="<li>"+ 
					"<a onclick = \"findData("+prcs_stus+","+(page_off+5)+","+(page_off+5)+")\">" + 
					"<span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>"+
			  	"</ul>"+
			  	"</div>";
				$("#pagination").html(page_html);
		},
		error: function(){alert("ERROR");}
	});
}


function readQstInfo(idx){
	
	var str_html = "<input type ='hidden' name = 'qst_idx' value = '"+idx+"'>";
	
	$(".qstlist").html(str_html);
	
	$("#qstInfo").submit();

}