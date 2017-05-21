$(document).ready (function (){
	ProjectSupply();

});

function ProjectSupply(){
	var prjt_idx = $(".prjt_idx").val();
	$.ajax({
		method : "POST",
		url : "/projectSupply/readOne",
		data : { prjt_idx : prjt_idx},
		success: function(list){

			var str_html = "<form id='projectSupplyReadOne' action = '/projectSupply/readOne' method='post'>";
			$.each(list, function(index, value){
			});
		str_html += "<div id = 'getIdx'></div>";
		str_html += "</form>";
		$(".SupplyInfo").html(str_html);		
	},
	error: function(){alert("ERROR");}
});
}
