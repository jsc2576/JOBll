$(document).ready (function (){
	findData();
	
});




// 데이터를 찾는 함수 data : {prjt_idx : prjt_idx},
function findData(){
	var prjt_idx= $("#prjt_idx").val();
	$.ajax({
		method : "POST",
		url : "/prjtCnetList/check/read",
		data : {"prjt_idx" : prjt_idx},
		success: function(prjt_cnet_list){
			str_html = "<table class=\"table table-bordered\"> ";
			str_html += "<thead><tr>";
			str_html += "<th>번호</th>";
			str_html += "<th>아이디</th>";
			str_html += "<th>이름</th>";
			str_html += "<th>기관명</th>";
			str_html += "</tr></thead>";
			
			str_html += "<tbody>";
			var i=0;
			for(i=0; i<prjt_cnet_list.length; i++){
					var j=i+1;
					str_html += "<tr>";
					str_html += "<td>"+ j +"</td>";
					str_html += "<td>"+prjt_cnet_list[i].usr_id+"</td>";
					str_html += "<td>"+prjt_cnet_list[i].usr_nm+"</td>";
					str_html += "<td>"+prjt_cnet_list[i].cmpny_nm+"</td>";
					str_html += "</tr>";
			}	
			str_html += "</tbody>";
			str_html += "</table>";
			
			
			$("#list").html(str_html);
			},
		complete	: function () {
			//alert(list);
		},
		error		: function (a) {
			console.log(a);
			alert("prjtcnetlist ERROR");
		}
	});
			
}

