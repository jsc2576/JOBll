$(document).ready (function (){
	findPrcs(0);
	
});


var prjt_idx = 0; // 현재 보여지고 있는 process stus 번호

//public method 

function findPrcs(prjt_idx){
	prjt_idx_num = prjt_idx;
	findData(prjt_idx_num);
}



// 데이터를 찾는 함수 data : {prjt_idx : prjt_idx},
function findData(prjt_idx){
	$.ajax({
		method	: "post",
		url		: "/prjtCnetList/run",
		success: function(list){
			str_html = "<table class=\"table table-bordered\"> ";
			str_html += "<thead><tr>";
			str_html += "<th>번호</th>";
			str_html += "<th>아이디</th>";
			str_html += "<th>프로젝트인덱스</th>";
			str_html += "<th>기관명</th>";
			str_html += "</tr></thead>";
			
			str_html += "<tbody>";
			var i=0;
			for(i=0; i<3; i++){
				str_html += "<tr>";
				str_html += "<td>"+list[i].prjt_cnet_list_idx+"</td>";
				str_html += "<td>"+list[i].usr_id+"</td>";
				str_html += "<td>"+list[i].prjt_idx+"</td>";
				str_html += "<td>"+list[i].cmpny_idx+"</td>";
				str_html += "</tr>";
			}	
			str_html += "</tbody>";
			str_html += "</table>";
			
			$("#data_list").html(str_html);
			},
		complete	: function () {
			//alert(str_html);
		},
		error		: function (a) {
			console.log(a);
			alert("prjtcnetlist ERROR");
		}
	});
			
}


//게시글을 클릭할때 form 전송 data(atcl_idx)를 생성해주는 함수
function prjtCnetList(idx) {
	
	var str_html = "<input type = 'hidden' name = 'atcl_idx' id = 'atcl_idx' value = "+idx+">";
	
	$("#getIdx").append(str_html);
	$("#prjtCnetListReadOne").submit();
}



