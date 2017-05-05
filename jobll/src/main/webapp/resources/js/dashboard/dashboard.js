$(document).ready(function(){
	Cunt_Prjt();
	Cnet_Prjt();
});

function Cunt_Prjt(){
	
	$.ajax({
		method: "POST",
		url: "/cuntPrjt/check/read",
		success:function(list){
			var str_html = "<table class = 'cunt_prjt'>";
			str_html += "<thead><tr>";
			str_html += "<th>최근 프로젝트</th>";
			str_html += "</tr></thead>";
		
			str_html += "<tbody>";
			$.each(list, function(index, data){
				str_html += "<td>";
				str_html += data;
				str_html += "</td>";
			});
			
			str_html += "</tbody> </table>";
			$("#cunt_list").html(str_html);
		},
		error: function(){alert("ERROR")}
	});
}

function Cnet_Prjt(){
	
	$.ajax({
		method: "POST",
		url: "/centPrjt/check/read",
		success: function(list){
			var str_html = "";
			
			$.each(list, function(index, data){
				str_html += "<option>";
				str_html += data;
				str_html += "</option>";
			});
			
			$("#cnet_prjt").html(str_html);
		},
		error: function(){alert("ERROR")}
	});
}