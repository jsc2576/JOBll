$(document).ready (function (){
	myUsrInfo();
	myProject();
	
});


function myProject() {
	var usr_id = $("#usr_id").val();
	$.ajax ({
		method	: "post",
		url		: "/usrInfo/prjt/read",
		data : {"usr_id" : usr_id},
		success	: function (list) {
				str_html ="<section id=\"MyPrjtInfo-tag\">"
				str_html +="<table class = \"table table-striped custom-table\">";
				str_html +="<tr><th colspan = '5'>참여 프로젝트</th></tr>";
				//str_html +="<tr>";
				var i=0;
				str_html +="<tr align='left'><td>";
				for(i=0; i<list.length; i++){
					
					str_html +=list[i].prjt_sbjt;
					str_html +="<br>";

				}
				str_html +="</td></tr>";
				str_html +="<tr><td><br></td></tr>";
				str_html +="</table></section>";
				str_html +="<br><br><br><br>";
				$("#myPrjtInfo").html (str_html);
		},
		complete	: function () {
			
		},
		error		: function (a) {
			console.log(a);
		}
	})	
}


function myUsrInfo() {
	

	var usr_id = $("#usr_id").val();
	
		$.ajax ({
			method	: "post",
			url		: "/usrInfo/myUsrInfo/read",
			data : {"usr_id" : usr_id},
			success	: function (list) {
				str_html ="<section id=\"MyUsrInfo-tag\">"
				str_html +="<table class = \"table table-striped custom-table\">";
				str_html +="<tr><th colspan = '5'>회원정보</th></tr>";
				str_html +="<tr><th colspan = '1' rowspan = '4'><img src=\"../resources/images/usrInfo/myUsrInfo/baseprofile.png\" style=\"max-width: 100%; height: 30%;\"></th>";
				
				str_html +="<th class = 'th-15'>ID</th>";
				str_html +="<td colspan = '2'>";
				str_html +=list.usr_id;
				str_html +="</td></tr>";
				str_html +="<tr><th class = 'th-15'>이름</th>";
				str_html +="<td colspan = '2'>";
				str_html +=list.usr_nm;
				str_html +="</td></tr>";
				str_html +="<tr><th class = 'th-15'>Email</th>";
				str_html +="<td colspan = '2'>";
				str_html +=list.usr_email;
				str_html +="</td></tr>";
				str_html +="<tr><th class = 'th-15'>가입날짜</th>";
				str_html +="<td colspan = '2'>";
				str_html +=list.reg_date;
				str_html +="</td></tr>";
				str_html +="<tr><th class ='th-15'>권한";
				str_html +="</th><td>";
				str_html +=list.usr_lv;
				str_html +="</td>";
				str_html +="<th class = 'th-15'>회사</th>";
				str_html +="<td>";
				str_html +=list.usr_pwd;
				str_html +="</td></tr>";
				str_html +="<tr><th class ='th-15'>전화번호</th>";
				str_html +="<td>";
				str_html +=list.tel_num;
				str_html +="</td><th class ='th-15'>핸드폰번호</th>";
				str_html +="<td>";
				str_html +=list.mobile_num;
				str_html +="</td></tr>";
				//str_html +="</table></section>";
				
				//str_html +="<br><br><br><br><br><br><br>";
				
			
				
				$("#myUsrInfo").html (str_html);
			},
			complete	: function () {
				
			},
			error		: function (a) {
				console.log(a);
			}
		});
}