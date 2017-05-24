$(document).ready (function (){
	writeQst();
	GetMyQstList();

});

function writeQst(){
	$.ajax({
		method : "POST",
		url : "/qstList/listRun",
		data : {},
		success: function(list){

			var str_html = "<form id='qstRead' action = '/qstList/read' method='post'>";
			$.each(list, function(index, value){
			});
		str_html += "</form>";
		$(".Writeqst").html(str_html);		
	},
	error: function(){alert("ERROR");}
	});
}

function GetMyQstList(){
	$.ajax({
		method : "POST",
		url : "/qstList/GetMyQstList",
		data : {},
		success: function(list){
			var str_html = "<div class='row'>" +
	            "<div class='panel-body'>" +
	                "<table width='80%' class='prjt-table table table-striped table-bordered table-hover' id='dataTables-example'>" +
	                    "<thead>" +
	                        "<tr>" +
	                        "<th>No.</th>" +
	        				"<th>제목</th>" +
	        				"<th>등록날짜</th>" +
	        				"<th>문의상태</th>" +
	                        "</tr>" +
	                    "</thead>" +
	                    "<tbody>";
							for(var j = 0; j < list.length; j++)
							{
								str_html += "<tr class="+(j+1)+">" +
											"<td>"+(j+1)+"</td>" +
											"<td onclick = 'qstView("+list[j].qst_idx+")'>"+list[j].qst_sbjt+"</td>" +
											"<th>"+list[j].reg_date+"</th>";
											if(list[j].qst_stus == 1){
												str_html += "<td>"+"미답변"+"</td>";
											}
											else if(list[j].qst_stus == 2){
												str_html += "<td>"+"답변완료"+"</td>";
											}
											else if(list[j].qst_stus == 3){
												str_html += "<td>"+"비공개"+"</td>";
											}
											str_html += "</tr>";
							}
							/*
							var page_html =  
								"<div class=\"container\">"+
								"<ul class=\"pagination\">";
						
								if(page_off==0)
									page_html += "<li class=\"disabled\">"; 
								else 
									page_html += "<li>";
								page_html += "<a onclick = \"GetHstyTable("+prjt_idx+","+(page_off-1)+","+(page_off-5)+")\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a></li>";
								for(i=0; i<5; i++){
									if(i==(off-page_off))
										page_html += "<li class=\"active\">";
									else
										page_html += "<li>";
									page_html+="<a onclick = \"GetHstyTable("+prjt_idx+","+(page_off+i)+","+(page_off)+")\">"+(page_off+i+1)+"</a></li>";
								}
								page_html +="<li>"+ 
									"<a onclick = \"GetHstyTable("+prjt_idx+","+(page_off+5)+","+(page_off+5)+")\">" + 
									"<span class=\"glyphicon glyphicon-chevron-right\"></span></a></li>"+
							  	"</ul>"+
							  	"</div>";
								$("#pagination").html(page_html);*/
				str_html += "</tbody>" +
	                "</table>" +
	            "</div>" +
				
				$(".myQstList").html(str_html);	
		//}
	},
	error: function(){alert("ERROR");}
	});
}

function qstView(qst_idx)
{
	var qst_idx_tag = "<input type = 'hidden' name = 'qst_idx' value = '"+qst_idx+"'>";
	$(".qst-data").append(qst_idx_tag);
	$(".qst-form").attr('action', "/qstList/readOne");
	$(".qst-form").submit();
}