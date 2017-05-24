$(document).ready (function (){
	myUsrInfo();
	myProject();
	
});

function readProjectInfo(idx){
	
	var str_html = "<input type ='hidden' name = 'prjt_idx' value = '"+idx+"'>";
	
	$("#hidden").html(str_html);
	
	$("#projectInfo").submit();

}
function myProject() {
	var usr_id = $("#usr_id").val();
	$.ajax ({
		method	: "post",
		url		: "/usrInfo/prjt/read",
		data : {"usr_id" : usr_id},
		success	: function (list) {
			var str_html = "<div class='row'>" +
		    "<div class='col-lg-12'>" +
	          "<div class='panel panel-default'>" +
	            "<div class='panel-heading'>";
				
				str_html += "참여 프로젝트 리스트";
				   
				str_html +=  "</div>" +
	            "<!-- /.panel-heading -->" +
	            "<div class='panel-body'>" +
	                "<table width='80%' class='prjt-table table table-striped table-bordered table-hover' id='dataTables-example'>" +
	                    "<thead>" +
	                        "<tr>" +
	                            "<th>No.</th>" +
	                            "<th>사업명</th>" +
	                            "<th>등록 날짜</th>" +
	                            "<th>담당자</th>";
							str_html += "</tr>" +
	                    "</thead>" +
	                    "<tbody>";
							for(var i = 0; i < list.length; i++)
							{
								str_html += "<tr class="+(i+1)+" onclick = 'readProjectInfo("+list[i].prjt_idx+")'>" +
											"<td>"+(i+1)+"</td>" +
											"<td>"+list[i].prjt_sbjt+"</td>" +
											"<td>"+list[i].reg_date+"</td>" +
											"<th>"+list[i].usr_id+"</th>";	
											str_html += "</tr>";
							}
				
				str_html += "</tbody>" +
	                "</table>" +
	            "</div>" +
	            "<!-- /.panel-body -->";
	            
	            str_html += "</div>" +
	        "<!-- /.panel -->" +
	    "</div>" +
	    "<!-- /.col-lg-6 -->" +
	"</div>" +
	"<!-- /.row -->";


			$("#myPrjtInfo").html(str_html);	
			/*
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
				$("#myPrjtInfo").html (str_html);*/
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
				str_html +="<tr><th colspan = '1' rowspan = '4'><img src=\"../resources/images/usrInfo/myUsrInfo/baseprofile.png\" style=\"max-width: 50%; height: 30%;\"></th>";
				
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
				str_html += "<select class ='usr_lv' name = 'usr_lv'>";
				for(var i = 1; i < 4; i++)
				{	
					if(list.usr_lv == i)
					str_html += "<option selected value = "+i+">"+i+"</option>";
					else
						str_html += "<option value = "+i+">"+i+"</option>";
				}
				str_html += "</select>"
				str_html += "<button onclick = 'changeUsrLv()'>변경</button>";
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
function changeUsrLv() {
	var usr_id = $("#usr_id").val();
	var usr_lv = $(".usr_lv").val();
	
	$.ajax ({
		method	: "post",
		url		: "/usrInfo/changeUsrLv",
		data : {usr_id : usr_id, usr_lv : usr_lv},
		success	: function (list) {
			alert("변경되었습니다.")
		},
		complete	: function () {
			
		},
		error		: function (a) {
			console.log(a);
		}
	});
	
}