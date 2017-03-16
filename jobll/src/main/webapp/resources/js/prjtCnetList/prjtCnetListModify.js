$(document).ready (function (){
	findCnetList(0);
});


var prjt_idx = 0; // 현재 보여지고 있는 process stus 번호

//public method 

function findCnetList(prjt_idx){
	prjt_idx_num = prjt_idx;
	findCnetListData(prjt_idx_num);
}


function dualListBox(){
	var demo1 = $('select[name="duallistbox_demo1[]"]').bootstrapDualListbox();
	    $("#demoform").submit(function() {
	      alert($('[name="duallistbox_demo1[]"]').val());
	      return false;
	    });
	    console.log( "ready!" );
	}



// 데이터를 찾는 함수 data : {prjt_idx : prjt_idx},
function findCnetListData(prjt_idx){
	$.ajax({
		method	: "post",
		url		: "/prjtCnetList/CnetList.json",
		success: function(list){
			str_html ="<form id=\"demoform\" action=\"#\" method=\"post\">";
			str_html += "<select multiple=\"multiple\" size=\"10\" name=\"duallistbox_demo1[]\">";
			var i=0;
			for(i=0; i<list.length; i++){
				str_html += "<option value=\"";
			    str_html += list[i].usr_id;
			    str_html += "\">";
				str_html += list[i].usr_id;
				str_html += " : ";
				str_html += list[i].usr_nm;
				str_html += "</option>";
			}
			str_html += "</select>";
			str_html += "<button type=\"submit\" class=\"btn btn-default btn-block\">";
			str_html += "확인</button>";
			str_html += "</form>";
			
			$("#list").html (str_html);
			},
		complete	: function () {
			dualListBox();
		},
		error		: function (a) {
			console.log(a);
		}
	});
			
}



