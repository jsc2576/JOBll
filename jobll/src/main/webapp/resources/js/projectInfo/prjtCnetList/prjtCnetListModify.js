$(document).ready (function (){
	findCnetListData();
});

var prjt_idx=0;


function viewTeamInv() {
	$("#dataSender").attr('action', "/teamPerson/check");
	$("#dataSender").submit();
}


function dualListBox(){
	$('select[name="duallistbox_demo1[]"]').bootstrapDualListbox();
    $("#demoform").submit(function() {
    	var str_temp = "";
    	str_temp += $('[name="duallistbox_demo1[]"]').val();
    	prjt_idx = $("#prjt_idx").val();
    	//store invited prjtCnet into prjtCnetInvList array
    	var  prjtCnetInvList = str_temp.split(",");
	    	
		$.ajax({
   			method   : "post",
   			url: "/teamPerson/inv.json",
   			data	: {prjtCnetInvList : prjtCnetInvList, prjt_idx : prjt_idx},
   			success: function()	{
   				viewTeamInv();
   			},
   			error		: function (usr_id) {
   				alert("duallist submit error");
			}
		});
    	return false;
    });
    console.log( "ready!" );
}



// 데이터를 찾는 함수 data : {prjt_idx : prjt_idx},
function findCnetListData(prjt_idx){
	prjt_idx = $("#prjt_idx").val();
	$.ajax({
		method	: "post",
		url		: "/prjtCnetList/run",
		data : {"prjt_idx" : prjt_idx},
		success: function(cnet_list){
		$.ajax({
			method	: "post",
			url		: "/prjtCnetList/CnetList.json",
			success: function(usr_list){
				str_html ="<form id=\"demoform\" action=\"#\" method=\"post\">";
				str_html += "<select multiple=\"multiple\" size=\"10\" name=\"duallistbox_demo1[]\">";
				var i=0;
				var j=0;
				for(i=0; i<usr_list.length; i++){
					//<option value="usr_id" " selected="selected">usr_id : usr_nm </option>
					str_html += "<option value=\"";
				    str_html += usr_list[i].usr_id;
				    for(j=0; j<cnet_list.length; j++){
				    	if(cnet_list[j].usr_id == usr_list[i].usr_id){
				    		str_html += "\" selected=\"selected";
				    		}
				    }
				    str_html += "\">";
				    str_html += usr_list[i].usr_id;
				    str_html += " : ";
				    str_html += usr_list[i].usr_nm;
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
	});
			
}
