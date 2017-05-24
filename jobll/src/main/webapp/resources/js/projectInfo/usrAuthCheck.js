$(document).ready (function (){
	checkAuth();
	getUsrIdAndLvCheck();
});

var Auth_data;

function checkAuth(){

	$.ajax({
		method : "POST",
		url : "/projectInfo/checkAuth",
		data : {},
		success: function(data){
			if(data < 2)
			$(".ManagerLv").remove();
			if(data < 3)
			$(".AdminLv").remove();
		},
		error: function(){alert("ERROR");}
	});
}

function getUsrIdAndLvCheck() {
	var usr_id = $(".usr_id").val();
	
	$.ajax({
		method : "POST",
		url : "/projectInfo/getUsrIdAndLv",
		data : {},
		success: function(data){
			if(data.usr_lv < 3 && data.usr_id != usr_id)
			{
				$(".Others").remove();
			}
			
		},
		error: function(){alert("ERROR");}
	});
}

function getUsrIdAndLv() {
	$.ajax({
		method : "POST",
		url : "/projectInfo/getUsrIdAndLv",
		data : {},
		success: function(data){
			Auth_data = data;
		},
		error: function(){alert("ERROR");}
	});
}
