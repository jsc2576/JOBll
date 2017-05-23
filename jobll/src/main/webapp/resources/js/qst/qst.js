$(document).ready (function (){
	InfoQst();

});

function InfoQst(){
	$.ajax({
		method : "POST",
		url : "/qstList/read",
		data : {},
		success: function(list){

			var str_html = "<form id='qstRead' action = '/qstList/read' method='post'>";
			$.each(list, function(index, value){
			});
		str_html += "</form>";
		$(".Infoqst").html(str_html);		
	},
	error: function(){alert("ERROR");}
	});
}