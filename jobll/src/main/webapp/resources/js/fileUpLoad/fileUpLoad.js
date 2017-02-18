var img_num = 0;
$(document).ready (function (){
	
});
function delUpload(){
	img_num--;
	 $("#file-upload").remove();
}
function addUpload(){
	img_num++;
	$("#uploads").append('<p/><input type="file" id="file-upload"  name="uploadFile" /></p> ');
}

function fileUpload() {
	$('#fileUpLoadForm').ajaxForm	({
		url: "/attchFile/testFileUpLoadRun",
		enctype: "multipart/form-data",
		success: function(result)	{
			alert("success!");
		}
	});
	$("#fileForm").submit();
}

function fileDownLoad(data,name) {
	
	
	
	$.ajax ({
		method	: "post",
		url		: "/attchFile/testFileDownLoadRun",
		data	: { file_path : data , attch_file_nm : name},
		
		error		: function (a) {
			console.log(a);
		}
	});

}

function fileUploadView() {
		$.ajax ({
			method	: "post",
			url		: "/attchFile/testFileDownLoadList",
			data	: {usr_id : "bbk"},
			success	: function (list) {
				str_html = "<table class = 'table table-striped' border ='1'>";
				str_html += "<tr>";
				str_html += "<th>파일명</th>";
				str_html += "<th>파일크기</th>";
				str_html += "<th>파일형식</th>";
				str_html += "</tr>";
				for (var i = 0; i < list.length; i++) {
					str_html += "<tr>";
					str_html += "<td><a href ='https://s3.ap-northeast-2.amazonaws.com/elasticbeanstalk-ap-northeast-2-190235634467/"+list[i].file_path+"'>"+list[i].attch_file_nm+"</a></td>";
					str_html += "<td>"+list[i].attch_file_vol+"</td>";
					switch(list[i].file_typ)
					{
						case 1:
						{
							str_html += "<td>image</td>";
							break;
						}
						case 2:
						{
							str_html += "<td>audio</td>";
							break;
						}
						case 3:
						{
							str_html += "<td>vedio</td>";
							break;
						}
						case 4:
						{
							str_html += "<td>others</td>";
							break;
						}
					}
					
					str_html += "</tr>";
				}
				str_html += "</table>";
				$("#list").html (str_html);
			},
			complete	: function () {
				
			},
			error		: function (a) {
				console.log(a);
			}
		});

}
