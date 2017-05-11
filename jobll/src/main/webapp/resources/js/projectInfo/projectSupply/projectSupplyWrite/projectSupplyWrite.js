$(document).ready (function (){
	writeProjectSupply();

});

function writeProjectSupply(){
	var prjt_idx = $(".prjt_idx").val();
	$.ajax({
		method : "POST",
		url : "/projectSupply/listRun",
		data : { prjt_idx : prjt_idx},
		success: function(list){

			var str_html = "<form id='projectSupplyReadOne' action = '/prjectSupply/readOne' method='post'>";
			str_html += "<table class ='table'>";
			str_html += "<thead><tr>";
			str_html += "<th>지원목록번호</th>";
			str_html += "<th>프로젝트번호</th>";
			str_html += "</tr></thead>";			
			str_html += "<tbody>";
		$.each(list, function(index, value){
			str_html += "<tr onclick = 'readProjectSupply("+value.prjt_sup_list_idx+")'>";
			str_html += "<td>"+value.prjt_sup_list_idx+"</td>";
			str_html += "<td>"+value.prjt_idx+"</td>";
			str_html += "</a></tr>";				
		});
		str_html += "</tbody>";
		str_html += "</table>";
		str_html += "<div id = 'getIdx'></div>";
		str_html += "</form>";
		$(".SupplyList").html(str_html);		
	},
	error: function(){alert("ERROR");}
});
}
