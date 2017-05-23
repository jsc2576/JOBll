$(document).ready (function (){
	writeQst();

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