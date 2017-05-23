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

			var str_html = "<form id='projectSupplyReadOne' action = '/projectSupply/readOne' method='post'>";
			$.each(list, function(index, value){
			});
		str_html += "<div id = 'getIdx'></div>";
		str_html += "</form>";
		$(".SupplyList").html(str_html);		
	},
	error: function(){alert("ERROR");}
});
}
